import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        int totalLength = message.length();
        StringBuilder slicedString = new StringBuilder();
        for (int i = whichSlice; i<totalLength;i=i+totalSlices){
            slicedString.append(message.charAt(i));
        }
        return slicedString.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker decrypter = new CaesarCracker();
        String [] slices = new String[klength];
        for (int i =0; i<klength; i++){
            slices[i] = sliceString(encrypted, i, klength);
            key[i] = decrypter.getKey(slices[i]);
        }
        /*
        for (int i : key){
            System.out.println(i);
        }
        */
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource file = new FileResource();
        String text = file.asString();
        int keys [] = tryKeyLength(text, 4, 'e');
        VigenereCipher cracker = new VigenereCipher(keys);
        String messageDecrypted = cracker.decrypt(text);
        System.out.println(messageDecrypted);
    }
     
    public static void main(String[] args) {
        VigenereBreaker test = new VigenereBreaker();
        test.breakVigenere();
    }
}
