package e1;

import e1.integrante.Integrante;
import e1.integrante.personal.Personal;

import java.util.List;

public class Colegio {

    private final List<Integrante> integrantes;

    public Colegio(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public void nuevoIntegrante(Integrante i) {
        if(i==null)return;
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
