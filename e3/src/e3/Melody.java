package e3;

import java.util.ArrayList;
import java.util.List;

public class Melody {

    public enum Notes {
        DO, RE, MI, FA, SOL, LA, SI
    }

    public enum Accidentals {
        NATURAL, SHARP, FLAT
    }


    List<NoteInMel> melody;

    /**
     * Creates an empty e3.Melody instance .
     */
    public Melody() {
        melody = new ArrayList<NoteInMel>();
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
        if (time <= 0) throw new IllegalArgumentException("El tiempo no puede ser menor que 0");

        melody.add(new NoteInMel(note, accidental, time));
    }

    /**
     * Returns the note on the given position
     *
     * @param index The position of the note to get .
     * @return The note on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Notes getNote(int index) throws IllegalArgumentException {

        if (index >= melody.size() || index < 0) throw new IllegalArgumentException("Posicion erronea");

        return melody.get(index).getNote();
    }

    /**
     * Returns the accidental of the note on the given position
     *
     * @param index The position of the accidental to get .
     * @return The accidental on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Accidentals getAccidental(int index) throws IllegalArgumentException {

        if (index >= melody.size() || index < 0) throw new IllegalArgumentException("Posicion erronea");

        return melody.get(index).getAccidental();
    }

    /**
     * Returns the duration of the note on the given position
     *
     * @param index The position of the time to get .
     * @return The time on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public float getTime(int index) throws IllegalArgumentException {

        if (index >= melody.size() || index < 0) throw new IllegalArgumentException("Posicion erronea");

        return melody.get(index).getDuration();
    }

    /**
     * Returns the number of notes in this melody .
     *
     * @return The number of notes in this melody .
     */
    public int size() {
        return melody.size();
    }

    /**
     * Returns the duration of this melody .
     *
     * @return The duration of this melody in milliseconds .
     */
    public float getDuration() {
        float duration=0f;
        for(NoteInMel n: melody){
            duration+=n.getDuration();
        }
        return duration;
    }


    @Override
    public String toString() { /* ... */
        return "";
    }
}