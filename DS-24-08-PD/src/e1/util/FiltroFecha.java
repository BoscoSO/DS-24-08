package e1.util;

import e1.dto.Billete;

import java.util.ArrayList;
import java.util.List;

public class FiltroFecha implements FiltroBilletes{
    private final String fecha;

    public FiltroFecha(String fecha) {
        this.fecha = fecha;
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
