import java.util.ArrayList;

import edu.duke.FileResource;

public class CharactersInPlay {
    private ArrayList<String> character;
    private ArrayList<Integer> characterLines;

    public CharactersInPlay() {
        character = new ArrayList<String>();
        characterLines = new ArrayList<Integer>();
    }

    public void update(String person) {
        int idxPerson = character.indexOf(person);
        if (idxPerson == -1) {
            character.add(person);
            idxPerson = character.indexOf(person);
            characterLines.add(1);
        } else {
            int freq = characterLines.get(idxPerson) + 1;
            characterLines.set(idxPerson, freq);
        }
    }

    public void findAllCharacters() {
        character.clear();
        characterLines.clear();
        FileResource file = new FileResource();
        for (String line : file.lines()) {
            if (line.contains(".")) {
                String character = line.substring(0, line.indexOf("."));
                update(character);
            }
        }
    }

    public int findIndexOfMax() {
        int maxFreq = 0;
        int maxIdx = 0;
        for (int i : characterLines) {
            if (maxFreq < i) {
                maxIdx = characterLines.indexOf(i);
                maxFreq = i;
            }
        }
        return maxIdx;
    }

    public void charactersWithNumParts(int num1, int num2) {
        for (String s : character) {
            int idx = character.indexOf(s);
            if (characterLines.get(idx) >= num1 && characterLines.get(idx) <= num2) {
                System.out.println("Character: " + s + " Lines:" + characterLines.get(idx));
            }
        }
    }

    public void tester() {
        findAllCharacters();
        int max = findIndexOfMax();
        for (String s : character) {
            if (characterLines.get(character.indexOf(s)) > 1) {
                System.out.println(s + " " + characterLines.get(character.indexOf(s)));
            }
        }
        System.out.println("The character that speaks the most often and its lines are: " + character.get(max) + " "
                + characterLines.get(max));
        charactersWithNumParts(20, 25);

    }
}
