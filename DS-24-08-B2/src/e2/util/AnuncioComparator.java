package e2.util;

import e2.dto.Anuncio;

import java.util.Comparator;
import java.util.Objects;

public class AnuncioComparator implements Comparator<Anuncio> {

    public enum MetodoComparar {
        NATURAL, PRECIO_BASE, PRECIO_TOTAL, TAMANO, NUM_HABITACIONES
    }

    private final MetodoComparar metod;
    private final boolean invert;

    public AnuncioComparator(MetodoComparar metod, boolean invert) {
        this.metod = Objects.requireNonNullElse(metod, MetodoComparar.NATURAL);
        this.invert = Objects.requireNonNullElse(invert, false);
    }

    @Override
    public int compare(Anuncio a1, Anuncio a2) {
        if (invert) {
            Anuncio tmp = a1;
            a1=a2;
            a2=tmp;
        }
        switch (metod) {
            case NATURAL -> {
                return a1.compareTo(a2);
            }
            case PRECIO_BASE -> {
                return Float.compare(a1.getPrecio_base(), a2.getPrecio_base());
            }
            case PRECIO_TOTAL -> {
                float total1 = a1.getPrecio_base() + (a1.getPrecio_plz_garaje() * a1.getApartamento().getPlazas_garaje());
                float total2 = a2.getPrecio_base() + (a2.getPrecio_plz_garaje() * a2.getApartamento().getPlazas_garaje());
                return Float.compare(total1, total2);
            }
            case TAMANO -> {
                return Float.compare(a1.getApartamento().getDimensiones(), a2.getApartamento().getDimensiones());
            }
            case NUM_HABITACIONES -> {
                int total1 = a1.getApartamento().getNum_habitaciones() + a1.getApartamento().getNum_banos();
                int total2 = a2.getApartamento().getNum_habitaciones() + a2.getApartamento().getNum_banos();
                return Integer.compare(total1, total2);
            }
        }

        return 0;
    }
}
