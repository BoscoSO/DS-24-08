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

    //recibe una lista ya filtrada, o null si es la primera vez, un clausula para unir esa lista con la próxima, o null si es la primera vez
    //una lista de filtros que aplicar y una clausula con la que combinar esos filtros (todos)
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


}
