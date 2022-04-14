public class FindGeneSimpleAndTest {

    public String findGeneSimple(String dna) {
        String result = " ";

        // look for start codon ATG
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) // No start codon
            return result;
        // look for stop codon TAA
        int stopIndex = dna.indexOf("TAA");
        if (stopIndex == -1) //No end codon
            return result;
        result = dna.substring(startIndex, stopIndex + 3);

        return result;
    }

    public void testGeneSimple() {
        String dna = "ATGATATATTAA";
        String gene = findGeneSimple(dna);
        System.out.println("DNA STRAND: " + dna);
        System.out.println("Gene: " + gene);
    }

    public static void main(String[] args) {
        FindGeneSimpleAndTest test = new FindGeneSimpleAndTest();
        test.testGeneSimple();
    }
}