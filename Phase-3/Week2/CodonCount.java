import java.util.HashMap;

//import edu.duke.FileResource;

public class CodonCount {

    private HashMap<String, Integer> codons;

    public CodonCount() {
        codons = new HashMap<String, Integer>();
    }

    public void buildCodonMap(int start, String dna) {
        String codon = "";
        for (int i = start; i < dna.length() - 3; i++) {
            codon = dna.substring(i, i + 3);
            if (!codons.containsKey(codon)) {
                codons.put(codon, 1);
            } else {
                codons.put(codon, codons.get(codon) + 1);
            }
        }
    }

    public String mostCommonCodon() {
        String maxCodon = "";
        for (String codon : codons.keySet()) {
            if (maxCodon.equals("")) {
                maxCodon = codon;
            }
            if (codons.get(codon) > codons.get(maxCodon)) {
                maxCodon = codon;
            }
        }
        return maxCodon;
    }

    public void printCodonCounts(int start, int end) {
        for (String codon : codons.keySet()) {
            int occurence = codons.get(codon);
            if (occurence >= start && occurence <= end) {
                System.out.println(codon + " " + occurence);
            }
        }

    }

    public void test() {
        codons.clear();
        int startNucleid = 1;
        int start = 5;
        int end = 8;
        // FileResource file = new FileResource();
        // String dna = file.asString().toUpperCase();
        String dna = "ATTAATACTTTGTTTAACAGTAATTATTCAACTATTAAATATTTAAATAATTAAGTTATTAAACTATTAAGTACAGGGCCTGTATCTCTGATGCTGAACTATGATGTGTGACTTAAGCCCCCAAATACATCATGTTATTTGGATCCAAGGTGCTGCACAGAACGCTGACCCTCTCTAAGAGCTGGGTATTACT";
        buildCodonMap(startNucleid, dna);
        String max = mostCommonCodon();
        System.out.println("Reading frame starting with " + startNucleid + " results in " + codons.size());
        System.out.println("and most common codon is  " + max + " with count " + codons.get(max));
        System.out.println("Counts of codons between " + start + " and " + end + " inclusive are: ");
        printCodonCounts(start, end);
    }

    public static void main(String[] args) {
        CodonCount counting = new CodonCount();
        counting.test();
    }

}
