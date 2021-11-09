package e2.util;

import e2.dto.Anuncio;

import java.util.Comparator;
import java.util.Objects;

public class ComparatorPrecioBase implements Comparator<Anuncio> {

    private final boolean invert;

    public ComparatorPrecioBase(boolean invert) {
        this.invert = Objects.requireNonNullElse(invert, false);
    }

    @Override
    public int compare(Anuncio anuncio1, Anuncio anuncio2) {
        Anuncio a1 = anuncio1, a2 = anuncio2;
        if (invert) {
            a1 = anuncio2;
            a2 = anuncio1;
        }
        if (a1.getPrecio_base() == a2.getPrecio_base()) return anuncio1.compareTo(anuncio2);
        return Float.compare(a1.getPrecio_base(), a2.getPrecio_base());


    }
}
