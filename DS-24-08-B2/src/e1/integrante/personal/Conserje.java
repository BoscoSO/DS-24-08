package e1.integrante.personal;

public class Conserje extends Personal{
    private final int SUELDO_BASE_CONSERJE=150;
    private final int PLUS_NOCTURNIDAD=10;

    public Conserje(String nombre, String apellido, int edad, int horrocruxesDestruidos) {
        super(nombre, apellido, edad,horrocruxesDestruidos,65);

    }

    @Override
    public int getSueldo() {
        return SUELDO_BASE_CONSERJE+PLUS_NOCTURNIDAD;
    }



    @Override
    public String imprimirRecompensa() {
        return getNombre()+" "+getApellido()+" (Conserje, "+getHorrocruxesDestruidos()+" horrocruxes): "+getRecompensaMinisterio()+" galeones";
    }
    @Override
    public String imprimirSalario() {
        return getNombre()+" "+getApellido()+" (Conserje): "+getSueldo()+" galeones";
    }
}
