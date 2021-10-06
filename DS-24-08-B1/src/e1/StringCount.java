
package e1;

public class StringCount {
        /**
         * Counts the number of words in a given String .
         * Words are groups of characters separated by one or more spaces .
         *
         * @param text String with the words
         * @return Number of words in the String or zero if it is null
         */
        public static int countWords(String text) {
            if (text == null) {                     //Comprobaciones
                return 0;
            } else {
                int cont = 0;
                String[] parts = text.split(" ");       //Divido el string en partes separando por espacios


                for (String c : parts) {       //Compruebo las partes que tengan algo dentro
                    if (c.length() != 0) {
                        ++cont;
                    }
                }

                return cont;
            }
        }
        /**
         * Counts the number of times the given character appears in the String .
         * Accented characters are considered different characters .
         * @param text String with the characters
         * @param c the character to be found
         * @return Number of times the character appears in the String or zero if null
         */
        public static int countChar(String text, char c) {
            if (text == null) {                         //Comprobaciones
                return 0;
            } else {
                int cont = 0;

                for(int i = 0; i < text.length(); ++i) {        //Recorro el string en busca del caracter pedido
                    if (text.charAt(i) == c) {
                        ++cont;
                    }
                }

                return cont;
            }
        }
        /**
         * Counts the number of times the given character appears in the String .
         * The case is ignored so an ’a’ is equal to an ’A ’.
         * Accented characters are considered different characters .
         * @param text String with the characters
         * @param c the character to be found
         * @return Number of times the character appears in the String or zero if null
         */
        public static int countCharIgnoringCase(String text, char c) {
            if (text == null) {                                     //Comprobaciones
                return 0;
            } else {
                int cont = 0;
                text = text.toLowerCase();                          //Paso el string y el char a minusculas para no distinguir entre estos
                c = Character.toLowerCase(c);

                for(int i = 0; i < text.length(); ++i) {            //Recorro el string en busca del caracter pedido
                    if (text.charAt(i) == c) {
                        ++cont;
                    }
                }

                return cont;
            }
        }
        /**
         * Checks if a password is safe according to the following rules :
         * - Has at least 8 characters
         * - Has an uppercase character
         * - Has a lowercase character
         * - Has a digit
         * - Has a special character among these : ’? ’, ’@ ’, ’#’, ’$ ’, ’. ’ and ’,’
         * @param password The password , we assume it is not null .
         * @return true if the password is safe , false otherwise
         */
        public static boolean isPasswordSafe(String password) {
            if (password.length() >= 8) {                           //Compruebo tamaño
                //Flags necesarios
                boolean upperCaseFlag = false;
                boolean lowerCaseFlag = false;
                boolean digitFlag = false;
                boolean specialFlag = false;

                for(int i = 0; i < password.length(); ++i) {        //Recorro el string comprobando para activar los flags
                    char ch = password.charAt(i);
                    if (Character.isDigit(ch)) {
                        digitFlag = true;
                    } else if (Character.isUpperCase(ch)) {
                        upperCaseFlag = true;
                    } else if (Character.isLowerCase(ch)) {
                        lowerCaseFlag = true;
                    } else if (ch == '?' || ch == '@' || ch == '#' || ch == '$' || ch == '.' || ch == ',') {
                        specialFlag = true;
                    }

                    if (digitFlag && upperCaseFlag && lowerCaseFlag && specialFlag) {   //Si se cumplen todos devuelve true
                        return true;
                    }
                }
            }

            return false;
        }









}
