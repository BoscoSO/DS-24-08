package e1.integrante.personal;

import e1.integrante.Integrante;

public abstract class Personal extends Integrante {


    public Personal(String nombre, String apellido, int edad,int horrocruxesDestruidos,int galeonPorHorrocrux) {
        super(nombre, apellido, edad,horrocruxesDestruidos,galeonPorHorrocrux);

    }

    public abstract int getSueldo();

    @Override
    public float getRecompensaMinisterio() {
        return getGaleonPorHorrocrux()*getHorrocruxesDestruidos();
    }

    public abstract String imprimirSalario();
}
