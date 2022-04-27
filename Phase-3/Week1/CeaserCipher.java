import edu.duke.*;

public class CeaserCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int key;

    public CeaserCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        this.key=key;
    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }

        }
        return encrypted.toString();
    }

    public String decrypt(String input) {
        CeaserCipher ceaser = new CeaserCipher(26-key);
        String decrypted = ceaser.encrypt(input);
        return decrypted;
    }

    public void testCaesar() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message);
        System.out.println(encrypted);
        // TO decrypt just sustract key from 26
        String decrypted = decrypt(message);
        System.out.println(decrypted);

    }

    public static void main(String[] args) {
        TestCeaserCipherTwo tests = new TestCeaserCipherTwo();
        tests.tests();
        tests.decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
    }
}