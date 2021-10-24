package e1.integrante;

public abstract class Integrante {

    private final String nombre;
    private final String apellido;
    private final int edad;
    private int horrocruxesDestruidos;
    private final int galeonPorHorrocrux;

    public Integrante(String nombre, String apellido, int edad, int horrocruxesDestruidos,int galeonPorHorrocrux) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.horrocruxesDestruidos = horrocruxesDestruidos;
        this.galeonPorHorrocrux = galeonPorHorrocrux;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getHorrocruxesDestruidos() {
        return horrocruxesDestruidos;
    }

    public void setHorrocruxesDestruidos(int horrocruxesDestruidos) {
        this.horrocruxesDestruidos = horrocruxesDestruidos;
    }

    public int getGaleonPorHorrocrux() {
        return galeonPorHorrocrux;
    }

    public abstract float getRecompensaMinisterio();


    public abstract String imprimirRecompensa();
}
