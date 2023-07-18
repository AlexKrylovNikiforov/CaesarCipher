import Service.LanguageChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BruteForceCipher {

    private final String SPEC_CHARS = "[$&+,:;=?@#|'<>.-^*()%!]";
    public String simpleDecryption (String inputPath) {
        CaesarCipher cc = new CaesarCipher();

        if (!isAbsolutePath(inputPath)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                inputPath = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String decryptedText;
        try {
            String text = Files.readString(Path.of(inputPath));
            int offset = getOffset(text);
            decryptedText = cc.decrypt(text, offset);
        } catch (IOException e) {
            throw new RuntimeException(e.getCause());
        }
        return decryptedText;
    }

    private boolean isAbsolutePath(String inputPath) {
        Path p = Paths.get(inputPath);
        return p.isAbsolute() && Files.exists(p);
    }

    public String noSpecCharsDecryption (String inputText) {
        CaesarCipher cc = new CaesarCipher();
        LanguageChecker lc = new LanguageChecker();
        String decryptedText = null;
        try {
            String text = Files.readString(Path.of(inputText));
            for (int i = 0; i < 256; i++) {
                int offset = i;
                decryptedText = cc.decrypt(text, offset);
                String languageByPattern = lc.getLanguageByPattern(decryptedText);
                if(!languageByPattern.equals("")) {
                    return String.format("Language: %s%n Decrypted text: %s", languageByPattern, decryptedText);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        return decryptedText;
    }

    public String smallTextDecryption(String inputText) {
        CaesarCipher cc = new CaesarCipher();
        LanguageChecker lc = new LanguageChecker();
        StringBuilder decryptedText = new StringBuilder();
        for (int key = 0; key < 256; key++) {
            StringBuilder decryptedAttempt = new StringBuilder();
            for (int i = 0; i < inputText.length(); i++) {
                char ch = inputText.charAt(i);
                int value = (int) ch;
                int decryptedValue = (value - key + 256) % 256; //256 is the maximum value of ASCII symbols
                char decryptedChar = (char) decryptedValue;
                decryptedAttempt.append(decryptedChar);
            }
            String decryptedString = decryptedAttempt.toString();
            if (lc.getLanguageByPattern(decryptedString) != "") {
                return decryptedString;
            }
            decryptedText.append(decryptedAttempt).append("\n");
        }
        return decryptedText.toString();
    }

    private boolean isDifferenceEqual(int firstValue, int secondValue, int thirdValue, int fourthValue) {
        int dif1 = secondValue - firstValue;
        int dif2 = fourthValue - thirdValue;
        return dif1 == dif2;
    }
    
    private int getOffset(String text) {
        int offset = 0;
        for (int i = 0; i < text.length(); i++) {
            int firstValue = text.charAt(i);
            int secondValue = (i+1) == text.length() ? 0 : (int) text.charAt(i+1);
            int COMMA_VALUE = 44;
            int SPACE_VALUE = 32;
            int DOT_VALUE = 46;
            if(secondValue == 0 || secondValue == 10) {
                offset = (int) text.charAt(i) - DOT_VALUE;
            }
            if ((isDifferenceEqual(COMMA_VALUE, firstValue, SPACE_VALUE, secondValue) || (isDifferenceEqual(DOT_VALUE, firstValue, SPACE_VALUE, secondValue)))) {
                offset = COMMA_VALUE - (int) text.charAt(i);
            }

        }
        return offset;
    }

    public boolean hasTextSpecChars(String text) {
        for (int i = 0; i < SPEC_CHARS.length(); i++) {
            char currentChar = SPEC_CHARS.charAt(i);
            if (text.indexOf(currentChar) == -1) {
                return false;
            }
        }
        return true;
    }
}
