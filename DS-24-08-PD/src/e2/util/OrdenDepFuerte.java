package e2.util;

import e2.dto.Tarea;

import java.util.ArrayList;
import java.util.List;

public final class OrdenDepFuerte implements OrdenPlanificacion {

    @Override
    public String ordenar(List<Tarea> cabeceras) {
        List<Tarea> ordenadas = new ArrayList<>();
        boolean end = false;
        while (!end) {
            char actual = 90;
            if (cabeceras.isEmpty()) end = true;
            else {
                for (Tarea t : cabeceras)
                    if (actual > t.getNombre())
                        actual = t.getNombre();

                Tarea terminada = findTarea(cabeceras, actual);

                ordenadas.add(terminada);
                cabeceras.remove(terminada);

                for (Tarea t : terminada.getNextTareas())
                    if (findTarea(cabeceras, t.getNombre()) == null)
                        cabeceras.add(t);
            }
        }
        if (!ordenadas.isEmpty()) {
            String orden = ordenadas.get(0).toString();
            ordenadas.remove(0);
            for (Tarea t : ordenadas)
                orden += " - " + t;

            return orden;
        } else return "";

    }
}
