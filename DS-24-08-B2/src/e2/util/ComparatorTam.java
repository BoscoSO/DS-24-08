package e2.util;

import e2.dto.Anuncio;

import java.util.Comparator;
import java.util.Objects;

public class ComparatorTam implements Comparator<Anuncio> {

    private final boolean invert;

    public ComparatorTam(boolean invert) {
        this.invert = Objects.requireNonNullElse(invert, false);
    }

    @Override
    public int compare(Anuncio anuncio1, Anuncio anuncio2) {
        Anuncio a1 = anuncio1, a2 = anuncio2;
        if (invert) {
            a1 = anuncio2;
            a2 = anuncio1;
        }

        float dims1 = a1.getApartamento().getDimensiones();
        float dims2 = a2.getApartamento().getDimensiones();
        if (dims1 == dims2) return anuncio1.compareTo(anuncio2);
        return Float.compare(dims1, dims2);

    }
}
