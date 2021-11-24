package e1.util;

import e1.dto.Billete;

import java.util.ArrayList;
import java.util.List;

public class FiltroOrigen implements FiltroBilletes{
    private final String origen;

    public FiltroOrigen(String origen) {
        this.origen = origen;
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
