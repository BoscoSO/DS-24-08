package e1.util;

import e1.dto.Billete;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FiltroDestino implements FiltroBilletes{

    private final String destino;

    public FiltroDestino(String destino) {
        this.destino = Objects.requireNonNullElse(destino,"");
    }

    @Override
    public List<Billete> filtrar(List<Billete> billetes) {
        List<Billete> aux=new ArrayList<>();
        for(Billete b: billetes){
            if(b.getDestino().equals(destino)){
                aux.add(b);
            }
        }
        return aux;
    }
}
