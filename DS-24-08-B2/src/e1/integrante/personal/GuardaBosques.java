package e1.integrante.personal;

public class GuardaBosques extends Personal{
    private final int SUELDO_BASE_GUARDA=170;
    private final int PLUS_NOCTURNIDAD=10;

    public GuardaBosques(String nombre, String apellido, int edad, int horrocruxesDestruidos) {
        super(nombre, apellido, edad,horrocruxesDestruidos,75);

    }

    @Override
    public int getSueldo() {
        return SUELDO_BASE_GUARDA+PLUS_NOCTURNIDAD;
    }


    @Override
    public String imprimirRecompensa() {
        return getNombre()+" "+getApellido()+" (GuardaBosques, "+getHorrocruxesDestruidos()+" horrocruxes): "+getRecompensaMinisterio()+" galeones";
    }
    @Override
    public String imprimirSalario() {
        return getNombre()+" "+getApellido()+" (GuardaBosques): "+getSueldo()+" galeones";
    }


}
