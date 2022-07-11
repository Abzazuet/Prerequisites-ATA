import java.util.ArrayList;

public class QuakeSort {

  public QuakeEntry getSmallestMagnitude(ArrayList<QuakeEntry> quakes) {
    QuakeEntry min = quakes.get(0);
    for(QuakeEntry q: quakes){
      if(q.getMagnitude() < min.getMagnitude()){
        min = q;
      }
    }
    return min;
  }

  public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {
    //Start a new array
    ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
    //As long as in is not empty
    while(!in.isEmpty()){
      //Find smallest element in in (element)
      QuakeEntry minElement = getSmallestMagnitude(in);
      //Remove minElement from in
      in.remove(minElement);
      //Add element to out
      out.add(minElement);
    }
    //Return out 
    return out;
  }
  public void testSort(){
    EarthQuakeParser parser = new EarthQuakeParser();
    String source = "./nov20quakedata.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    list = sortByMagnitude(list);
    for (QuakeEntry qe : list){
      System.out.println(qe);
    }
  }
  public static void main(String[] args) {
    QuakeSort sort = new QuakeSort();
    sort.testSort();
  }
  
}
