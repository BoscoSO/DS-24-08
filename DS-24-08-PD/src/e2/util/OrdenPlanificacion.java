package e2.util;

import e2.dto.Tarea;

import java.util.List;

public sealed interface OrdenPlanificacion permits OrdenDepFuerte,OrdenDepDebil,OrdenJerarquico {

    default Tarea findTarea(List<Tarea> heads, char tareaBuscada) {
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
    String ordenar(List<Tarea> cabeceras);
}
