package e1;

import e1.integrante.Integrante;
import e1.integrante.personal.Conserje;
import e1.integrante.personal.Docente;
import e1.integrante.personal.GuardaBosques;
import e1.integrante.personal.Personal;
import e1.integrante.residentes.Estudiante;
import e1.integrante.residentes.Fantasma;
import e1.integrante.residentes.Residente;

import java.util.ArrayList;
import java.util.List;

public class Colegio {

    private List<Integrante> integrantes;

    public Colegio(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public void nuevoIntegrante(Integrante i) {
        integrantes.add(i);
    }

    public float getRecompensaTotal() {
        float total = 0;
        for (Integrante i : integrantes)
            total += i.getRecompensaMinisterio();
        return total;
    }
    public int getSalariosTotal() {
        int total = 0;
        for (Integrante i : integrantes) {
            if (i instanceof Personal) {
                total += ((Personal) i).getSueldo();
            }
        }
        return total;
    }

    public String imprimirRecompensas() {
        String cad = "";
        for (Integrante i : integrantes) {
            cad += i.imprimirRecompensa() + "\n";
        }
        return cad + "La recompensa total del Colegio Hogwarts es de " + getRecompensaTotal() + " galeones";
    }
    public String imprimirSalarios() {
        String cad = "";
        for (Integrante i : integrantes) {
            if (i instanceof Personal) {
                cad += ((Personal) i).imprimirSalario() + "\n";
            }
        }
        return cad + "El gasto de Hogwarts en personal es de " + getSalariosTotal() + " galeones";
    }


}
