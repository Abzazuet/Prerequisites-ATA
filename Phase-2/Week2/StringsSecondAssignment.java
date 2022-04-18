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
    String dna = "ATGAAATATTAA";
    System.out.println(findStopCodon(dna, 0, "TAA"));
    System.out.println(findStopCodon("ATGAAATATTAG", 0, "TAG"));
    System.out.println(findStopCodon("ATGAAAAAATATTGA", 0, "TGA"));
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
    String dna = "ATGAAATATTAA";
    System.out.println(findGene(dna, 0));
    dna = "ATGAACCCATATTAG";
    System.out.println(findGene(dna, 0));
    dna = "ATGAAATATTGA";
    System.out.println(findGene(dna, 0));
    dna = "ATGAAATTTGA";
    System.out.println(findGene(dna, 0));
  }

  public void printAllGenes(String dna) {
    int startIndex = 0;
    while (true) {
      String currentGene = findGene(dna, startIndex);
      if (currentGene.isEmpty()) {
        break;
      }
      System.out.println(currentGene);
      startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
  }

  public void testAllGenes() {
    System.out.println("Finding genes...");
    String dna = "ATGATCTAATTTATGCTGCAACGGTGAAAGA";
    printAllGenes(dna);
  }
}

class Part2 {

  public int howMany(String stringa, String stringb) {
    int startIndex = 0;
    int numberOfOcurrences = 0;
    while (true) {
      if (stringb.indexOf(stringa, startIndex) != -1) {
        startIndex = stringb.indexOf(stringa, startIndex) + stringa.length();
        numberOfOcurrences++;
      } else {
        break;
      }
    }
    return numberOfOcurrences;
  }

  public void testHowMany() {
    System.out.println(howMany("T", "TAAAAAAAAT"));
  }
}

class Part3 {

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
    String dna = "ATGAAATATTAA";
    System.out.println(findStopCodon(dna, 0, "TAA"));
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
    String dna = "ATGAAATATTAA";
    System.out.println(findGene(dna, 0));
  }

  public void printAllGenes(String dna) {
    int startIndex = 0;
    while (true) {
      String currentGene = findGene(dna, startIndex);
      if (currentGene.isEmpty()) {
        break;
      }
      System.out.println(currentGene);
      startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
  }

  public void testAllGenes() {
    System.out.println("Finding genes...");
    String dna = "AATGCTAACTAGCTGACTAAT";
    printAllGenes(dna);
  }

  public int countGenes(String dna) {
    int startIndex = 0;
    int count = 0;
    String previousGene = "";
    while (true) {
      String currentGene = findGene(dna, startIndex);
      if (currentGene.isEmpty()) {
        break;
      }
      if (currentGene != previousGene) {
        previousGene = currentGene;
        count++;
      }
      System.out.println(currentGene);
      startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
    return count;
  }

  public void testCountGenes() {
    System.out.println("Counting genes...");
    String dna = "AATGCTAACTAGCTGACTAAT";
    System.out.println(countGenes(dna));
  }

  public StorageResource getAllGenes(String dna) {
    StorageResource geneList = new StorageResource();
    int startIndex = 0;
    while (true) {
      String currentGene = findGene(dna, startIndex);
      if (currentGene.isEmpty()) {
        break;
      }
      geneList.add(currentGene);
      startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
    return geneList;
  }

  public void testGetGenes() {
    String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGAAATGCTAACTAGCTGACTAAT";
    System.out.println("Getting all genes on+ "+dna);
    
    StorageResource genes = getAllGenes(dna);
    for (String g : genes.data()) {
      System.out.println(g);
    }
  }
}

public class StringsSecondAssignment {

  public static void main(String[] args) {
    Part1 testing1 = new Part1();
    testing1.testAllGenes();
    Part2 testing2 = new Part2();
    testing2.testHowMany();
    Part3 testing3 = new Part3();
    testing3.testCountGenes();
    testing3.testGetGenes();
  }
}
