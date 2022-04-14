import edu.duke.*;

class Part1 {
    public String findGene(String dna) {
        String result = " ";

        // look for start codon ATG
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) // No start codon
            return result;
        // look for stop codon TAA
        int stopIndex = dna.indexOf("TAA");
        if (stopIndex == -1) // No end codon
            return result;
        result = dna.substring(startIndex, stopIndex + 3);
        if (((stopIndex + 3) - startIndex) % 3 == 0) {
            return result;
        } else {
            return "Gene not complete";
        }
    }

    public void testGeneSimple() {
        String dna = "ATGATATATTAAATATATACGCGCGGCGC";
        String gene = findGene(dna);
        System.out.println("DNA STRAND: " + dna);
        System.out.println("Gene: " + gene);
    }
}

class Part2 {
    public String findGene(String dna, String startCodon, String endCodon) {
        String result = " ";
        String start = startCodon;
        String end = endCodon;

        // look for start codon ATG
        int startIndex = dna.indexOf(start);
        if (startIndex == -1) // No start codon
            return result;
        // look for stop codon TAA
        int stopIndex = dna.indexOf(end);
        if (stopIndex == -1) // No end codon
            return result;
        result = dna.substring(startIndex, stopIndex + 3);
        if (((stopIndex + 3) - startIndex) % 3 == 0) {
            return result;
        } else {
            return "Gene not complete";
        }
    }

    public void testGeneSimple() {
        String dna = "AAAAAAAAAAAAAATCATATATAGGGGGGGGGGGG";
        String gene = findGene(dna, "ATC", "AGG");
        System.out.println("DNA STRAND: " + dna);
        System.out.println("Gene: " + gene);
    }
}

class Part3 {
    boolean twoOcurrences(String stringa, String stringb) {
        boolean returnValue = false;
        if (stringb.indexOf(stringa) != -1) {
            int firstOcurrence = stringb.indexOf(stringa);
            String remainingText = stringb.substring(firstOcurrence + stringa.length(), stringb.length());
            if (remainingText.indexOf(stringa) != -1) {
                returnValue = true;
            }
        }
        System.out.println(returnValue);
        return returnValue;
    }

    String lastPart(String stringa, String stringb) {
        String returnString = "";
        if (stringb.indexOf(stringa) != -1) {
            String remainingText = stringb.substring(stringb.indexOf(stringa) + stringa.length(), stringb.length());
            returnString = remainingText;
        } else {
            returnString = stringb;
        }
        System.out.println(returnString);

        return returnString;
    }

    void testing() {
        twoOcurrences("a", "zzueta");
        twoOcurrences("alo", "aloolaalo");
        twoOcurrences("burro", "burro es muy burro");
        lastPart("an", "banana");
        lastPart("no", "yes");
        lastPart("abel", "abel alexis");
    }
}

class Part4 {
    void findWord(URLResource link) {
        String word1 = "youtube.com";
        String word2 = "YouTube.com";
        for (String line : link.lines()) {
            int wordPosition = line.indexOf(word1);

            if (wordPosition != -1) {
                int startPosition = line.indexOf("\"");
                int endPosition = line.lastIndexOf("\"", line.length());
                String url = line.substring(startPosition + 1, endPosition);
                if (!url.startsWith("http")) {
                    startPosition = url.indexOf("http");
                    endPosition = url.lastIndexOf("\">", url.length());
                    url = url.substring(startPosition, endPosition);
                }
                System.out.println(url);

            }

            else {
                wordPosition = line.indexOf(word2);
                if (wordPosition != -1) {
                    int startPosition = line.indexOf("\"");
                    int endPosition = line.lastIndexOf("\"", line.length());
                    String url = line.substring(startPosition + 1, endPosition);
                    if (!url.startsWith("http")) {
                        startPosition = url.indexOf("http");
                        endPosition = url.lastIndexOf("\">", url.length());
                        url = url.substring(startPosition, endPosition);
                    }
                    System.out.println(url);

                }

            }
        }
    }

    void test() {
        URLResource link = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        findWord(link);
    }
}

public class StringsFirstAssignment {
    public static void main(String[] args) {

        Part1 findSimpleGene = new Part1();
        findSimpleGene.testGeneSimple();
        Part2 findComplexGene = new Part2();
        findComplexGene.testGeneSimple();
        Part3 occurences = new Part3();
        occurences.testing();

        Part4 lines = new Part4();
        lines.test();
    }
}
