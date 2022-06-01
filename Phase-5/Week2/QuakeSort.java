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
    for (int i = 0; i < in.size(); i++) {
      int minIndex = getSmallestMagnitude(in, i); //position of smallest from i to the end of the array
      QuakeEntry qi = in.get(i);// quakeEntry in the current positon
      QuakeEntry qMin = in.get(minIndex); // quakeENtry of the smallest magnitude
      in.set(i, qMin);// put smallest entry in current position
      in.set(minIndex, qi);//swap the quake entry of the current position with the index of the smallest
    }
  }
}
