import e1.Colegio;
import e1.integrante.Integrante;
import e1.integrante.personal.Conserje;
import e1.integrante.personal.Docente;
import e1.integrante.personal.GuardaBosques;
import e1.integrante.residentes.Estudiante;
import e1.integrante.residentes.Fantasma;
import e1.integrante.residentes.Residente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColegioTest_e1 {
    private Colegio colegio;
    private List<Integrante> lis = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lis.add(new Estudiante("Hermione", "Granger", 21, Residente.casasHogwarts.Gryffindor, 3));
        lis.add(new Fantasma("Barón", "Sanguinario", 124, Residente.casasHogwarts.Slytherin, 1));
        lis.add(new GuardaBosques("Rubeus", "Hagrid", 43, 2));
        lis.add(new Docente("Minerva", "McGonagall", 34, Docente.asignaturas.Transformaciones, 1));
        lis.add(new Docente("Severus", "Snape", 44, Docente.asignaturas.Defensa, 2));
        lis.add(new Conserje("Argus", "Filch", 64, 0));

        colegio = new Colegio(lis);
    }


    @Test
    void testRecompensas() {
        assertEquals("""
                Hermione Granger (Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones
                Barón Sanguinario (Fantasma de Slytherin, 1 horrocruxes): 160.0 galeones
                Rubeus Hagrid (GuardaBosques, 2 horrocruxes): 150.0 galeones
                Minerva McGonagall (Docente de Transformaciones, 1 horrocruxes): 50.0 galeones
                Severus Snape (Docente de Defensa, 2 horrocruxes): 75.0 galeones
                Argus Filch (Conserje, 0 horrocruxes): 0.0 galeones
                La recompensa total del Colegio Hogwarts es de 705.0 galeones""", colegio.imprimirRecompensas());
        assertEquals(705.0,colegio.getRecompensaTotal());
        assertNotEquals(10,colegio.getRecompensaTotal());
    }

    @Test
    void testSalarios() {
        assertEquals("""
                Rubeus Hagrid (GuardaBosques): 180 galeones
                Minerva McGonagall (Docente de Transformaciones): 400 galeones
                Severus Snape (Docente de Defensa): 500 galeones
                Argus Filch (Conserje): 160 galeones
                El gasto de Hogwarts en personal es de 1240 galeones""", colegio.imprimirSalarios());
        assertEquals(1240,colegio.getSalariosTotal());
        assertNotEquals(10,colegio.getSalariosTotal());

    }

    @Test
    void testExceptions() {
        assertThrows(IllegalArgumentException.class, () ->new Estudiante("Hermione", "Granger", 21, null, 3));
        assertThrows(IllegalArgumentException.class, () ->new GuardaBosques("Rubeus", "Hagrid", 51, -3));
        assertThrows(IllegalArgumentException.class, () ->new Docente("Severus", "Snape", 44, null, 2));
    }
}