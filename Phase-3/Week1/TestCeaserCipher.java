

public class TestCeaserCipher {
    public int[] countLetters(String s) {
        int[] letters = new int[27];
        for (int i = 1; i < s.length(); i++) {
            if (Character.getNumericValue(s.charAt(i)) - 9 >= 0) {
                letters[Character.getNumericValue(s.charAt(i)) - 10]++;
            }
        }
        return letters;
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

    public String breakCeaserCipher(String cipher){
        int key = getKey(cipher);
        CeaserCipher breakCipher = new CeaserCipher(key);
        String brokenCipher = breakCipher.decrypt(cipher);
        return brokenCipher;
    }
    
    private int getKey(String s) {
        int[] letterFrequencies = countLetters(s);
        int key = indexOfMax(letterFrequencies);
        System.out.println(s+":"+key);
        return key;
    }

    public void simpleTests(){
        //FileResource file = new FileResource();
        String fr = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CeaserCipher ceaser = new CeaserCipher(15);
        String encrypt = ceaser.encrypt(fr);
        String decrypt = breakCeaserCipher(encrypt);
        System.out.println(encrypt);
        System.out.println(decrypt);
        System.out.println(ceaser.decrypt(encrypt));
    }
}
