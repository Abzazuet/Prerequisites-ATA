import java.io.File;

import edu.duke.*;

class WordLenghts {
    public int[] countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            if (!Character.isLetter(word.charAt(0)) || !Character.isLetter(word.charAt(word.length() - 1))) {
                counts[word.length() - 1]++;

            } else if (!Character.isLetter(word.charAt(0)) && !Character.isLetter(word.charAt(word.length() - 1))) {
                counts[word.length() - 2]++;
            } else {
                if (word.length() > 30) {
                    counts[31]++;
                } else {
                    counts[word.length()]++;
                }
            }
        }
        for (int i = 1; i < counts.length; i++) {
            System.out.println("Length: " + i + " Words: " + counts[i]);
        }
        return counts;

    }

    public void testCountWords() {
        FileResource file = new FileResource();
        int[] counts = new int[31];
        int max = indexOfMax(countWordLengths(file, counts));
        System.out.println(max);

    }

    public int indexOfMax(int[] values) {
        int lengthOfMostCommonWord = 0;
        int mostCommongLength = 0;
        for (int i = 0; i < values.length; i++) {
            if (mostCommongLength < values[i]) {
                mostCommongLength = values[i];
                lengthOfMostCommonWord = i;
            }
        }

        return lengthOfMostCommonWord;
    }

}

class CeaserBreaker {
    public String halfOfString(String message, int start) {
        StringBuilder halfString = new StringBuilder(message.length());
        System.out.println(message.length());
        for (int i = start; i < message.length(); i = i + 2) {
            halfString.append(message.charAt(i));
        }
        return halfString.toString();
    }

    public int getKey(String s) {
        int[] letterFrequencies = countLetters(s);
        WordLenghts lengths = new WordLenghts();
        int key = lengths.indexOfMax(letterFrequencies);
        System.out.println(key);
        return key;
    }

    public int[] countLetters(String s) {
        int[] letters = new int[27];
        for (int i = 0; i < s.length(); i++) {
            if (Character.getNumericValue(s.charAt(i)) - 9 >= 0) {
                letters[Character.getNumericValue(s.charAt(i)) - 10]++;
            }
        }
        for (int i = 0; i < letters.length - 1; i++) {
            System.out.println("Letter index: " + i + " Amount:" + letters[i]);
        }
        return letters;
    }

    public String decryptTwoKeys(String message) {
        StringBuilder decrypt = new StringBuilder(message.length());

        return decrypt.toString();
    }
}

public class BreakingCeaserCipher {

    public static void main(String[] args) {
        WordLenghts test1 = new WordLenghts();
        // test1.testCountWords();
        CeaserCipher cc = new CeaserCipher();
        // cc.testCaesar();
        // FileResource file = new FileResource();
        CeaserBreaker test2 = new CeaserBreaker();
        test2.getKey("Z NFLCU CFMV KF XF FLK NZKY PFL");
    }
}
