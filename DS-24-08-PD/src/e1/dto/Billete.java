package e1.dto;

public record Billete(double precio, String origen, String destino, String fecha) {
    /**
     * @throws IllegalArgumentException
     */
    public Billete {
        if (origen == null || destino == null || fecha == null) throw new IllegalArgumentException("parametro null");
        if (precio <= 0.0) throw new IllegalArgumentException("El precio no puede ser negativo o 0");
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
    public String toString() {
        return "Billete: " + String.format("%.2f", precio) + "€ | " + origen + " --> " + destino + " |" + fecha + "|\n";
    }
}
