import java.util.*;
import edu.duke.*;
import java.util.HashMap;

public class VigenereBreaker {
    public HashMap<String, HashSet<String>> readAllDictionaries() {
        HashSet<String> dictionaries = new HashSet<String>();
        HashMap<String, HashSet<String>> languagesAndWords = new HashMap<String, HashSet<String>>();
        dictionaries.add("Danish");
        dictionaries.add("Dutch");
        dictionaries.add("English");
        dictionaries.add("French");
        dictionaries.add("German");
        dictionaries.add("Italian");
        dictionaries.add("Portuguese");
        dictionaries.add("Spanish");
        for (String language : dictionaries) {
            FileResource dictionaryFile = new FileResource("./dictionaries/" + language);
            HashSet<String> words = readDictionary(dictionaryFile);
            languagesAndWords.put(language, words);
        }
        return languagesAndWords;
    }

    public VigenereBreaker() {

    }

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
        char mostCommon = mostCommonCharIn(dictionary);
        for (int i = 1; i < 101; i++) {
            int[] tryKeys = tryKeyLength(encrypted, i, mostCommon);
            VigenereCipher cracker = new VigenereCipher(tryKeys);
            String messageDecrypted = cracker.decrypt(encrypted);
            wordsInDictionary = countDictionary(messageDecrypted, dictionary);
            if (wordsInDictionary > max) {
                max = wordsInDictionary;
                message = messageDecrypted;
                keys = tryKeys;
            }
        }
        return message;
    }

    public char mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<Character, Integer> letterFrequency = new HashMap<Character, Integer>();
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (!letterFrequency.containsKey(letter)) {
                    letterFrequency.put(letter, 1);
                } else {
                    letterFrequency.put(letter, letterFrequency.get(letter) + 1);
                }
            }
        }
        int highestRepetition = 0;
        char mostRepeatedLetter = ' ';
        for (char letter : letterFrequency.keySet()) {
            if (letterFrequency.get(letter) > highestRepetition) {
                highestRepetition = letterFrequency.get(letter);
                mostRepeatedLetter = letter;
            }
        }
        return mostRepeatedLetter;
    }

    public String breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages) {
        int mostWords = 0;
        String message = " ";
        String languageA = " ";
        for (String language : languages.keySet()) {
            HashSet<String> dictionary = languages.get(language);
            String decryptedForLanguage = breakForLanguage(encrypted, dictionary);
            int wordsInDictionary = countDictionary(decryptedForLanguage, dictionary);
            if (wordsInDictionary > mostWords) {
                mostWords = wordsInDictionary;
                message = decryptedForLanguage;
                languageA = language;
            }
        }
        System.out.println(languageA);

        return message;
    }

    public void breakVigenere() {
        // WRITE YOUR CODE HERE
        FileResource file = new FileResource();
        String message = file.asString();
        readAllDictionaries();
        String decrypt = breakForAllLangs(message, readAllDictionaries());
        System.out.println(decrypt);
    }

    public static void main(String[] args) {
        VigenereBreaker test = new VigenereBreaker();
        test.breakVigenere();
    }
}
