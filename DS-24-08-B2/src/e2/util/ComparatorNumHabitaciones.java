package e2.util;

import e2.dto.Anuncio;

import java.util.Comparator;
import java.util.Objects;

public class ComparatorNumHabitaciones implements Comparator<Anuncio> {

    private final boolean invert;

    public ComparatorNumHabitaciones(boolean invert) {
        this.invert = Objects.requireNonNullElse(invert, false);
    }

    @Override
    public int compare(Anuncio anuncio1, Anuncio anuncio2) {
        Anuncio a1 = anuncio1, a2 = anuncio2;
        if (invert) {
            a1 = anuncio2;
            a2 = anuncio1;
        }

        int total1 = a1.getApartamento().getNum_habitaciones() + a1.getApartamento().getNum_banos();
        int total2 = a2.getApartamento().getNum_habitaciones() + a2.getApartamento().getNum_banos();
        if (total1 == total2) return anuncio1.compareTo(anuncio2);
        return Integer.compare(total1, total2);


    }
}
