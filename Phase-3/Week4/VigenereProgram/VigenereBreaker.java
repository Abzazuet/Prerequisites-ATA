import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        // REPLACE WITH YOUR CODE
        int totalLength = message.length();
        StringBuilder slicedString = new StringBuilder();
        for (int i = whichSlice; i < totalLength; i = i + totalSlices) {
            slicedString.append(message.charAt(i));
        }
        return slicedString.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        // WRITE YOUR CODE HERE
        CaesarCracker decrypter = new CaesarCracker();
        String[] slices = new String[klength];
        for (int i = 0; i < klength; i++) {
            slices[i] = sliceString(encrypted, i, klength);
            key[i] = decrypter.getKey(slices[i]);
        }
        /*
         * for (int i : key){
         * System.out.println(i);
         * }
         */
        return key;
    }

    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> words = new HashSet<String>();
        for (String line : fr.lines()) {
            words.add(line.toLowerCase());
        }
        return words;
    }

    public int countDictionary(String message, HashSet<String> dictionary) {
        int wordsFound = 0;
        message = message.toLowerCase();
        String[] wordsInMessage = message.split("\\W+");
        for (String word : wordsInMessage) {
            if (dictionary.contains(word)) {
                wordsFound++;
            }
        }
        return wordsFound;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        String message = "";
        int max = 0;
        int[] keys = new int[10];
        int wordsInDictionary = 0;
        for (int i = 1; i < 101; i++) {
            int[] tryKeys = tryKeyLength(encrypted, i, 'e');
            VigenereCipher cracker = new VigenereCipher(tryKeys);
            String messageDecrypted = cracker.decrypt(encrypted);
            wordsInDictionary = countDictionary(messageDecrypted, dictionary);
            if (wordsInDictionary > max) {
                max = wordsInDictionary;
                message = messageDecrypted;
                keys=tryKeys;
            }
        }
        System.out.println(keys.length);
        System.out.println(max);
        return message;
    }

    public void breakVigenere() {
        // WRITE YOUR CODE HERE
        FileResource file = new FileResource();
        HashSet<String> dictionary = readDictionary(new FileResource("./dictionaries/English"));
        String message = file.asString();
        String messageDecrypted = breakForLanguage(message, dictionary);
        //System.out.print(messageDecrypted);
        String lines[] = messageDecrypted.split("\\r?\\n");
        System.out.println(lines[0]);
    }

    public static void main(String[] args) {
        VigenereBreaker test = new VigenereBreaker();
        test.breakVigenere();
    }
}
