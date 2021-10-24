package e1;

import e1.integrante.Integrante;
import e1.integrante.personal.Conserje;
import e1.integrante.personal.Docente;
import e1.integrante.personal.Personal;
import e1.integrante.residentes.Fantasma;
import e1.integrante.residentes.Residente;

import java.util.ArrayList;
import java.util.List;

public class Colegio {


    public String imprimirRecompensas(List<Integrante> integrantes) {
        String cad = "";
        float total=0;
        for (Integrante i : integrantes) {
            cad += i.imprimirRecompensa() + "\n";
            total+=i.getRecompensaMinisterio();
        }
        return cad+"La recompensa total del Colegio Hogwarts es de "+total+" galeones";
    }

    public String imprimirSalarios(List<Integrante> integrantes) {
        String cad = "";
        int total=0;
        for (Integrante i : integrantes) {
            boolean b = i instanceof Personal;
            if (b) {
                cad += ((Personal) i).imprimirSalario() + "\n";
                total+=((Personal) i).getSueldo();
            }
        }

        return cad+"El gasto de Hogwarts en personal es de "+total+" galeones";
    }

    public static void main(String[] args) {
        List<Integrante> lis = new ArrayList<>();

        lis.add(new Conserje("pedro", "suarez", 34, 2));
        lis.add(new Docente("aaa", "yoo", 34, Docente.asignaturas.Defensa,2));
        lis.add(new Fantasma("juan", "lago", 34, Residente.casasHogwarts.Slytherin,2));

        Colegio e = new Colegio();
        System.out.println(e.imprimirRecompensas(lis));

        System.out.println("\n*********\n");
        System.out.println(e.imprimirSalarios(lis));


    }
}
