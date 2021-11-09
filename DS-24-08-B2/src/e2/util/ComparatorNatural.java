package e2.util;

import e2.dto.Anuncio;

import java.util.Comparator;
import java.util.Objects;

public class ComparatorNatural implements Comparator<Anuncio> {


    private final boolean invert;

    public ComparatorNatural(boolean invert) {
        this.invert = Objects.requireNonNullElse(invert, false);
    }

    @Override
    public int compare(Anuncio anuncio1, Anuncio anuncio2) {
        if (invert)
            return anuncio2.compareTo(anuncio1);
        return anuncio1.compareTo(anuncio2);

    }
}
