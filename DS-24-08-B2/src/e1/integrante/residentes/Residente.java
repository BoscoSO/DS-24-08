package e1.integrante.residentes;

import e1.integrante.Integrante;

public abstract class Residente extends Integrante {


    public enum casasHogwarts{
        Gryffindor, Hufflepuff, Ravenclaw, Slytherin
    }

    private final casasHogwarts casa;

    public Residente(String nombre, String apellido, int edad,casasHogwarts casa, int horrocruxesDestruidos,int galeonPorHorrocrux) throws IllegalArgumentException  {
        super(nombre, apellido, edad, horrocruxesDestruidos,galeonPorHorrocrux);
        if(casa==null)throw new IllegalArgumentException("Valor no puede ser nulo");
        this.casa = casa;
    }


    public casasHogwarts getCasa() {
        return casa;
    }

    @Override
    public float getRecompensaMinisterio() {
        float rwrd=getGaleonPorHorrocrux()*getHorrocruxesDestruidos();

        if(casa.equals(casasHogwarts.Slytherin))
            return rwrd*2;
        return rwrd;
    }
}
