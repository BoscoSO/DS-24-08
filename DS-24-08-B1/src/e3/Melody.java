package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Melody {

    public enum Notes {
        DO, RE, MI, FA, SOL, LA, SI
    }

    public enum Accidentals {
        NATURAL, SHARP, FLAT
    }


    List<NoteInMel> melody;                 //Contiene la sucesion de notas con sus accidentales y duraciones

    /**
     * Creates an empty e3.Melody instance .
     */
    public Melody() {
        melody = new ArrayList<>();    //Inicio la lista vacia
    }

    /**
     * Add a note at the end of this melody .
     *
     * @param note       The note to add
     * @param accidental The accidental of the note
     * @param time       The duration of the note in milliseconds
     * @throws IllegalArgumentException if the note , the accidental
     *                                  or the time are not valid values .
     */
    public void addNote(Notes note, Accidentals accidental, float time) throws IllegalArgumentException {

        if (time <= 0) throw new IllegalArgumentException("El tiempo no puede ser menor que 0");        //compruebo que los valores no sean erroneos
        if (note == null || accidental == null)
            throw new IllegalArgumentException("Valores no válidos");
        else
            melody.add(new NoteInMel(note, accidental, time));                          //Añado la nueva nota a la melodia
    }

    /**
     * Returns the note on the given position
     *
     * @param index The position of the note to get .
     * @return The note on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Notes getNote(int index) throws IllegalArgumentException {

        if (index >= melody.size() || index < 0) throw new IllegalArgumentException("Posición erronea");        //Compruebo que los valores no sean erroneos

        return melody.get(index).getNote();                                             //recupero la nota
    }

    /**
     * Returns the accidental of the note on the given position
     *
     * @param index The position of the accidental to get .
     * @return The accidental on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Accidentals getAccidental(int index) throws IllegalArgumentException {

        if (index >= melody.size() || index < 0) throw new IllegalArgumentException("Posición erronea");        //Compruebo que los valores no sean erroneos

        return melody.get(index).getAccidental();                                             //recupero el accidental de la nota
    }

    /**
     * Returns the duration of the note on the given position
     *
     * @param index The position of the time to get .
     * @return The time on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public float getTime(int index) throws IllegalArgumentException {

        if (index >= melody.size() || index < 0) throw new IllegalArgumentException("Posición erronea");        //Compruebo que los valores no sean erroneos

        return melody.get(index).getDuration();                                             //recupero la duracion de la nota
    }

    /**
     * Returns the number of notes in this melody .
     *
     * @return The number of notes in this melody .
     */
    public int size() {
        return melody.size();                                             //devuelvo el tamaño de la lista
    }

    /**
     * Returns the duration of this melody .
     *
     * @return The duration of this melody in milliseconds .
     */
    public float getDuration() {
        float duration = 0f;
        for (NoteInMel n : melody) {
            duration += n.getDuration();        //Sumo las distintas duraciones de las notas en la melodia
        }
        return duration;
    }

    /**
     * Performs the equality tests of the current melody with another melody
     * passed as a parameter . Two melodies are equal if they represent the same
     * music fragment regardless of the name of its notes .
     *
     * @param o The melody to be compared with the current melody .
     *          6
     * @return true if the melodies are equals , false otherwise .
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melody melody1 = (Melody) o;

        return Objects.equals(melody, melody1.melody);
    }

    /**
     * Returns an integer that is a hash code representation of the melody .
     * Two melodies m1 , m2 that are equals (m1. equals (m2) == true ) must
     * have the same hash code .
     *
     * @return The hash code of this melody .
     */
    @Override
    public int hashCode() {
        return Objects.hash(melody);
    }

    @Override
    public String toString() {
        String cad = "";
        boolean spc = false;
        for (NoteInMel n : melody) {
            if (spc)
                cad += " ";

            cad += n.getNote();
            if (n.getAccidental() == Accidentals.SHARP) {
                cad += "#";
            } else if (n.getAccidental() == Accidentals.FLAT) {
                cad += "b";
            }
            cad += "(" + n.getDuration() + ")";
            spc = true;
        }

        return cad;
    }


}