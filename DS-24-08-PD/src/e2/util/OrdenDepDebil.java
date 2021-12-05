package e2.util;

import e2.dto.Tarea;

import java.util.ArrayList;
import java.util.List;

public final class OrdenDepDebil implements OrdenPlanificacion {

    private List<Tarea> depDebil(List<Tarea> cabeceras) {
        List<Tarea> ordenadas = new ArrayList<>();
        boolean end = false;
        while (!end) {
            char actual = 99;
            if (cabeceras.isEmpty()) end = true;
            else {

                for (Tarea t : cabeceras) {
                    if (actual > t.getNombre())
                        actual = t.getNombre();
                }
                Tarea terminada = OrdenPlanificacion.findTarea(cabeceras, actual);
                if (!ordenadas.contains(terminada))
                    ordenadas.add(terminada);
                cabeceras.remove(terminada);

                if (terminada != null)
                    cabeceras.addAll(terminada.getNextTareas());


            }
        }
        return ordenadas;
    }

    @Override
    public String ordenar(List<Tarea> cabeceras) throws IllegalArgumentException {
        if (cabeceras == null) throw new IllegalArgumentException("Argumento nulo");

        List<Tarea> ordenadas = new ArrayList<>(depDebil(cabeceras));

        return OrdenPlanificacion.ordenToString(ordenadas);
    }
}
