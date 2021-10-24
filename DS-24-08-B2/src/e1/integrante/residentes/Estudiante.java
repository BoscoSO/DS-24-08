package e1.integrante.residentes;

public class Estudiante extends Residente {

    public Estudiante(String nombre, String apellido, int edad, casasHogwarts casa, int horrocruxesDestruidos) {
        super(nombre, apellido, edad, casa, horrocruxesDestruidos,90);
    }


    @Override
    public String imprimirRecompensa() {
        return getNombre()+" "+getApellido()+" (Estudiante de "+getCasa()+", "+getHorrocruxesDestruidos()+" horrocruxes): "+getRecompensaMinisterio()+" galeones";
    }

}
