package e1.util;

import e1.dto.Billete;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FiltroFecha implements FiltroBilletes{
    private final String fecha;

    public FiltroFecha(String fecha) {
        this.fecha = Objects.requireNonNullElse(fecha,"");
    }

    @Override
    public List<Billete>  filtrar(List<Billete> billetes) {
        List<Billete> aux=new ArrayList<>();
        for(Billete b: billetes){
            if(b.getFecha().equals(fecha)){
                aux.add(b);
            }
        }
        return aux;
    }
}
