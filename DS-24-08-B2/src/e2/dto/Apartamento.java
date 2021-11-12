package e2.dto;

import java.util.Objects;

public class Apartamento {

    private final int plazas_garaje;
    private final int codigo_postal;
    private final float dimensiones;
    private final int num_habitaciones;
    private final int num_banos;
    private final int num_portal;
    private final char letra;

    public Apartamento(int plazas_garaje, int codigo_postal, float dimensiones, int num_habitaciones, int num_banos, int num_portal, char letra) throws IllegalArgumentException{
        if(dimensiones<=0 || num_habitaciones<=0 || num_banos<=0 || plazas_garaje<0) throw new IllegalArgumentException("Argumentos invalidos");
        this.plazas_garaje = plazas_garaje;
        this.codigo_postal = codigo_postal;
        this.dimensiones = dimensiones;
        this.num_habitaciones = num_habitaciones;
        this.num_banos = num_banos;
        this.num_portal = num_portal;
        this.letra = letra;
    }

    public int getPlazas_garaje() {
        return plazas_garaje;
    }
    public int getCodigo_postal() {
        return codigo_postal;
    }
    public float getDimensiones() {
        return dimensiones;
    }
    public int getNum_habitaciones() {
        return num_habitaciones;
    }
    public int getNum_banos() {
        return num_banos;
    }
    public int getNum_portal() {
        return num_portal;
    }
    public char getLetra() {
        return letra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamento that = (Apartamento) o;
        return plazas_garaje == that.plazas_garaje && codigo_postal == that.codigo_postal && Float.compare(that.dimensiones, dimensiones) == 0 && num_habitaciones == that.num_habitaciones && num_banos == that.num_banos && num_portal == that.num_portal && letra == that.letra;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plazas_garaje, codigo_postal, dimensiones, num_habitaciones, num_banos, num_portal, letra);
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "plazas_garaje=" + plazas_garaje +
                ", codigo_postal=" + codigo_postal +
                ", dimensiones=" + dimensiones +
                ", num_habitaciones=" + num_habitaciones +
                ", num_banos=" + num_banos +
                ", num_portal=" + num_portal +
                ", letra=" + letra +
                '}';
    }
}
