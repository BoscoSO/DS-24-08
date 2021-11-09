package e2.util;

import e2.dto.Anuncio;

import java.util.Comparator;
import java.util.Objects;

public class ComparatorPrecioTotal implements Comparator<Anuncio> {


    private final boolean invert;

    public ComparatorPrecioTotal(boolean invert) {
        this.invert = Objects.requireNonNullElse(invert, false);
    }

    @Override
    public int compare(Anuncio anuncio1, Anuncio anuncio2) {
        Anuncio a1 = anuncio1, a2 = anuncio2;
        if (invert) {
            a1 = anuncio2;
            a2 = anuncio1;
        }
        float total1 = a1.getPrecio_base() + (a1.getPrecio_plz_garaje() * a1.getApartamento().getPlazas_garaje());
        float total2 = a2.getPrecio_base() + (a2.getPrecio_plz_garaje() * a2.getApartamento().getPlazas_garaje());
        if (total1 == total2) return anuncio1.compareTo(anuncio2);
        return Float.compare(total1, total2);


    }
}
