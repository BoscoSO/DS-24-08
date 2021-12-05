package e2.util;

import e2.dto.Tarea;

import java.util.List;

public sealed interface OrdenPlanificacion permits OrdenDepFuerte,OrdenDepDebil,OrdenJerarquico{

    String ordenar(List<Tarea> cabeceras) throws IllegalArgumentException;

    static Tarea findTarea(List<Tarea> heads, char tareaBuscada) {
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

    static String ordenToString(List<Tarea> ordenadas){
        if (!ordenadas.isEmpty()) {
            StringBuilder orden = new StringBuilder(ordenadas.get(0).toString());
            ordenadas.remove(0);
            for (Tarea t : ordenadas)
                orden.append(" - ").append(t);

            return orden.toString();
        } else return "";
    }
}
