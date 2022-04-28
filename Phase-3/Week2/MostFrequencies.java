import java.util.ArrayList;

import edu.duke.FileResource;

public class MostFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public MostFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource file = new FileResource();
        for (String s : file.words()) {
            s=s.toLowerCase();
            int wordIndex = myWords.indexOf(s);
            if (wordIndex == -1) {
                myWords.add(s);
                wordIndex = myWords.indexOf(s);
                myFreqs.add(1);
            } else {
                int freq = myFreqs.get(wordIndex) + 1;
                myFreqs.set(wordIndex, freq);
            }
        }

    }

    public int findIndexOfMax() {
        int maxFreq = 0;
        int maxIdx=0;
        for (int i : myFreqs) {
            if (maxFreq<i){
                maxIdx = myFreqs.indexOf(i);
                maxFreq=i;
            }
        }
        return maxIdx;
    }
    
    public void tester() {
        findUnique();
        System.out.println("Number of unique words: "+myWords.size());
        for (String s : myWords) {
            int wordIndex = myWords.indexOf(s);
            System.out.println(myFreqs.get(wordIndex)+" "+s);
        }
        int max = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "+myWords.get(max)+" "+myFreqs.get(max));
        System.out.println(myWords.size());
    }

    public static void main(String[] args) {
        MostFrequencies test = new MostFrequencies();
        test.tester();
        CharactersInPlay characters = new CharactersInPlay();
        characters.tester();
    }
}