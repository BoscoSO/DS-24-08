package e1;

import e1.dto.Billete;
import e1.dto.Clausula;
import e1.lgc.GestorBilletes;
import e1.util.FiltroDestino;
import e1.util.FiltroFecha;
import e1.util.FiltroOrigen;
import e1.util.FiltroPrecio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class BilletesTest {

    private GestorBilletes gb;
    private Billete b1, b2, b3, b4, b5, b6, b7, b8;

    @BeforeEach
    void setUp() {
        b1 = new Billete(8.90, "Santiago", "Lugo", "12/04/21");
        b2 = new Billete(10.00, "Lugo", "Ourense", "12/04/21");
        b3 = new Billete(16.50, "Ourense", "Vigo", "12/04/21");
        b4 = new Billete(12.33, "Ourense", "Santiago", "13/04/21");
        b5 = new Billete(16.50, "Vigo", "Ourense", "13/04/21");
        b6 = new Billete(16.50, "Vigo", "Ourense", "14/04/21");
        b7 = new Billete(15.00, "Santiago", "Vigo", "14/04/21");
        b8 = new Billete(8.90, "Lugo", "Santiago", "14/04/21");

        List<Billete> billetes = new ArrayList<>(List.of(b1, b2, b3, b4, b5, b6, b7, b8));

        gb = new GestorBilletes();
        gb.setBilletes(billetes);
    }

    @Test
    void testClausulasExceptions() {
        assertThrows(IllegalArgumentException.class, () -> Clausula.AND.perform(null));
        assertThrows(IllegalArgumentException.class, () -> Clausula.OR.perform(null));
        assertThrows(IllegalArgumentException.class, () -> Clausula.AND.perform(Collections.emptyList()));
        assertThrows(IllegalArgumentException.class, () -> Clausula.OR.perform(Collections.emptyList()));

    }

    @Test
    void testBilletesExceptions() {
        assertThrows(IllegalArgumentException.class, () -> new Billete(-6.22, "Santiago", "Orense", "12/05/22"));
        assertThrows(IllegalArgumentException.class, () -> new Billete(6.22, null, "Orense", "12/05/22"));
        assertThrows(IllegalArgumentException.class, () -> new Billete(6.22, "Santiago", null, "12/05/22"));
        assertThrows(IllegalArgumentException.class, () -> new Billete(6.22, "Santiago", "Orense", null));
    }

    @Test
    void testFiltraExceptions() {
        assertThrows(IllegalArgumentException.class, () -> gb.filtrar(Clausula.AND, null));
        assertThrows(IllegalArgumentException.class, () -> gb.filtrar(null, List.of(new FiltroDestino("Santiago"))));
        assertThrows(IllegalArgumentException.class, () -> gb.filtrar(Clausula.AND, new ArrayList<>()));
        gb.setBilletes(null);
        assertThrows(IllegalArgumentException.class, () -> gb.filtrar(Clausula.AND, new ArrayList<>()));
        gb.setBilletes(new ArrayList<>());
        assertThrows(IllegalStateException.class, () -> gb.filtrar(Clausula.AND, List.of(new FiltroDestino("Santiago"))));
        assertEquals(Collections.emptyList(), new FiltroPrecio(2.2, null).filtrar(List.of(b1, b2, b3)));
        assertEquals(Collections.emptyList(), new FiltroPrecio(2.2, List.of(FiltroPrecio.Tipo.MENOR, FiltroPrecio.Tipo.MAYOR, FiltroPrecio.Tipo.IGUAL)).filtrar(List.of(b1, b2, b3)));


        assertThrows(IllegalArgumentException.class, () -> gb.combinarFiltrados(Clausula.AND, null));
        assertThrows(IllegalArgumentException.class, () -> gb.combinarFiltrados(null, new ArrayList<>()));
        assertThrows(IllegalArgumentException.class, () -> gb.combinarFiltrados(Clausula.AND, List.of(b3, b4)));

    }

    @Test
    void testFiltrados1() {
        List<Billete> l1, l2, l3, l4, aux;
        l1 = gb.filtrar(Clausula.AND, List.of(new FiltroOrigen("Santiago"), new FiltroDestino("Vigo")));
        l2 = gb.filtrar(Clausula.OR, List.of(new FiltroFecha("13/04/21"), new FiltroFecha("14/04/21")));
        l3 = gb.filtrar(Clausula.OR, List.of(new FiltroPrecio(15.00, List.of(FiltroPrecio.Tipo.IGUAL, FiltroPrecio.Tipo.MENOR))));

        l4 = gb.combinarFiltrados(Clausula.AND, l1, l2, l3);

        aux = new ArrayList<>(List.of(b7));

        assertEquals(aux.size(), l4.size());
        assertEquals(aux, l4);
        assertEquals(aux.toString(), l4.toString());
        assertEquals(aux.hashCode(), l4.hashCode());

        //Trato de que coincidan muchas en cada filtro
        l2 = gb.filtrar(Clausula.OR, List.of(new FiltroPrecio(15.00, List.of(FiltroPrecio.Tipo.IGUAL)), new FiltroFecha("13/04/21"), new FiltroFecha("14/04/21")));
        l3 = gb.filtrar(Clausula.AND, List.of(new FiltroOrigen("Santiago")));
        l4 = gb.combinarFiltrados(Clausula.OR, l2, l3);

        aux = new ArrayList<>(List.of(b7,b4,b5,b6,b8,b1));

        assertEquals(aux.size(), l4.size());
        assertEquals(aux, l4);
        assertEquals(aux.toString(), l4.toString());
        assertEquals(aux.hashCode(), l4.hashCode());

    }

    @Test
    void testFiltrados2() {
        List<Billete> l1, l2, l3, l4, aux;
        l1 = gb.filtrar(Clausula.OR, List.of(new FiltroOrigen("Ourense"), new FiltroOrigen("Vigo")));
        l2 = gb.filtrar(Clausula.OR, List.of(new FiltroFecha("12/04/21"), new FiltroFecha("13/04/21")));
        l3 = gb.filtrar(Clausula.OR, List.of(new FiltroPrecio(12.33, List.of(FiltroPrecio.Tipo.IGUAL, FiltroPrecio.Tipo.MAYOR))));

        l4 = gb.combinarFiltrados(Clausula.AND, l1, l2, l3);

        aux = new ArrayList<>(List.of(b3, b4, b5));

        assertEquals(aux.size(), l4.size());
        assertEquals(aux, l4);
        assertEquals(aux.toString(), l4.toString());
        assertEquals(aux.hashCode(), l4.hashCode());


        // solo los mayores
        l3 = gb.filtrar(Clausula.OR, List.of(new FiltroPrecio(12.33, List.of(FiltroPrecio.Tipo.MAYOR))));

        l4 = gb.combinarFiltrados(Clausula.AND, l1, l2, l3);

        aux = new ArrayList<>(List.of(b3, b5));

        assertEquals(aux.size(), l4.size());
        assertEquals(aux, l4);
        assertEquals(aux.toString(), l4.toString());
        assertEquals(aux.hashCode(), l4.hashCode());

        // solo los iguales
        l3 = gb.filtrar(Clausula.OR, List.of(new FiltroPrecio(12.33, List.of(FiltroPrecio.Tipo.IGUAL))));

        l4 = gb.combinarFiltrados(Clausula.AND, l1, l2, l3);

        aux = new ArrayList<>(List.of(b4));

        assertEquals(aux.size(), l4.size());
        assertEquals(aux, l4);
        assertEquals(aux.toString(), l4.toString());
        assertEquals(aux.hashCode(), l4.hashCode()); // solo los iguales

        //menores
        l3 = gb.filtrar(Clausula.OR, List.of(new FiltroPrecio(16.50, List.of(FiltroPrecio.Tipo.MENOR))));

        l4 = gb.combinarFiltrados(Clausula.AND, l1, l2, l3);

        aux = new ArrayList<>(List.of(b4));

        assertEquals(aux.size(), l4.size());
        assertEquals(aux, l4);
        assertEquals(aux.toString(), l4.toString());
        assertEquals(aux.hashCode(), l4.hashCode());


    }


    @Test
    void testEquals() {
        assertNotEquals(b2, null);
        assertNotEquals(b2, "a string");
        assertNotEquals(null, b2);
        assertNotEquals(b2, new Billete(11.00, "Lugo", "Ourense", "12/04/21"));
        assertNotEquals(b2, new Billete(10.00, "Santiago", "Ourense", "12/04/21"));
        assertNotEquals(b2, new Billete(10.00, "Lugo", "Vigo", "12/04/21"));
        assertNotEquals(b2, new Billete(10.00, "Lugo", "Ourense", "14/04/21"));
        assertEquals(b2, new Billete(10.00, "Lugo", "Ourense", "12/04/21"));
    }



}