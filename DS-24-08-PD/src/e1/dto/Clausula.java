package e1.dto;

import e1.util.FiltroBilletes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Clausula {
    AND {
        @Override
        public List<Billete> perform(List<List<Billete>>  listasBilletes) throws IllegalArgumentException{
            if (listasBilletes == null) throw new IllegalArgumentException("Parametro nulo");
            if (listasBilletes.size()<1) throw new IllegalArgumentException("Minimo un argumento");


            List<Billete> aux = new ArrayList<>(listasBilletes.get(0));

            for (List<Billete> l : listasBilletes)
                aux.retainAll(l);

            return aux;
        }
    },
    OR {
        @Override
        public List<Billete> perform(List<List<Billete>>  listasBilletes) throws IllegalArgumentException{
            if (listasBilletes == null) throw new IllegalArgumentException("Parametro nulo");
            if (listasBilletes.size()<1) throw new IllegalArgumentException("Minimo un argumento");

            List<Billete> aux = new ArrayList<>();

            for (List<Billete> l : listasBilletes)
                aux.addAll(l);

            return distinct(aux);
        }

    };

    public abstract List<Billete> perform(List<List<Billete>>  listasBilletes) throws IllegalArgumentException;//minimo 2 elementos el primero siempre la lista entera

    List<Billete> distinct(List<Billete> list) {
        List<Billete> laux = new ArrayList<>();
        for (Billete o : list) {
            if (!laux.contains(o))
                laux.add(o);
        }
        return laux;
    }
}