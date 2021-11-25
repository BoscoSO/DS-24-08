package e1.util;

import e1.dto.Billete;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FiltroOrigen implements FiltroBilletes{
    private final String origen;

    public FiltroOrigen(String origen) {
        this.origen = Objects.requireNonNullElse(origen,"");
    }

    @Override
    public List<Billete>  filtrar(List<Billete> billetes) {
        List<Billete> aux=new ArrayList<>();
        for(Billete b: billetes){
            if(b.getOrigen().equals(origen)){
                aux.add(b);
            }
        }
        return aux;
    }
}
