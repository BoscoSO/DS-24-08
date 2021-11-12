package e1;

import e1.StringCount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCountTest_e1 {
    @Test
    public void countWords() {
        assertEquals(0, StringCount.countWords(null));
        assertEquals(1, StringCount.countWords("OneWord"));
        assertEquals(2, StringCount.countWords("Two words"));
        assertEquals(4, StringCount.countWords("spaces at the end     "));
        assertEquals(4, StringCount.countWords("    many    spaces   between      words   "));
        assertEquals(1, StringCount.countWords("words,separated-by.special$characters@"));
        assertEquals(10, StringCount.countWords("Normal text a little long with CAPITALS and lowercase letters"));
        assertEquals(7, StringCount.countWords("Oración en español con eñe y acentos"));
    }

    @Test
    void countChar() {
        assertEquals(0, StringCount.countChar(null, 'a'));
        assertEquals(2, StringCount.countChar("Timeo Danaos et dona ferentes", 't'));
        assertEquals(3, StringCount.countChar("Romani ite domum", 'm'));
        assertEquals(1, StringCount.countChar("Mater tua mala burra est", 'M'));
        assertEquals(1, StringCount.countChar("Ñandú Cañón", 'ñ'));
        assertEquals(1, StringCount.countChar("Un Ñandú Único", 'ú'));
    }

    @Test
    void countCharIgnoringCase() {
        assertEquals(0, StringCount.countCharIgnoringCase(null, 'a'));
        assertEquals(3, StringCount.countCharIgnoringCase("Timeo Danaos et dona ferentes", 't'));
        assertEquals(3, StringCount.countCharIgnoringCase("Romani ite domum", 'm'));
        assertEquals(2, StringCount.countCharIgnoringCase("Mater tua mala burra est", 'M'));
        assertEquals(2, StringCount.countCharIgnoringCase("Ñandú Cañon", 'ñ'));
        assertEquals(2, StringCount.countCharIgnoringCase("Un Ñandú Único", 'ú'));
    }

    @Test
    void isPasswordSafe() {
        assertFalse(StringCount.isPasswordSafe("123456")); // less than 8
        assertFalse(StringCount.isPasswordSafe("WHAT'S UP, DOC?")); // No lowercase
        assertFalse(StringCount.isPasswordSafe("what's up, doc?")); // No uppercase
        assertFalse(StringCount.isPasswordSafe("What's Up, Doc?")); // No digit
        assertFalse(StringCount.isPasswordSafe("What's Up Doc")); // No special
        assertFalse(StringCount.isPasswordSafe("Doc? 5")); // less than 8
        assertTrue(StringCount.isPasswordSafe("What's Up, Doc? 5")); // OK
    }
}
