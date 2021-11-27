package e2.dto;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
    private final char nombre;
    private final List<Tarea> nextTareas=new ArrayList<>();

    public Tarea(char nombre)  {
        this.nombre = nombre;
    }

    public char getNombre() {
        return nombre;
    }

    public void addNextTarea(Tarea next) {
        nextTareas.add(next);
    }

    public List<Tarea> getNextTareas() {
        return nextTareas;
    }

    @Override
    public String toString() {
        return String.valueOf(nombre);
    }
}
