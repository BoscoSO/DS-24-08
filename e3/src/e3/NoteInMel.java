package e3;

import e3.Melody;

public class NoteInMel {
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
}
