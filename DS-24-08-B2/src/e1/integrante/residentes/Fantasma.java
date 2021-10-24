package e1.integrante.residentes;

public class Fantasma  extends Residente{


    public Fantasma(String nombre, String apellido, int edad, casasHogwarts casa,int horrocruxesDestruidos) {
        super(nombre, apellido, edad, casa,horrocruxesDestruidos,80);
    }
    @Override
    public String imprimirRecompensa() {
        return getNombre()+" "+getApellido()+" (Fantasma de "+getCasa()+", "+getHorrocruxesDestruidos()+" horrocruxes): "+getRecompensaMinisterio()+" galeones";
    }

}
