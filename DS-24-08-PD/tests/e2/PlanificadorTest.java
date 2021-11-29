package e2;

import e1.dto.Billete;
import e1.dto.Clausula;
import e1.lgc.GestorBilletes;
import e1.util.FiltroDestino;
import e1.util.FiltroFecha;
import e1.util.FiltroOrigen;
import e1.util.FiltroPrecio;
import e2.dto.Tarea;
import e2.lgc.PlanificadorTareas;
import e2.util.OrdenDepDebil;
import e2.util.OrdenDepFuerte;
import e2.util.OrdenJerarquico;
import e2.util.OrdenPlanificacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PlanificadorTest {


    @Test
    void testTareas() {
        assertThrows(IllegalArgumentException.class, () -> new Tarea(null));

        Tarea t = new Tarea('A');
        assertEquals('A', t.getNombre());
        assertEquals("A", t.toString());
        assertEquals(t, new Tarea('A'));
        assertEquals(t.hashCode(), new Tarea('A').hashCode());
        assertNotEquals(t, new Tarea('C'));
        assertNotEquals(t, null);

        assertNotEquals(null, t.getNextTareas());
        t.addNextTarea(new Tarea('B'));
        assertEquals(List.of(new Tarea('B')), t.getNextTareas());

    }


    @Test
    void testOrdenesExceptions() {
        OrdenPlanificacion orden1, orden2, orden3;

        orden1 = new OrdenDepFuerte();
        assertThrows(IllegalArgumentException.class, () -> orden1.ordenar(null));

        orden2 = new OrdenDepDebil();
        assertThrows(IllegalArgumentException.class, () -> orden2.ordenar(null));

        orden3 = new OrdenJerarquico();
        assertThrows(IllegalArgumentException.class, () -> orden3.ordenar(null));
    }

    @Test
    void testPlanificador() {
        PlanificadorTareas pt = new PlanificadorTareas();

        assertThrows(IllegalArgumentException.class, () -> pt.procesarDependencias("noexisto.txt"));
        assertThrows(IllegalArgumentException.class, () -> pt.ordenaSegun(null));
        assertEquals("", pt.ordenaSegun(new OrdenDepFuerte()));
        assertEquals("", pt.ordenaSegun(new OrdenDepDebil()));
        assertEquals("", pt.ordenaSegun(new OrdenJerarquico()));
        pt.procesarDependencias("entrada1.txt");

        assertEquals("C - A - B - D - G - F - E - H - J", pt.ordenaSegun(new OrdenDepFuerte()));
        assertEquals("C - A - B - D - E - F - G - H - J", pt.ordenaSegun(new OrdenDepDebil()));
        assertEquals("C - G - A - F - H - B - D - E - J", pt.ordenaSegun(new OrdenJerarquico()));


        pt.procesarDependencias("entrada2.txt");

        //assertEquals("A - B - I - C - D - X - F", pt.ordenaSegun(new OrdenDepFuerte()));
     //   assertEquals("A - B - C - D - I - X - F", pt.ordenaSegun(new OrdenDepDebil()));
       // assertEquals("A - I - B - C - X - D - F", pt.ordenaSegun(new OrdenJerarquico()));
    }

}