package e2.logic;

import e2.dto.Anuncio;
import e2.dto.Apartamento;
import e2.util.AnuncioComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorData {

    private Comparator<Anuncio> comparador = null;
    private List<Anuncio> anuncios = new ArrayList<Anuncio>();
    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }



    public void ordenarAnuncios(AnuncioComparator.MetodoComparar metodo,boolean inverso) {
        if(metodo==null)metodo= AnuncioComparator.MetodoComparar.NATURAL;
        comparador=new AnuncioComparator(metodo,inverso);
        anuncios.sort(comparador);
    }

    public String mostrarAnuncios() {
        if(comparador==null)ordenarAnuncios(null,false);

        StringBuilder cad = new StringBuilder();
        for (Anuncio a : anuncios) {
            cad.append(a.toString()).append("\n");
        }
        return cad.toString();
    }

    public static void main(String[] args) {
        GestorData g=new GestorData();
        List<Anuncio> anuncios = new ArrayList<Anuncio>();
        anuncios.add(new Anuncio(1,100,123,new Apartamento(3,15701,34,2,1,23,'S')));
        anuncios.add(new Anuncio(2,200,123,new Apartamento(2,15701,24,6,1,23,'S')));
        anuncios.add(new Anuncio(3,150,0,new Apartamento(2,15701,340,2,1,23,'S')));

        g.setAnuncios(anuncios);
        System.out.println(g.mostrarAnuncios());

        System.out.println("\n****PRECIO_BASE*****\n");
        g.ordenarAnuncios(AnuncioComparator.MetodoComparar.PRECIO_BASE,true);
        System.out.println(g.mostrarAnuncios());

        System.out.println("\n****PRECIO_TOTAL****\n");
        g.ordenarAnuncios(AnuncioComparator.MetodoComparar.PRECIO_TOTAL,true);
        System.out.println(g.mostrarAnuncios());

        System.out.println("\n****NUM_HABITACIONES*****\n");
        g.ordenarAnuncios(AnuncioComparator.MetodoComparar.NUM_HABITACIONES,true);
        System.out.println(g.mostrarAnuncios());

        System.out.println("\n****TAMANO*****\n");
        g.ordenarAnuncios(AnuncioComparator.MetodoComparar.TAMANO,true);
        System.out.println(g.mostrarAnuncios());



    }
}
