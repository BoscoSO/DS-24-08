package e1.dto;

public class Billete {
    private final double precio;
    private final String destino;
    private final String origen;
    private final String fecha;                 //de la forma dd/mm/yy


    public Billete(double precio, String origen, String destino, String fecha) {
        this.precio = precio;
        this.destino = destino;
        this.origen = origen;
        this.fecha = fecha;
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
        return "Billete:" + precio +
                "€ | " + origen +
                " --> " + destino +
                " |" + fecha + "|\n";
    }
}
