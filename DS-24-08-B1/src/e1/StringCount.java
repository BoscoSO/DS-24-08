package e1;

import java.util.Locale;

public class StringCount {
    /**
     * Counts the number of words in a given String .
     * Words are groups of characters separated by one or more spaces .
     *
     * @param text String with the words
     * @return Number of words in the String or zero if it is null
     */
    public static int countWords(String text) {
        if (text == null) return 0;
        int cont = 0;

        for (String c : text.split(" ")) {
            if (c.length() != 0) cont++;
        }
        return cont;
    }

    /**
     * Counts the number of times the given character appears in the String .
     * Accented characters are considered different characters .
     *
     * @param text String with the characters
     * @param c    the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countChar(String text, char c) {
        if (text == null) return 0;
        int cont = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) {
                cont++;
            }
        }
        return cont;
    }

    /**
     * Counts the number of times the given character appears in the String .
     * The case is ignored so an ’a’ is equal to an ’A ’.
     * Accented characters are considered different characters .
     *
     * @param text String with the characters
     * @param c    the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countCharIgnoringCase(String text, char c) {
        if (text == null) return 0;
        int cont = 0;
        text = text.toLowerCase();
        c = Character.toLowerCase(c);
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) {
                cont++;
            }
        }
        return cont;
    }

    /**
     * Checks if a password is safe according to the following rules :
     * - Has at least 8 characters
     * - Has an uppercase character
     * - Has a lowercase character
     * - Has a digit
     * - Has a special character among these : ’? ’, ’@ ’, ’#’, ’$ ’, ’. ’ and ’,’
     *
     * @param password The password , we assume it is not null .
     * @return true if the password is safe , false otherwise
     */
    public static boolean isPasswordSafe(String password) {
        char ch;
        if (password.length() >= 8) {
            boolean upperCaseFlag = false;
            boolean lowerCaseFlag = false;
            boolean digitFlag = false;
            boolean specialFlag = false;

            for (int i = 0; i < password.length(); i++) {
                ch = password.charAt(i);
                if (Character.isDigit(ch)) {
                    digitFlag = true;
                } else if (Character.isUpperCase(ch)) {
                    upperCaseFlag = true;
                } else if (Character.isLowerCase(ch)) {
                    lowerCaseFlag = true;
                } else if (ch=='?' ||ch=='@' ||ch=='#' ||ch=='$' ||ch=='.' ||ch==',') {
                    specialFlag = true;
                }
                if (digitFlag && upperCaseFlag && lowerCaseFlag && specialFlag)
                    return true;
            }
        }
        return false;
    }
}