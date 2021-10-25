package e2.dto;

public class Anuncio implements Comparable<Anuncio> {

    private final int id_referencia;
    private final float precio_base;
    private final float precio_plz_garaje;
    private final Apartamento apartamento;


    public Anuncio(int id_referencia, float precio_base, float precio_plz_garaje, Apartamento apartamento) {
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
    public String toString() {
        return "Anuncio{" +
                "id_referencia=" + id_referencia +
                ", precio_base=" + precio_base +
                ", precio_plz_garaje=" + precio_plz_garaje +
                ", apartamento=" + apartamento +
                '}';
    }
}
