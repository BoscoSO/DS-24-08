package e1.dto;

import java.util.Objects;

public class Billete{
    private final double precio;
    private final String origen;
    private final String destino;
    private final String fecha;

    public Billete(double precio,String origen,String destino,String fecha) throws IllegalArgumentException {
        if (origen == null || destino == null || fecha == null) throw new IllegalArgumentException("parametro null");
        if (precio <= 0.0) throw new IllegalArgumentException("El precio no puede ser negativo o 0");
        this.precio=precio;
        this.origen=origen;
        this.destino=destino;
        this.fecha=fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigen() {
        return origen;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billete billete = (Billete) o;
        return Double.compare(billete.precio, precio) == 0 && origen.equals(billete.origen) && destino.equals(billete.destino) && fecha.equals(billete.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precio, origen, destino, fecha);
    }

    @Override
    public String toString() {
        return "Billete: " + String.format("%.2f", precio) + "€ | " + origen + " --> " + destino + " |" + fecha + "|\n";
    }
}
