package e2.dto;

import java.util.Objects;

public class Anuncio implements Comparable<Anuncio> {

    private final int id_referencia;
    private final float precio_base;
    private final float precio_plz_garaje;
    private final Apartamento apartamento;


    public Anuncio(int id_referencia, float precio_base, float precio_plz_garaje, Apartamento apartamento) throws IllegalArgumentException {
        if(id_referencia<0 || apartamento==null || precio_base<=0 || precio_plz_garaje<0) throw new IllegalArgumentException("Argumentos invalidos");
        this.id_referencia = id_referencia;
        this.precio_base = precio_base;
        this.precio_plz_garaje = precio_plz_garaje;
        this.apartamento = apartamento;


    }
    public int getId_referencia() {
        return id_referencia;
    }
    public float getPrecio_base() {
        return precio_base;
    }
    public float getPrecio_plz_garaje() {
        return precio_plz_garaje;
    }
    public Apartamento getApartamento() {
        return apartamento;
    }

    @Override
    public int compareTo(Anuncio o) {
        if(id_referencia<=o.getId_referencia()){
            if(id_referencia==o.getId_referencia())
                return 0;
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anuncio anuncio = (Anuncio) o;
        return Float.compare(anuncio.precio_base, precio_base) == 0 && Float.compare(anuncio.precio_plz_garaje, precio_plz_garaje) == 0 && Objects.equals(apartamento, anuncio.apartamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash( precio_base, precio_plz_garaje, apartamento);
    }

    @Override
    public String toString() {
        return "Anuncio [" +id_referencia+"]";
              /*  "id_referencia=" + id_referencia +
                ", precio_base=" + precio_base +
                ", precio_plz_garaje=" + precio_plz_garaje +
                ", apartamento=" + apartamento +
                '}';*/
    }
}
