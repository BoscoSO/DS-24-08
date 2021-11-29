package e2.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tarea {
    private final char nombre;
    private final List<Tarea> nextTareas=new ArrayList<>();

    public Tarea(Character nombre) throws IllegalArgumentException{
        if(nombre==null) throw new IllegalArgumentException("Argumento nulo");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return nombre == tarea.nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return String.valueOf(nombre);
    }
}
