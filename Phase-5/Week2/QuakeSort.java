import java.util.ArrayList;

public class QuakeSort {

  public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
    int minIdx = from;
    for (int i = from + 1; i < quakes.size(); i++) {
      if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
        minIdx = i;
      }
    }
    return minIdx;
  }

  public void sortByMagnitude(ArrayList<QuakeEntry> in) {
    //count from 0 to < in.size()
    for (int i = 0; i < in.size(); i++) {
      //find the index of the smallest quake
      int minIdx = getSmallestMagnitude(in, i);
      // swap the ith quake with the minIdxth quake
      QuakeEntry qi = in.get(i);
      QuakeEntry qMin = in.get(minIdx);
      in.set(i, qMin);
      in.set(minIdx, qi);
    }
  }

  public void testSort() {
    EarthQuakeParser parser = new EarthQuakeParser();
    String source = "./nov20quakedata.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    sortByMagnitude(list);
    for (QuakeEntry qe : list) {
      System.out.println(qe);
    }
  }

  public static void main(String[] args) {
    QuakeSort sort = new QuakeSort();
    sort.testSort();
  }
}
