package e2;

import e2.dto.Anuncio;
import e2.dto.Apartamento;
import e2.logic.GestorData;
import e2.util.ComparatorNatural;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApartamentosTest {
    private GestorData g;

    private Anuncio add1,add2,add3,add4,add5,add6,add7,add8;
    @BeforeEach
    void setup() {
        g = new GestorData();
        List<Anuncio> anuncios = new ArrayList<>();
        Apartamento a1=new Apartamento(3,15701,95,2,1,23,'B');
        Apartamento a2=new Apartamento(3,15702,130,3,1,64,'A');
        Apartamento a3=new Apartamento(3,15703,130,3,2,36,'C');
        Apartamento a4=new Apartamento(3,15704,300,4,2,12,'A');

        add1=new Anuncio(1,140,103,a1);
        add2=new Anuncio(2,170,90,a1);
        add3=new Anuncio(3,170,90,a2);
        add4=new Anuncio(4,150,100,a2);
        add5=new Anuncio(5,150,100,a3);
        add6=new Anuncio(6,80,75,a4);
        add7=new Anuncio(7,100,123,a4);
        add8=new Anuncio(8,100,123,a4);

        anuncios.add(add1);
        anuncios.add(add2);
        anuncios.add(add3);
        anuncios.add(add4);
        anuncios.add(add5);
        anuncios.add(add6);
        anuncios.add(add7);
        anuncios.add(add8);
        g.setAnuncios(anuncios);

    }

    @Test
    public void ordenaciones1Test() {

        //Metodo Natural
        List<Anuncio> testadds = new ArrayList<>();
        testadds.add(add1);testadds.add(add2);testadds.add(add3);testadds.add(add4);
        testadds.add(add5);testadds.add(add6);testadds.add(add7);testadds.add(add8);
        assertEquals(testadds,g.getAnunciosOrdenados());

        testadds.remove(add8);
        assertEquals(testadds,g.getAnunciosDistintosOrdenados());
        testadds.clear();
        testadds.add(add8);testadds.add(add7);testadds.add(add6);testadds.add(add5);
        testadds.add(add4);testadds.add(add3);testadds.add(add2);testadds.add(add1);
        g.ordenarAnuncios(GestorData.MetodoComparar.NATURAL,true);
        assertEquals(testadds,g.getAnunciosOrdenados());

        //Metodo Precio Base
        testadds.clear();
        testadds.add(add2);testadds.add(add3);testadds.add(add4);testadds.add(add5);
        testadds.add(add1);testadds.add(add7);testadds.add(add8);testadds.add(add6);
        g.ordenarAnuncios(GestorData.MetodoComparar.PRECIO_BASE,true);
        assertEquals(testadds,g.getAnunciosOrdenados());
        testadds.clear();
        testadds.add(add6);testadds.add(add7);testadds.add(add8);testadds.add(add1);
        testadds.add(add4);testadds.add(add5);testadds.add(add2);testadds.add(add3);
        g.ordenarAnuncios(GestorData.MetodoComparar.PRECIO_BASE,false);
        assertEquals(testadds,g.getAnunciosOrdenados());

        //Metodo Precio Total
        testadds.clear();
        testadds.add(add7);testadds.add(add8);testadds.add(add4);testadds.add(add5);
        testadds.add(add1);testadds.add(add2);testadds.add(add3);testadds.add(add6);
        g.ordenarAnuncios(GestorData.MetodoComparar.PRECIO_TOTAL,true);
        assertEquals(testadds,g.getAnunciosOrdenados());
        assertEquals(g.mostrarAnuncios(testadds),g.mostrarAnuncios(g.getAnunciosOrdenados()));
        testadds.clear();
        testadds.add(add6);testadds.add(add2);testadds.add(add3);testadds.add(add1);
        testadds.add(add4);testadds.add(add5);testadds.add(add7);testadds.add(add8);
        g.ordenarAnuncios(GestorData.MetodoComparar.PRECIO_TOTAL,false);
        assertEquals(testadds,g.getAnunciosOrdenados());


        //Metodo Num Habitaciones
        testadds.clear();
        testadds.add(add1);testadds.add(add2);testadds.add(add3);testadds.add(add4);
        testadds.add(add5);testadds.add(add6);testadds.add(add7);testadds.add(add8);
        g.ordenarAnuncios(GestorData.MetodoComparar.NUM_HABITACIONES,false);
        assertEquals(g.mostrarAnuncios(testadds),g.mostrarAnuncios(g.getAnunciosOrdenados()));
        testadds.clear();
        testadds.add(add6); testadds.add(add7);testadds.add(add8); testadds.add(add5);
        testadds.add(add3);testadds.add(add4); testadds.add(add1);testadds.add(add2);
        g.ordenarAnuncios(GestorData.MetodoComparar.NUM_HABITACIONES,true);
        assertEquals(testadds,g.getAnunciosOrdenados());
        assertEquals(g.mostrarAnuncios(testadds),g.mostrarAnuncios(g.getAnunciosOrdenados()));


        //Metodo Tamaño
        testadds.clear();
        testadds.add(add6);testadds.add(add7);testadds.add(add8);testadds.add(add3);
        testadds.add(add4);testadds.add(add5);testadds.add(add1);testadds.add(add2);
        g.ordenarAnuncios(GestorData.MetodoComparar.TAMANO,true);
        assertEquals(g.mostrarAnuncios(testadds),g.mostrarAnuncios(g.getAnunciosOrdenados()));
        testadds.clear();
        testadds.add(add1);testadds.add(add2); testadds.add(add3);testadds.add(add4);
        testadds.add(add5);testadds.add(add6);testadds.add(add7);testadds.add(add8);
        g.ordenarAnuncios(GestorData.MetodoComparar.TAMANO,false);
        assertEquals(g.mostrarAnuncios(testadds),g.mostrarAnuncios(g.getAnunciosOrdenados()));




        //Metodo null
        testadds.clear();
        testadds.add(add1);testadds.add(add2);testadds.add(add3);testadds.add(add4);
        testadds.add(add5);testadds.add(add6);testadds.add(add7);
        g.ordenarAnuncios(null,false);
        assertEquals(g.mostrarAnuncios(testadds),g.mostrarAnuncios(g.getAnunciosDistintosOrdenados()));
        testadds.add(add8);
        assertEquals(g.mostrarAnuncios(testadds),g.mostrarAnuncios(g.getAnunciosOrdenados()));
        assertEquals("",g.mostrarAnuncios(null));
    }

    @Test
    public void ordenaciones2Test() {

        List<Anuncio> testadds = new ArrayList<>();
        testadds.add(add1);testadds.add(add2);testadds.add(add3);testadds.add(add4);
        testadds.add(add5);testadds.add(add6);testadds.add(add7);
        assertEquals(testadds, g.getAnunciosDistintosOrdenados());

        testadds = new ArrayList<>();
        testadds.add(add2);testadds.add(add3);testadds.add(add4);testadds.add(add5);
        testadds.add(add1);testadds.add(add7);testadds.add(add8);testadds.add(add6);
        g.ordenarAnuncios(GestorData.MetodoComparar.PRECIO_BASE, true);
        assertEquals(testadds, g.getAnunciosOrdenados());
    }
    @Test
    void testExceptions() {
        Apartamento aux=new Apartamento(3,15704,300,4,2,12,'A');

        assertThrows(IllegalArgumentException.class, () ->new Anuncio(1,140,103,null)); // apartamento null
        assertThrows(IllegalArgumentException.class, () ->new Anuncio(1,0,103,aux));//precio base 0 o negativo
        assertThrows(IllegalArgumentException.class, () ->new Anuncio(1,140,-12,aux));//precio plza garaje negativo
        assertThrows(IllegalArgumentException.class, () ->new Anuncio(-23,140,103,aux));//id referencia negativo

        assertThrows(IllegalArgumentException.class, () ->new Apartamento(-5,15704,300,4,2,12,'A'));// plazas negativas
        assertThrows(IllegalArgumentException.class, () ->new Apartamento(3,15704,0,1,2,12,'A'));// dimensiones 0 o negativas
        assertThrows(IllegalArgumentException.class, () ->new Apartamento(3,15704,300,0,2,12,'A'));// habitaciones 0 o negativas
        assertThrows(IllegalArgumentException.class, () ->new Apartamento(3,15704,300,4,0,12,'A'));//banos 0 o negativas

    }

    @Test
    void testEquals() {
        Apartamento aux1=new Apartamento(3,15704,300,4,2,12,'A');
        Apartamento aux2=new Apartamento(3,15704,300,4,2,15,'A');
        assertNotEquals(aux1,aux2);
        assertNotEquals(aux1,null);
        assertNotEquals(null,aux2);
        assertEquals(aux2,new Apartamento(3,15704,300,4,2,15,'A'));

        Anuncio a1 = new Anuncio(1,100,50,aux1);
        Anuncio a2 = new Anuncio(2,100,50,aux1);
        assertEquals(a1,a2);
        assertEquals(a1.hashCode(),a2.hashCode());
        a2 = new Anuncio(2,100,50,aux2);
        assertNotEquals(a1,a2);
        assertNotEquals(a1,null);
        assertNotEquals(null,a2);

        a2 = new Anuncio(2,100,55,aux1);
        assertNotEquals(a1,a2);


        assertEquals(add8,add7);
        assertEquals(add8.hashCode(),add7.hashCode());
        assertNotEquals(add1,add2);
        assertNotEquals(add1.hashCode(),add2.hashCode());
        assertNotEquals(add3,add4);
        assertNotEquals(add6,add8);

         a1 = new Anuncio(1,100,50,aux1);
         a2 = new Anuncio(1,150,50,aux2);

         assertEquals(0,a1.compareTo(a2));

    }
}
