import edu.duke.*;

public class WordPlay {
    public boolean isVowel(char ch) {
        boolean vowel = false;
        String vowels = "aeiouAEIOU";
        if (vowels.indexOf(ch) != -1) {
            vowel = true;
        }

        return vowel;
    }

    public String replaceVowels(String phrase, char ch) {
        StringBuilder phrase2 = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            if (isVowel(phrase.charAt(i))) {
                phrase2.setCharAt(i, ch);
            }
        }
        return phrase2.toString();
    }

    public void testVowel() {
        System.out.println(replaceVowels("Hello everyone", '!'));
    }

    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = alphabet.toLowerCase();
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        String lowerShiftedAlphabet = shiftedAlphabet.toLowerCase();
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            int idxL = lowerAlphabet.indexOf(currChar);
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            } else if (idxL != -1) {
                char newChar = lowerShiftedAlphabet.charAt(idxL);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    public void testCaesar() {
        int key = 15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(
                "Can you imagine life WITHOUT the internet AND computers in your pocket?", key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26 - key);
        System.out.println(decrypted);

    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = alphabet.toLowerCase();
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String lowerShiftedAlphabet1 = shiftedAlphabet1.toLowerCase();
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        String lowerShiftedAlphabet2 = shiftedAlphabet2.toLowerCase();
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if (i % 2 == 0) {
                int idx = alphabet.indexOf(currChar);
                int idxL = lowerAlphabet.indexOf(currChar);
                if (idx != -1) {
                    char newChar = shiftedAlphabet1.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                } else if (idxL != -1) {
                    char newChar = lowerShiftedAlphabet1.charAt(idxL);
                    encrypted.setCharAt(i, newChar);
                }
            } else {
                int idx = alphabet.indexOf(currChar);
                int idxL = lowerAlphabet.indexOf(currChar);
                if (idx != -1) {
                    char newChar = shiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                } else if (idxL != -1) {
                    char newChar = lowerShiftedAlphabet2.charAt(idxL);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }

    public void testCaesarTwo() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encryptTwoKeys(
                "Can you imagine life WITHOUT the internet AND computers in your pocket?", 21, 2);
        System.out.println(encrypted);

    }

    public static void main(String[] args) {
        WordPlay word = new WordPlay();
        word.testCaesarTwo();
    }
}
