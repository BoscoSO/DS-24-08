package e3;

import e3.Melody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e3.Melody.Accidentals;
import e3.Melody.Notes;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MelodyTest_e3 {

    private final float delta = 0.0001f;

    private Melody simpleMelody;

    @BeforeEach
    void setUp() {
        simpleMelody = new Melody();
        simpleMelody.addNote(Notes.DO, Accidentals.NATURAL, 5f);
        simpleMelody.addNote(Notes.RE, Accidentals.SHARP, 7f);
        simpleMelody.addNote(Notes.SOL, Accidentals.FLAT, 1.25f);
    }

    // test basic structure
    @Test
    void testBasic() {
        Melody emptyMelody = new Melody();
        assertEquals(0, emptyMelody.size());
        assertEquals(0, emptyMelody.getDuration(), delta);

        assertEquals(Notes.DO, simpleMelody.getNote(0));
        assertEquals(Accidentals.SHARP, simpleMelody.getAccidental(1));
        assertEquals(1.25f, simpleMelody.getTime(2), delta);
        assertEquals(3, simpleMelody.size());
        assertEquals(13.25, simpleMelody.getDuration(), delta);
    }

    @Test
    void testEquals() {
        Melody m1 = new Melody();
        Melody m2 = new Melody();

        assertEquals(m1, m2);
        assertEquals(m1.hashCode(), m2.hashCode());

        m1.addNote(Notes.DO, Accidentals.NATURAL, 1f);
        m1.addNote(Notes.RE, Accidentals.SHARP, 2f);
        m1.addNote(Notes.SOL, Accidentals.NATURAL, 3f);
        m1.addNote(Notes.FA, Accidentals.NATURAL, 1f);
        m1.addNote(Notes.MI, Accidentals.FLAT, 2f);
        m1.addNote(Notes.SI, Accidentals.NATURAL, 1f);
        m1.addNote(Notes.LA, Accidentals.FLAT, 1f);

        m2.addNote(Notes.DO, Accidentals.NATURAL, 1f);
        m2.addNote(Notes.RE, Accidentals.SHARP, 2f);
        m2.addNote(Notes.SOL, Accidentals.NATURAL, 3f);
        m2.addNote(Notes.FA, Accidentals.NATURAL, 1f);
        m2.addNote(Notes.MI, Accidentals.FLAT, 2f);
        m2.addNote(Notes.SI, Accidentals.NATURAL, 1f);
        m2.addNote(Notes.LA, Accidentals.FLAT, 1f);

        assertEquals(m1, m2);
        assertEquals(m1.hashCode(), m2.hashCode());
    }

    @Test
    void testEqualsAccidentals() {
        Melody m1 = new Melody();
        Melody m2 = new Melody();

        m1.addNote(Notes.DO, Accidentals.FLAT, 1f);
        m1.addNote(Notes.RE, Accidentals.SHARP, 2f);
        m1.addNote(Notes.SOL, Accidentals.NATURAL, 3f);
        m1.addNote(Notes.FA, Accidentals.NATURAL, 1f);
        m1.addNote(Notes.MI, Accidentals.FLAT, 2f);
        m1.addNote(Notes.SI, Accidentals.NATURAL, 1f);
        m1.addNote(Notes.LA, Accidentals.FLAT, 1f);
        m1.addNote(Notes.DO, Accidentals.NATURAL, 2f);
        m1.addNote(Notes.MI, Accidentals.SHARP, 2f);
        m1.addNote(Notes.LA, Accidentals.FLAT, 3f);
        m1.addNote(Notes.MI, Accidentals.NATURAL, 3f);
        m1.addNote(Notes.FA, Accidentals.SHARP, 2f);
        m1.addNote(Notes.RE, Accidentals.FLAT, 2f);

        m2.addNote(Notes.SI, Accidentals.NATURAL, 1f);
        m2.addNote(Notes.MI, Accidentals.FLAT, 2f);
        m2.addNote(Notes.SOL, Accidentals.NATURAL, 3f);
        m2.addNote(Notes.FA, Accidentals.NATURAL, 1f);
        m2.addNote(Notes.RE, Accidentals.SHARP, 2f);
        m2.addNote(Notes.SI, Accidentals.NATURAL, 1f);
        m2.addNote(Notes.SOL, Accidentals.SHARP, 1f);
        m2.addNote(Notes.SI, Accidentals.SHARP, 2f);
        m2.addNote(Notes.FA, Accidentals.NATURAL, 2f);
        m2.addNote(Notes.SOL, Accidentals.SHARP, 3f);
        m2.addNote(Notes.FA, Accidentals.FLAT, 3f);
        m2.addNote(Notes.SOL, Accidentals.FLAT, 2f);
        m2.addNote(Notes.DO, Accidentals.SHARP, 2f);

        assertEquals(m1, m2);
        assertEquals(m1.hashCode(), m2.hashCode());

    }

    @Test
    void testEqualsTypes() {
        assertEquals(simpleMelody, simpleMelody);
        assertNotEquals(null, simpleMelody);
        assertNotEquals("DOREMI", simpleMelody);
    }

    @Test
    void testNotEqualsSize() {
        Melody melody = new Melody();

        melody.addNote(Notes.DO, Accidentals.NATURAL, 1f);
        melody.addNote(Notes.RE, Accidentals.SHARP, 2.5f);

        assertNotEquals(melody, simpleMelody);
    }

    @Test
    void testNotEqualsNotes() {
        Melody m1 = new Melody();
        Melody m2 = new Melody();

        m1.addNote(Notes.MI, Accidentals.NATURAL, 1f);
        m1.addNote(Notes.FA, Accidentals.SHARP, 2.5f);
        m1.addNote(Notes.SOL, Accidentals.FLAT, 3f);

        m2.addNote(Notes.MI, Accidentals.NATURAL, 1f);
        m2.addNote(Notes.FA, Accidentals.SHARP, 2.5f);
        m2.addNote(Notes.LA, Accidentals.FLAT, 3f);

        assertNotEquals(m1, m2);
    }

    @Test
    void testNotEqualsAccidentals() {
        Melody m1 = new Melody();
        Melody m2 = new Melody();

        m1.addNote(Notes.DO, Accidentals.NATURAL, 1f);
        m1.addNote(Notes.RE, Accidentals.SHARP, 2.5f);
        m1.addNote(Notes.SOL, Accidentals.NATURAL, 3f);

        m2.addNote(Notes.DO, Accidentals.NATURAL, 1f);
        m2.addNote(Notes.RE, Accidentals.SHARP, 2.5f);
        m2.addNote(Notes.SOL, Accidentals.FLAT, 3f);

        assertNotEquals(m1, m2);
    }

    @Test
    void testNotEqualsTimes() {
        Melody m1 = new Melody();
        Melody m2 = new Melody();

        m1.addNote(Notes.DO, Accidentals.NATURAL, 1f);
        m1.addNote(Notes.RE, Accidentals.SHARP, 2.5f);
        m1.addNote(Notes.SOL, Accidentals.NATURAL, 3f);

        m2.addNote(Notes.DO, Accidentals.NATURAL, 1f);
        m2.addNote(Notes.RE, Accidentals.SHARP, 4f);
        m2.addNote(Notes.SOL, Accidentals.NATURAL, 3f);

        assertNotEquals(m1, m2);
    }

    @Test
    void testToString() {
        assertEquals("DO(5.0) RE#(7.0) SOLb(1.25)", simpleMelody.toString());
    }

    @Test
    void testHasCodeNotEquals() {
        Random r = new Random(System.currentTimeMillis());
        int tests = 100;
        int melodyLenght = 5;
        int count = 0;
        for (int i = 0; i < tests; i++) {
            Melody m1 = new Melody();
            Melody m2 = new Melody();
            for (int j = 0; j < melodyLenght; j++) {
                m1.addNote(
                        Notes.values()[r.nextInt(Notes.values().length)],
                        Accidentals.values()[r.nextInt(Accidentals.values().length)],
                        r.nextInt(3) + 1f);
                m2.addNote(
                        Notes.values()[r.nextInt(Notes.values().length)],
                        Accidentals.values()[r.nextInt(Accidentals.values().length)],
                        r.nextInt(3) + 1f);
            }
            if (!m1.equals(m2)) {
                count++;
            }
        }
        assertTrue(count >= tests * 0.75);  //check 75%
    }

    // test exceptions
    @Test
    void testExcetions() {
        Melody m = new Melody();

        assertThrows(IllegalArgumentException.class, () -> m.addNote(null, Accidentals.NATURAL, 1f));
        assertThrows(IllegalArgumentException.class, () -> m.addNote(Notes.DO, null, 1f));
        assertThrows(IllegalArgumentException.class, () -> m.addNote(Notes.DO, Accidentals.NATURAL, 0f));

        m.addNote(Notes.DO, Accidentals.NATURAL, 1f);
        assertThrows(IllegalArgumentException.class, () -> m.getNote(1));

    }
}