
package e1;

public class StringCount {
    public StringCount() {
    }

    public static int countWords(String text) {
        if (text == null) {
            return 0;
        } else {
            int cont = 0;
            String[] var2 = text.split(" ");
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String c = var2[var4];
                if (c.length() != 0) {
                    ++cont;
                }
            }

            return cont;
        }
    }

    public static int countChar(String text, char c) {
        if (text == null) {
            return 0;
        } else {
            int cont = 0;

            for(int i = 0; i < text.length(); ++i) {
                if (text.charAt(i) == c) {
                    ++cont;
                }
            }

            return cont;
        }
    }

    public static int countCharIgnoringCase(String text, char c) {
        if (text == null) {
            return 0;
        } else {
            int cont = 0;
            text = text.toLowerCase();
            c = Character.toLowerCase(c);

            for(int i = 0; i < text.length(); ++i) {
                if (text.charAt(i) == c) {
                    ++cont;
                }
            }

            return cont;
        }
    }

    public static boolean isPasswordSafe(String password) {
        if (password.length() >= 8) {
            boolean upperCaseFlag = false;
            boolean lowerCaseFlag = false;
            boolean digitFlag = false;
            boolean specialFlag = false;

            for(int i = 0; i < password.length(); ++i) {
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

                if (digitFlag && upperCaseFlag && lowerCaseFlag && specialFlag) {
                    return true;
                }
            }
        }

        return false;
    }
}
