

import e1.integrante.personal.Docente;
import e1.integrante.personal.GuardaBosques;
import e1.integrante.residentes.Estudiante;
import e2.dto.Anuncio;
import e2.dto.Apartamento;
import e2.logic.GestorData;
import e2.util.AnuncioComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApartamentosTest {
    private GestorData g;

    @BeforeEach
    void setup() {
        g = new GestorData();
        List<Anuncio> anuncios = new ArrayList<Anuncio>();
        Apartamento a1=new Apartamento(3,15701,95,2,1,23,'B');
        Apartamento a2=new Apartamento(3,15702,130,3,1,64,'A');
        Apartamento a3=new Apartamento(3,15703,130,3,2,36,'C');
        Apartamento a4=new Apartamento(3,15704,300,4,2,12,'A');


        anuncios.add(new Anuncio(1,140,103,a1));
        anuncios.add(new Anuncio(2,170,90,a1));
        anuncios.add(new Anuncio(3,170,90,a2));
        anuncios.add(new Anuncio(4,150,100,a2));
        anuncios.add(new Anuncio(5,150,100,a3));
        anuncios.add(new Anuncio(6,80,75,a4));
        anuncios.add(new Anuncio(7,100,123,a4));
        anuncios.add(new Anuncio(8,100,123,a4));

        g.setAnuncios(anuncios);

    }

    @Test
    public void ordenacionesTest() {

        assertEquals("""
                Anuncio [1]
                Anuncio [2]
                Anuncio [3]
                Anuncio [4]
                Anuncio [5]
                Anuncio [6]
                Anuncio [7]
                Anuncio [8]
                """,g.mostrarAnuncios());
        assertEquals("""
                Anuncio [1]
                Anuncio [2]
                Anuncio [3]
                Anuncio [4]
                Anuncio [5]
                Anuncio [6]
                Anuncio [7]
                """,g.mostrarAnunciosDistintos());

        g.ordenarAnuncios(AnuncioComparator.MetodoComparar.PRECIO_BASE,true);
        assertEquals("""
                Anuncio [2]
                Anuncio [3]
                Anuncio [4]
                Anuncio [5]
                Anuncio [1]
                Anuncio [7]
                Anuncio [8]
                Anuncio [6]
                """,g.mostrarAnuncios());
        g.ordenarAnuncios(AnuncioComparator.MetodoComparar.PRECIO_TOTAL,true);
        assertEquals("""
                Anuncio [7]
                Anuncio [8]
                Anuncio [4]
                Anuncio [5]
                Anuncio [1]
                Anuncio [2]
                Anuncio [3]
                Anuncio [6]
                """,g.mostrarAnuncios());
        g.ordenarAnuncios(AnuncioComparator.MetodoComparar.NUM_HABITACIONES,true);
        assertEquals("""
                Anuncio [7]
                Anuncio [8]
                Anuncio [6]
                Anuncio [5]
                Anuncio [4]
                Anuncio [3]
                Anuncio [1]
                Anuncio [2]
                """,g.mostrarAnuncios());


        g.ordenarAnuncios(AnuncioComparator.MetodoComparar.TAMANO,true);
        assertEquals("""
                Anuncio [7]
                Anuncio [8]
                Anuncio [6]
                Anuncio [5]
                Anuncio [4]
                Anuncio [3]
                Anuncio [1]
                Anuncio [2]
                """,g.mostrarAnuncios());
        assertEquals("""
                Anuncio [7]
                Anuncio [6]
                Anuncio [5]
                Anuncio [4]
                Anuncio [3]
                Anuncio [1]
                Anuncio [2]
                """,g.mostrarAnunciosDistintos());
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

}
