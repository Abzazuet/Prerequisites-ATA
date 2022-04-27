public class CeaserCipherTwo {
    private String alphabet, shiftedAlphabet1, shiftedAlphabet2;
    private int key1, key2;

    public CeaserCipherTwo(int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);

        this.key1 = key1;
        this.key2 = key2;
    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx;
            if (i % 2 == 0) {
                idx = alphabet.indexOf(currChar);
                if (idx != -1) {
                    char newChar = shiftedAlphabet1.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            } else {
                idx = alphabet.indexOf(currChar);
                if (idx != -1) {
                    char newChar = shiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String input) {
        CeaserCipherTwo decrypted = new CeaserCipherTwo(26 - key1, 26 - key2);
        return decrypted.encrypt(input);
    }

    public static void main(String[] args) {
        TestCeaserCipherTwo tests = new TestCeaserCipherTwo();
        tests.tests();
        tests.decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
    }
}
