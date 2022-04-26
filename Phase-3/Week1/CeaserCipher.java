import edu.duke.*;

public class CeaserCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for ( int i=0; i<encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if (idx !=-1){
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }

        }
        return encrypted.toString();
    }
    public void testCaesar(){
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, 26-key);
        System.out.println(encrypted);
        //TO decrypt just sustract key from 26
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);

    }

    public static void main(String[] args) {
       CeaserCipher ceaser = new CeaserCipher();
       ceaser.testCaesar(); 
    }
}