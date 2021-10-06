package e3;

import java.util.Objects;

import static e3.Melody.Accidentals.*;
import static e3.Melody.Notes.*;

public class NoteInMel {                    //Objeto que representa una nota en la melodia,
                                            //Contiene un accidental y una duración
    private final Melody.Notes note;
    private final Melody.Accidentals accidental;
    private final float duration;

    public NoteInMel(Melody.Notes note, Melody.Accidentals accidental, float duration) {
        this.note = note;
        this.accidental = accidental;
        this.duration = duration;
    }

    public Melody.Notes getNote() {
        return note;
    }

    public Melody.Accidentals getAccidental() {
        return accidental;
    }

    public float getDuration() {
        return duration;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteInMel noteInMel = (NoteInMel) o;

        switch (note) {         //Comprobacion de las equivalencias entre notas
            case DO -> {
                switch (accidental) {
                    case NATURAL:
                        if (noteInMel.note == Melody.Notes.SI && noteInMel.accidental == Melody.Accidentals.SHARP && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case SHARP:
                        if (noteInMel.note == RE && noteInMel.accidental == FLAT && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case FLAT:
                        if (noteInMel.note == Melody.Notes.SI && noteInMel.accidental == Melody.Accidentals.NATURAL && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                }
            }
            case RE -> {
                switch (accidental) {
                    case SHARP:
                        if (noteInMel.note == Melody.Notes.MI && noteInMel.accidental == FLAT && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case FLAT:
                        if (noteInMel.note == Melody.Notes.DO && noteInMel.accidental == Melody.Accidentals.SHARP && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                }
            }
            case MI -> {
                switch (accidental) {
                    case NATURAL:
                        if (noteInMel.note == Melody.Notes.FA && noteInMel.accidental == FLAT && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case SHARP:
                        if (noteInMel.note == Melody.Notes.FA && noteInMel.accidental == Melody.Accidentals.NATURAL && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case FLAT:
                        if (noteInMel.note == RE && noteInMel.accidental == Melody.Accidentals.SHARP && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                }
            }
            case FA -> {
                switch (accidental) {
                    case NATURAL:
                        if (noteInMel.note == Melody.Notes.MI && noteInMel.accidental == Melody.Accidentals.SHARP && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case SHARP:
                        if (noteInMel.note == Melody.Notes.SOL && noteInMel.accidental == FLAT && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case FLAT:
                        if (noteInMel.note == Melody.Notes.MI && noteInMel.accidental == Melody.Accidentals.NATURAL && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                }
            }
            case SOL -> {
                switch (accidental) {
                    case SHARP:
                        if (noteInMel.note == Melody.Notes.LA && noteInMel.accidental == FLAT && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case FLAT:
                        if (noteInMel.note == Melody.Notes.FA && noteInMel.accidental == Melody.Accidentals.SHARP && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                }
            }
            case LA -> {
                switch (accidental) {
                    case SHARP:
                        if (noteInMel.note == Melody.Notes.SI && noteInMel.accidental == FLAT && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case FLAT:
                        if (noteInMel.note == Melody.Notes.SOL && noteInMel.accidental == Melody.Accidentals.SHARP && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                }
            }
            case SI -> {
                switch (accidental) {
                    case NATURAL:
                        if (noteInMel.note == Melody.Notes.DO && noteInMel.accidental == FLAT && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case SHARP:
                        if (noteInMel.note == Melody.Notes.DO && noteInMel.accidental == Melody.Accidentals.NATURAL && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                    case FLAT:
                        if (noteInMel.note == Melody.Notes.LA && noteInMel.accidental == Melody.Accidentals.SHARP && Float.compare(duration, noteInMel.duration) == 0)
                            return true;
                        break;
                }
            }
        }


        return Float.compare(noteInMel.duration, duration) == 0 && note == noteInMel.note && accidental == noteInMel.accidental; //Para el resto
    }

    @Override
    public int hashCode() {
        switch (note) {                 //Devuelvo el mismo hashcode para las notas que son equivalentes
            case DO -> {
                if(accidental== SHARP) return Objects.hash(RE,FLAT,duration);
            }
            case RE ->{
                if(accidental== SHARP) return Objects.hash(MI,FLAT,duration);
            }
            case MI ->{
                if(accidental== SHARP) return Objects.hash(FA,NATURAL,duration);
                if(accidental== NATURAL) return Objects.hash(FA,FLAT,duration);
            }
            case FA ->{
                if(accidental== SHARP) return Objects.hash(SOL,FLAT,duration);
            }
            case SOL ->{
                if(accidental== SHARP) return Objects.hash(LA,FLAT,duration);
            }
            case LA ->{
                if(accidental== SHARP) return Objects.hash(SI,FLAT,duration);
            }
            case SI ->{
                if(accidental== NATURAL) return Objects.hash(DO,FLAT,duration);
                if(accidental== SHARP) return Objects.hash(DO, NATURAL,duration);
            }
        }

        return Objects.hash(note, accidental, duration);    //Las demas se generan solas
    }
}
