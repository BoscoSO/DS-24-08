package e2.lgc;

import e2.dto.Tarea;
import e2.util.OrdenPlanificacion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlanificadorTareas {
    private final List<Tarea> cabeceras = new ArrayList<>();


    private Tarea findCabecera(char tarea) {
        for (Tarea t : cabeceras)
            if (t.getNombre() == tarea)
                return t;
        return null;
    }
    private Tarea findTarea(List<Tarea> heads, char tareaBuscada) {
        for (Tarea t : heads)
            if (t.getNombre() == tareaBuscada) {
                return t;
            } else {
                Tarea aux = findTarea(t.getNextTareas(), tareaBuscada);
                if (aux != null) return aux;
            }

        return null;
    }
    private void setDep(char tareaA, char tareaB) {
        Tarea a = findTarea(cabeceras, tareaA);
        if (a == null) {
            a = new Tarea(tareaA);
            cabeceras.add(a);
        }

        Tarea b = findCabecera(tareaB);

        if (b == null) {
            b = findTarea(cabeceras, tareaB);
            if (b == null)
                b = new Tarea(tareaB);
        } else
            cabeceras.remove(b);


        a.addNextTarea(b);
    }

    public void procesarDependencias(String filename) throws IllegalArgumentException{
        try {
            Scanner in = new Scanner(new FileReader("src/e2/resources/" + filename));
            cabeceras.clear();
            while (in.hasNext()) {
                String[] elems = in.nextLine().split(" -> ");
                setDep(elems[0].charAt(0), elems[1].charAt(0));
            }
            in.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Error: No existe \"" + filename + "\" en la carpeta src/e2/resources");
        }
    }

    public String ordenaSegun(OrdenPlanificacion metodo)throws IllegalArgumentException {
        if(metodo==null)throw new IllegalArgumentException("Argumento nulo");
        return metodo.ordenar(new ArrayList<>(cabeceras));
    }




}
