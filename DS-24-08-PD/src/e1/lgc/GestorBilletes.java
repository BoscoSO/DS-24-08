package e1.lgc;

import e1.dto.Billete;
import e1.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestorBilletes {
    public enum Clausula {
        AND {
            @Override
            public boolean isBoth() {
                return true;
            }

            @Override
            public List<Billete> perform(List<Billete> l1, List<Billete> l2) {
                if (l1 == null || l2 == null) throw new IllegalArgumentException("Parametro nulo");
                l1.retainAll(l2);
                return l1;
            }
        },
        OR {
            @Override
            public boolean isBoth() {
                return false;
            }

            @Override
            public List<Billete> perform(List<Billete> l1, List<Billete> l2) {
                if (l1 == null || l2 == null) throw new IllegalArgumentException("Parametro nulo");
                l1.addAll(l2);
                return l1;
            }

        };

        public abstract boolean isBoth();

        public abstract List<Billete> perform(List<Billete> l1, List<Billete> l2);
    }

    private List<Billete> billetes = new ArrayList<>();

    public void setBilletes(List<Billete> billetes) {
        this.billetes = billetes;
    }

    public List<Billete> filtra(List<Billete> b1, Clausula clausula, List<FiltroBilletes> filtros, Clausula clausulaFiltros) throws IllegalStateException, IllegalArgumentException { //recomendamos de 2 en 2, pero podrian ser mas
        if (billetes.isEmpty()) throw new IllegalStateException("No hay billetes que filtrar");
        if (filtros == null || clausulaFiltros == null)
            throw new IllegalArgumentException("parametro nulo");
        if (filtros.size() < 1) throw new IllegalArgumentException("No hay filtros");

        List<Billete> aux = new ArrayList<>();

        if (clausulaFiltros.isBoth()) {
            aux.addAll(billetes);
            for (FiltroBilletes f : filtros)
                aux.retainAll(f.filtrar(billetes));

        } else {
            for (FiltroBilletes f : filtros)
                aux.addAll(f.filtrar(billetes));

            aux = distinct(aux);
        }

        b1=Objects.requireNonNullElse(b1, billetes);
        clausula=Objects.requireNonNullElse(clausula, Clausula.AND);
        clausula.perform(aux, b1);

        return distinct(aux);

    }

    private List<Billete> distinct(List<Billete> list) {
        List<Billete> laux = new ArrayList<>();
        for (Billete o : list) {
            if (!laux.contains(o))
                laux.add(o);
        }
        return laux;
    }

    public static void main(String[] args) {
        GestorBilletes gb=new GestorBilletes();
        List<Billete> billetes=new ArrayList<>();
        double precio=6.43;
        for(int i=0;i<5;i++) {
            billetes.add(new Billete(precio, "Lugo", "Coruña", "14/04/21"));
            billetes.add(new Billete(precio, "Lugo", "Orense", "10/04/21"));
            billetes.add(new Billete(precio, "Lugo", "Santiago", "10/04/21"));
            billetes.add(new Billete(precio, "Lugo", "Vigo", "12/04/21"));
            precio+=6;
            billetes.add(new Billete(precio, "Coruña", "Lugo", "14/04/21"));
            billetes.add(new Billete(precio, "Coruña", "Orense", "09/04/21"));
            billetes.add(new Billete(precio, "Coruña", "Santiago", "18/04/21"));
            billetes.add(new Billete(precio, "Coruña", "Vigo", "10/04/21"));

            billetes.add(new Billete(precio, "Orense", "Lugo", "14/04/21"));
            billetes.add(new Billete(precio, "Orense", "Coruña", "12/04/21"));
            billetes.add(new Billete(precio, "Orense", "Santiago", "11/04/21"));
            billetes.add(new Billete(precio, "Orense", "Vigo", "09/04/21"));
            precio+=6;
            billetes.add(new Billete(precio, "Santiago", "Lugo", "09/04/21"));
            billetes.add(new Billete(precio, "Santiago", "Coruña", "18/04/21"));
            billetes.add(new Billete(precio, "Santiago", "Orense", "08/04/21"));
            billetes.add(new Billete(precio, "Santiago", "Vigo", "14/04/21"));

            billetes.add(new Billete(precio, "Vigo", "Lugo", "16/04/21"));
            billetes.add(new Billete(precio, "Vigo", "Coruña", "12/04/21"));
            billetes.add(new Billete(precio, "Vigo", "Orense", "15/04/21"));
            billetes.add(new Billete(precio, "Vigo", "Santiago", "17/04/21"));
            precio+=5;
        }
        gb.setBilletes(billetes);

        List<Billete> l = null;
        l=gb.filtra(null,null,List.of(new FiltroOrigen("Coruña"),new FiltroDestino("Santiago")),Clausula.OR);

        l=gb.filtra(l,Clausula.AND,List.of(new FiltroFecha("17/04/21"),new FiltroFecha("18/04/21"),new FiltroFecha("10/04/21")),Clausula.OR);

        l=gb.filtra(l,Clausula.AND,List.of(new FiltroPrecio(46.43,List.of(FiltroPrecio.Tipo.IGUAL, FiltroPrecio.Tipo.MAYOR))),Clausula.OR);
        for(Billete b:l){
            System.out.println(b.toString());
        }
        /*
        l=gb.filtra(null,null,List.of(new FiltroOrigen("Coruña"),new FiltroOrigen("Santiago")),Clausula.OR);


        l=gb.filtra(l,Clausula.AND,List.of(new FiltroDestino("Orense")),Clausula.OR);


        l=gb.filtra(l,Clausula.AND,List.of(new FiltroPrecio(28,List.of(FiltroPrecio.Tipo.MENOR, FiltroPrecio.Tipo.IGUAL))),Clausula.OR);



        l=gb.filtra(l,Clausula.AND,List.of(new FiltroFecha("08/04/21"),new FiltroFecha("09/04/21")),Clausula.OR);

        for(Billete b:l){
            System.out.println(b.toString());
        }
        */

    }
}
