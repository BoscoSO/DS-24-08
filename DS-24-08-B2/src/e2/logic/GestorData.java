package e2.logic;

import e2.dto.Anuncio;
import e2.dto.Apartamento;
import e2.util.AnuncioComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestorData {

    private Comparator<Anuncio> comparador = null;
    private List<Anuncio> anuncios = new ArrayList<Anuncio>();

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }


    public void ordenarAnuncios(AnuncioComparator.MetodoComparar metodo, boolean inverso) {
        if (metodo == null) metodo = AnuncioComparator.MetodoComparar.NATURAL;
        comparador = new AnuncioComparator(metodo, inverso);
        anuncios.sort(comparador);

    }

    public String mostrarAnuncios() {
        if (comparador == null) ordenarAnuncios(null, false);

        StringBuilder cad = new StringBuilder();
        for (Anuncio a : anuncios) {
            cad.append(a.toString()).append("\n");
        }
        return cad.toString();
    }

    public String mostrarAnunciosDistintos() {
        if (comparador == null) ordenarAnuncios(null, false);
        List<Anuncio> anunciosmostrados = new ArrayList<>();
        StringBuilder cad = new StringBuilder();
        for (Anuncio a : anuncios) {
            if (!anunciosmostrados.contains(a)) {
                cad.append(a.toString()).append("\n");
                anunciosmostrados.add(a);
            }
        }
        return cad.toString();
    }
}
