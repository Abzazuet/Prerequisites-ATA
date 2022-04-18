import edu.duke.FileResource;
import edu.duke.StorageResource;

class Part1 {

  public int findStopCodon(String dna, int startIndex, String stopCodon) {
    int currIndex = dna.indexOf(stopCodon, startIndex + 3);
    while (currIndex != -1) {
      int diff = currIndex - startIndex;
      if (diff % 3 == 0) {
        return currIndex;
      } else {
        currIndex = dna.indexOf(stopCodon, currIndex + 1);
      }
    }
    return -1;
  }

  public void testFindStopCodon() {
    FileResource fr = new FileResource("brca1line.fa");
    String dna = fr.asString().toUpperCase();
    System.out.println(findStopCodon(dna, 0, "TAG"));
  }

  public String findGene(String dna, int where) {
    int startIndex = dna.indexOf("ATG", where);
    if (startIndex == -1) {
      return "";
    }
    int taaIndex = findStopCodon(dna, startIndex, "TAA");
    int tagIndex = findStopCodon(dna, startIndex, "TAG");
    int tgaIndex = findStopCodon(dna, startIndex, "TGA");
    int minIndex = 0;
    if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
      minIndex = tgaIndex;
    } else {
      minIndex = taaIndex;
    }
    if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
      minIndex = tagIndex;
    }
    if (minIndex == -1) {
      return "failed";
    }
    return dna.substring(startIndex, minIndex + 3);
  }

  public void testFindGene() {
    FileResource fr = new FileResource("brca1line.fa");
    String dna = fr.asString().toUpperCase();
    System.out.println(findGene(dna, 0));
  }

  public StorageResource getAllGenes(String dna) {
    StorageResource geneList = new StorageResource();
    int startIndex = 0;
    while (true) {
      String currentGene = findGene(dna, startIndex);
      if (currentGene.isEmpty()) {
        break;
      }
      System.out.println(currentGene);
      geneList.add(currentGene);
      startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
    return geneList;
  }

  public void testGetGenes() {
    FileResource fr = new FileResource("brca1line.fa");
    String dna = fr.asString().toUpperCase();
    System.out.println("Getting all genes on " + dna);
    StorageResource genes = getAllGenes(dna);
    for (String g : genes.data()) {
      System.out.println(g);
    }
  }
}

class Part2 {

  public float cgRatio(String dna) {
    int cg = 0;
    int startIndex = 0;
    while (startIndex < dna.length()) {
      if (dna.indexOf("C", startIndex) != -1) {
        startIndex = dna.indexOf("C", startIndex);
        cg++;
        startIndex++;
      }
      if (dna.indexOf("G", startIndex) != -1) {
        startIndex = dna.indexOf("G", startIndex);
        cg++;
        startIndex++;
      }
    }
    return (float) ((float) cg / (float) (dna.length()));
  }

  public void cgTest() {
    String dna = "CGCGCAAAAAAAAAGCGCG";
    System.out.println(cgRatio(dna));
  }

  public int countCTG(String dna) {
    int count = 0;
    int startIndex = 0;
    while (startIndex < dna.length()) {
      if (dna.indexOf("CTG", startIndex) != -1) {
        count++;
        startIndex = dna.indexOf("CTG", startIndex) + 3;
      }
    }
    return count;
  }

  public void testCTG() {
    String dna = "CTGAAAAAAACTGAAAACTGCTGCTG";
    System.out.println(countCTG(dna));
  }
}

class Part3 {

  public void processGenes(StorageResource sr) {
    StorageResource longerThanNineArray = new StorageResource();
    StorageResource cgRatioArray = new StorageResource();
    String longestGene = "";
    Part2 cgRatio = new Part2();
    for (String d : sr.data()) {
      if (d.length() > 9) {
        longerThanNineArray.add(d);
      }
      if (cgRatio.cgRatio(d) > 0.35) {
        cgRatioArray.add(d);
      }
      if (d.length() > longestGene.length()) {
        longestGene = d;
      }
    }
    System.out.println(
      "DNA longer than 9(" + longerThanNineArray.size() + "): "
    );
    for (String d : longerThanNineArray.data()) {
      System.out.println(d);
    }
    System.out.println(
      "CG ratio bigger than 0.35(" + cgRatioArray.size() + "): "
    );
    for (String d : cgRatioArray.data()) {
      System.out.println(d);
    }
    System.out.println("Longest gene: " + longestGene);
  }

  public void testProcessGenes() {
    StorageResource sr = new StorageResource();
    FileResource fr = new FileResource("mansmall.fa");
    String dna = fr.asString().toUpperCase();
    System.out.println(dna);
    sr.add("ATGAAAAAAATATATAGCGC");
    sr.add("AAAAAAAAAATGGCGCGCGC");
    sr.add("ATG");
    sr.add("AAAAAAAAAATGGCGCGCGCAAAAAAAAAATGGCGCGCGC");
    sr.add("AAAAAAAAACGCGCGATGGCGCGCGC");
    sr.add("ATG");
    sr.add("ATG");
    processGenes(sr);
  }
}

public class StringsThirdAssignment {

  public static void main(String[] args) {
      /*
    Part1 testing1 = new Part1();
    
    testing1.testFindGene();
    Part2 testing2 = new Part2();
    testing2.cgTest();
    testing2.testCTG();
    */
    Part3 testing3 = new Part3();
    testing3.testProcessGenes();
  }
}
