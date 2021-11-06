package e2.logic;

import e2.dto.Anuncio;
import e2.util.AnuncioComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorData {

    private Comparator<Anuncio> comparador = null;
    private List<Anuncio> anuncios = new ArrayList<>();

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }


    public void ordenarAnuncios(AnuncioComparator.MetodoComparar metodo, boolean inverso) {
        if (metodo == null) metodo = AnuncioComparator.MetodoComparar.NATURAL;
        comparador = new AnuncioComparator(metodo, inverso);
        anuncios.sort(comparador);

    }

    public List<Anuncio> getAnunciosOrdenados() {
        if (comparador == null) ordenarAnuncios(null, false);
        return new ArrayList<>(anuncios);
    }

    public List<Anuncio> getAnunciosDistintosOrdenados() {
        if (comparador == null) ordenarAnuncios(null, false);
        List<Anuncio> aux = new ArrayList<>();
        for (Anuncio a : anuncios) {
            if (!aux.contains(a)) {
                aux.add(a);
            }
        }
        return aux;
    }

    public String mostrarAnuncios(List<Anuncio> anuncios) {
        if(anuncios==null) return "";
        StringBuilder cad = new StringBuilder();
        for (Anuncio a : anuncios)
            cad.append(a.toString()).append("\n");

        return cad.toString();
    }
}
