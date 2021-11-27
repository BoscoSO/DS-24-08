package e2.lgc;

import e2.dto.Tarea;
import e2.util.OrdenDepDebil;
import e2.util.OrdenDepFuerte;
import e2.util.OrdenJerarquico;
import e2.util.OrdenPlanificacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PlanificadorTareas {
    private final List<Tarea> cabeceras = new ArrayList<>();


    private void addCabecera(Tarea tarea) {
        cabeceras.add(tarea);
    }
    private void deleteCabecera(Tarea tarea) {
        cabeceras.remove(tarea);
    }
    private Tarea findCabecera(char tarea) {
        for (Tarea t : cabeceras) {
            if (t.getNombre() == tarea) {
                return t;
            }
        }
        return null;
    }
    private Tarea findTarea(List<Tarea> heads, char tareaBuscada) {
        for (Tarea t : heads) {
            if (t.getNombre() == tareaBuscada) {
                return t;
            } else {
                Tarea aux = findTarea(t.getNextTareas(), tareaBuscada);
                if (aux != null) return aux;
            }
        }
        return null;
    }
    private void setDep(char tareaA, char tareaB) {

        Tarea a = findTarea(cabeceras, tareaA);
        if (a == null) {
            a = new Tarea(tareaA);
            addCabecera(a);
        }

        Tarea b = findCabecera(tareaB);

        if (b == null) {
            b = findTarea(cabeceras, tareaB);
            if (b == null) {
                b = new Tarea(tareaB);
            }
        } else {
            deleteCabecera(b);
        }

        a.addNextTarea(b);
    }

    public void procesarDependencias(String filename) {
        try {
            Scanner in = new Scanner(new FileReader("DS-24-08-PD/src/e2/resources/" + filename));
            while (in.hasNext()) {
                String[] elems = in.nextLine().split(" -> ");
                setDep(elems[0].charAt(0), elems[1].charAt(0));
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: No existe \"" + filename + "\" en la carpeta e2/resources");
        }
    }

    public String ordenaSegun(OrdenPlanificacion metodo) {
        return metodo.ordenar(new ArrayList<>(cabeceras));
    }


/*
    public String GrafoDependencias() {
        String cad = "";
        for (Tarea t : cabeceras) {

            cad+=grafoNext(t);
        }

        return cad;
    }
    private String grafoNext(Tarea t){
        String cad="---->"+t.getNombre();


        return cad;
    }
*/


    public static void main(String[] args) {
         PlanificadorTareas pt = new PlanificadorTareas();
         pt.procesarDependencias("entrada1.txt");
        System.out.println("Dependencia fuerte "+pt.ordenaSegun(new OrdenDepFuerte()));
        System.out.println("Dependencia debil "+pt.ordenaSegun(new OrdenDepDebil()));
        System.out.println("Dependencia jerarquica "+pt.ordenaSegun(new OrdenJerarquico()));

    }
}
