import edu.duke.FileResource;

public class TestCeaserCipherTwo {
    

    private String halfOfString(String message, int start) {
        StringBuilder halfString = new StringBuilder(message.length());
        for (int i = start; i < message.length(); i = i + 2) {
            halfString.append(message.charAt(i));
        }
        return halfString.toString();
    }

    private int[] countLetters(String s) {
        int[] letters = new int[27];
        for (int i = 1; i < s.length(); i++) {
            if (Character.getNumericValue(s.charAt(i)) - 9 >= 0) {
                letters[Character.getNumericValue(s.charAt(i)) - 10]++;
            }
        }
        return letters;
    }

    private int indexOfMax(int[] values) {
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

    public int getKey(String s) {
        int[] letterFrequencies = countLetters(s);
        int key = indexOfMax(letterFrequencies);
        System.out.println(s+":"+key);
        return key;
    }

    public String decryptTwoKeys (String input){

        String firstHalf = halfOfString(input, 0);
        String secondHalf = halfOfString(input, 1);
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);

        CeaserCipherTwo decrypter = new CeaserCipherTwo(key1, key2);
        String decrypt = decrypter.decrypt(input);
        System.out.println(decrypt);
        return decrypt;
    }
    public void tests(){
        String file = new FileResource().asString();
        CeaserCipherTwo cesar = new CeaserCipherTwo(17, 3);
        String encrypt = cesar.encrypt(file);
        String decrypt = cesar.decrypt(encrypt);
        System.out.println(encrypt);
        System.out.println(decrypt);
    }
}
