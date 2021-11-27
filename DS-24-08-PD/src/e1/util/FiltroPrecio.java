package e1.util;

import e1.dto.Billete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FiltroPrecio implements FiltroBilletes {
    private final double precio;
    private final List<Tipo> clausulas;

    public enum Tipo {
        MAYOR, MENOR, IGUAL
    }


    public FiltroPrecio(double precio, List<Tipo> tipo) {           //Solo dos clausulas a la vez < |> | <=| >=| ==
        this.precio = Objects.requireNonNullElse(precio,0.0);
        clausulas =Objects.requireNonNullElse(tipo,Collections.emptyList());
    }

    @Override
    public List<Billete> filtrar(List<Billete> billetes) {              //Devuelve solo los billetes que cumplen lo exigido
        if (clausulas.size() > 2) return Collections.emptyList();
        List<Billete> aux = new ArrayList<>();


        if (clausulas.contains(Tipo.MENOR)) {
            int i = -1;
            if (clausulas.contains(Tipo.IGUAL)) i = 0;
            for (Billete b : billetes)
                if (Double.compare(b.getPrecio(), precio) <= i)
                    aux.add(b);
        } else if (clausulas.contains(Tipo.MAYOR)) {
            int i = 1;
            if (clausulas.contains(Tipo.IGUAL)) i = 0;
            for (Billete b : billetes)
                if (Double.compare(b.getPrecio(), precio) >= i)
                    aux.add(b);
        } else if (clausulas.contains(Tipo.IGUAL))
            for (Billete b : billetes)
                if (Double.compare(b.getPrecio(), precio) == 0)
                    aux.add(b);


        return aux;
    }
}
