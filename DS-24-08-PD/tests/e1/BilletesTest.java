package e1;

import e1.dto.Billete;
import e1.lgc.GestorBilletes;
import e1.util.FiltroDestino;
import e1.util.FiltroFecha;
import e1.util.FiltroOrigen;
import e1.util.FiltroPrecio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class BilletesTest {

    private GestorBilletes gb;

    @BeforeEach
    void setUp() {
        List<Billete> billetes = new ArrayList<Billete>();
        double precio = 6.43;
        int dia = 10;
        for (int c = 0; c < 10; c++) {
            dia++;
            for (int i = 0; i < 3; i++) {
                billetes.add(new Billete(precio, "Lugo", "Coruña", dia + "/04/21"));
                billetes.add(new Billete(precio, "Lugo", "Orense", dia + "/04/21"));
                billetes.add(new Billete(precio, "Lugo", "Santiago", dia + "/04/21"));
                billetes.add(new Billete(precio, "Lugo", "Vigo", dia + "/04/21"));
                precio += 3;
                billetes.add(new Billete(precio, "Coruña", "Lugo", dia + "/04/21"));
                billetes.add(new Billete(precio, "Coruña", "Orense", dia + "/04/21"));
                billetes.add(new Billete(precio, "Coruña", "Santiago", dia + "/04/21"));
                billetes.add(new Billete(precio, "Coruña", "Vigo", dia + "/04/21"));
                precio -= 1.03;
                billetes.add(new Billete(precio, "Orense", "Lugo", dia + "/04/21"));
                billetes.add(new Billete(precio, "Orense", "Coruña", dia + "/04/21"));
                billetes.add(new Billete(precio, "Orense", "Santiago", dia + "/04/21"));
                billetes.add(new Billete(precio, "Orense", "Vigo", dia + "/04/21"));
                precio += 4.23;
                billetes.add(new Billete(precio, "Santiago", "Lugo", dia + "/04/21"));
                billetes.add(new Billete(precio, "Santiago", "Coruña", dia + "/04/21"));
                billetes.add(new Billete(precio, "Santiago", "Orense", dia + "/04/21"));
                billetes.add(new Billete(precio, "Santiago", "Vigo", dia + "/04/21"));

                billetes.add(new Billete(precio, "Vigo", "Lugo", dia + "/04/21"));
                billetes.add(new Billete(precio, "Vigo", "Coruña", dia + "/04/21"));
                billetes.add(new Billete(precio, "Vigo", "Orense", dia + "/04/21"));
                billetes.add(new Billete(precio, "Vigo", "Santiago", dia + "/04/21"));
                precio -= 2.78;
            }
        }

        gb = new GestorBilletes();
        gb.setBilletes(billetes);
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
        assertThrows(IllegalArgumentException.class, () -> gb.filtra(null, null, new ArrayList<>(), GestorBilletes.Clausula.AND));
        assertThrows(IllegalArgumentException.class, () -> gb.filtra(null, null, null, GestorBilletes.Clausula.AND));
        assertThrows(IllegalArgumentException.class, () -> gb.filtra(null, null, List.of(new FiltroDestino("Santiago")), null));

        gb.setBilletes(new ArrayList<>());
        assertThrows(IllegalStateException.class, () -> gb.filtra(null, null, null, null));
    }

    @Test
    void testFiltrados() {
        List<Billete> l = null;
        l = gb.filtra(null, null, List.of(new FiltroOrigen("Coruña"), new FiltroDestino("Santiago")), GestorBilletes.Clausula.AND);
        l = gb.filtra(l, GestorBilletes.Clausula.AND, List.of(new FiltroFecha("17/04/21"), new FiltroFecha("18/04/21"), new FiltroFecha("12/04/21")), GestorBilletes.Clausula.OR);
        l = gb.filtra(l, GestorBilletes.Clausula.AND, List.of(new FiltroPrecio(66, List.of(FiltroPrecio.Tipo.IGUAL, FiltroPrecio.Tipo.MENOR))), GestorBilletes.Clausula.OR);

        assertEquals(3, l.size()); //mas comprobacion no solo tamaño, mirar objetos
        l.clear();


        l = gb.filtra(null, null, List.of(new FiltroOrigen("Coruña"), new FiltroOrigen("Santiago")), GestorBilletes.Clausula.OR);
        l = gb.filtra(l, GestorBilletes.Clausula.AND, List.of(new FiltroDestino("Orense")), GestorBilletes.Clausula.OR);
        l = gb.filtra(l, GestorBilletes.Clausula.AND, List.of(new FiltroPrecio(28, List.of(FiltroPrecio.Tipo.MAYOR, FiltroPrecio.Tipo.IGUAL))), GestorBilletes.Clausula.OR);
        l = gb.filtra(l, GestorBilletes.Clausula.AND, List.of(new FiltroFecha("12/04/21"), new FiltroFecha("16/04/21")), GestorBilletes.Clausula.OR);
        for (Billete b : l) {
            System.out.println(b.toString());
        }
        assertEquals(7, l.size()); //mas comprobacion no solo tamaño, mirar objetos

        //falta mayor solo, menor solo, igual solo (en precio) y probar con mas de dos clausulas y juntar posibles repetidos
    }
}