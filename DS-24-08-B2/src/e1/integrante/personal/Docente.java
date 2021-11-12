package e1.integrante.personal;

public class Docente extends Personal {
    public enum asignaturas {
        Historia {
            @Override
            public int getSueldo() {
                return 200;
            }
        },
        Transformaciones {
            @Override
            public int getSueldo() {
                return 400;
            }
        },
        Defensa {
            @Override
            public int getSueldo() {
                return 500;
            }
        },
        Herbologia {
            @Override
            public int getSueldo() {
                return 250;
            }
        },
        Pociones{
            @Override
            public int getSueldo() {
                return 350;
            }
        };
        public abstract int getSueldo();
    }


    private final asignaturas materia_impartida;

    public Docente(String nombre, String apellido, int edad, asignaturas materia_impartida,int horrocruxesDestruidos) throws IllegalArgumentException  {
        super(nombre, apellido, edad,horrocruxesDestruidos,50);
        if(materia_impartida==null) throw new IllegalArgumentException("Valor no puede ser nulo");
        this.materia_impartida = materia_impartida;
    }

    @Override
    public int getSueldo() {
        return materia_impartida.getSueldo();
    }

    @Override
    public float getRecompensaMinisterio() {
        float rwrd=getGaleonPorHorrocrux()*getHorrocruxesDestruidos();
        if(materia_impartida.equals(asignaturas.Defensa))
            return rwrd-rwrd/4;
        return rwrd;
    }


    @Override
    public String imprimirRecompensa() {
        return getNombre()+" "+getApellido()+" (Docente de "+materia_impartida+", "+getHorrocruxesDestruidos()+" horrocruxes): "+getRecompensaMinisterio()+" galeones";
    }
    @Override
    public String imprimirSalario() {
        return getNombre()+" "+getApellido()+" (Docente de "+materia_impartida+"): "+getSueldo()+" galeones";
    }
}
