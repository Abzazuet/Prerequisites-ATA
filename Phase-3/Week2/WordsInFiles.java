import java.io.File;
import java.util.*;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> map;

    public WordsInFiles() {
        map = new HashMap<String, ArrayList<String>>();
    }

    // KEYS-> words
    // values -> fileName
    private void addWordsFromFile(File f) {
        FileResource file = new FileResource(f.toString());
        String fileName = f.getName();
        ArrayList<String> fileNames = new ArrayList<String>();
        for (String s : file.words()) {
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
                fileNames = map.get(s);
                fileNames.add(fileName);
                map.put(s, fileNames);
            } else {                
                fileNames = map.get(s);
                if (!fileNames.contains(fileName)) {
                    fileNames.add(fileName);
                    map.put(s, fileNames);
                }
            }
        }
    }

    public void buildWordFileMap() {
        map.clear();
        DirectoryResource files = new DirectoryResource();
        for (File f : files.selectedFiles()) {
            addWordsFromFile(f);
        }
    }

    public void max() {
        int maxOcurrence = 0;
        for (String s : map.keySet()) {
            if (maxOcurrence < map.get(s).size()) {
                maxOcurrence = map.get(s).size();
            }
        }
        System.out.println("Max occurence: " + maxOcurrence);
    }

    public void wordsInNumFiles(int number) {
        ArrayList<String> wordsWithOccurence = new ArrayList<String>();
        for (String s : map.keySet()) {
            if (map.get(s).size() == number) {
                wordsWithOccurence.add(s);
            }
        }
        System.out.println("Words that appear in "+wordsWithOccurence.size()+" " + number + " files: ");
        for (String s : wordsWithOccurence) {
            System.out.println(s);
        }

    }

    public void printFilesIn(String word) {
        ArrayList<String> files = map.get(word);
        System.out.println("Files with the word "+word+":");
        for (String file : files) {
            System.out.println(file);
        }
    }

    public void printAll() {
        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }

    public void tester() {
        buildWordFileMap();
        max();
         wordsInNumFiles(5);
         printFilesIn("red");
         //printAll();
    }

    public static void main(String[] args) {
        WordsInFiles words = new WordsInFiles();
        words.tester();
    }
}
