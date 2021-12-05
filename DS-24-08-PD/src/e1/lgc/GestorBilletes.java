package e1.lgc;

import e1.dto.Billete;
import e1.dto.Clausula;
import e1.util.*;

import java.util.ArrayList;
import java.util.List;

public class GestorBilletes {

    private List<Billete> billetes = new ArrayList<>();

    public void setBilletes(List<Billete> billetes) {
        this.billetes = billetes;
    }


    public List<Billete> filtrar(Clausula clausula, List<FiltroBilletes> filtros) throws IllegalStateException, IllegalArgumentException {
        if (billetes == null || filtros == null || clausula == null)
            throw new IllegalArgumentException("parametro nulo");
        if (billetes.isEmpty()) throw new IllegalStateException("No hay billetes que filtrar");
        if (filtros.size() < 1) throw new IllegalArgumentException("No hay filtros");


        List<List<Billete>> aux = new ArrayList<>();
        for (FiltroBilletes f : filtros)
            aux.add(f.filtrar(billetes));

        return clausula.perform(aux);

    }

    @SafeVarargs
    public final List<Billete> combinarFiltrados(Clausula clausula, List<Billete>... listas) throws IllegalArgumentException {
        if (listas == null || clausula == null)
            throw new IllegalArgumentException("parametro nulo");
        if (listas.length < 2) throw new IllegalArgumentException("No hay listas para combinar");

        return clausula.perform(List.of(listas));
    }
}
