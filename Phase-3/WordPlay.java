public class WordPlay {
    public boolean isVowel(char ch){
        boolean vowel = false;
        String vowels = "aeiouAEIOU";
        if (vowels.indexOf(ch)!=-1){
            vowel = true;
        }

        return vowel;
    }
    public String replaceVowels(String phrase, char ch){
        StringBuilder phrase2 = new StringBuilder(phrase);
        for ( int i=0; i<phrase.length(); i++){
            if (isVowel(phrase.charAt(i))){
                phrase2.setCharAt(i, ch);
            }
        }
        return phrase2.toString();
    }
    
    public void testVowel(){
        System.out.println(replaceVowels("Hello everyone", '!'));
    }

    public static void main(String[] args) {
        WordPlay word = new WordPlay();
        word.testVowel();
    }
}
