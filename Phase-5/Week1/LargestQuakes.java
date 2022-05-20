import java.util.*;

public class LargestQuakes {

  public void findLargestQuakes(ArrayList<QuakeEntry> data) {
    /*
        for (QuakeEntry qe : data){
            System.out.println(qe);
        }
        */
    System.out.println(
      String.format("Total amount of earthquakes: %s", data.size())
    );
  }

  public int indexOfLargest(ArrayList<QuakeEntry> data) {
    int indexMax = 0;
    double maxMagnitude = 0.0;
    for (QuakeEntry qe : data) {
      if (qe.getMagnitude() > maxMagnitude) {
        indexMax = data.indexOf(qe);
        maxMagnitude = qe.getMagnitude();
      }
    }
    return indexMax;
  }

  public ArrayList<QuakeEntry> getLargest(
    ArrayList<QuakeEntry> data,
    int howMany
  ) {
    ArrayList<QuakeEntry> largest = new ArrayList<QuakeEntry>();
    ArrayList<QuakeEntry> copy = data;
    for (int i = 0; i < howMany; i++) {
      int index = indexOfLargest(copy);
      largest.add(copy.get(index));
      copy.remove(index);
    }
    for (QuakeEntry qe : largest) {
      System.out.println(qe);
    }
    return largest;
  }

  public void findLargestQuakesImplementation() {
    String source = "data/nov20quakedata.atom";
    EarthQuakeParser parser = new EarthQuakeParser();
    ArrayList<QuakeEntry> data = parser.read(source);
    getLargest(data, 5);
  }
}
