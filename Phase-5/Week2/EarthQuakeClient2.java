import java.util.*;

public class EarthQuakeClient2 {

  public EarthQuakeClient2() {
    // TODO Auto-generated constructor stub
  }

  public ArrayList<QuakeEntry> filter(
    ArrayList<QuakeEntry> quakeData,
    Filter f
  ) {
    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    for (QuakeEntry qe : quakeData) {
      if (f.satisfies(qe)) {
        answer.add(qe);
      }
    }

    return answer;
  }

  public void quakesWithFilter() {
    EarthQuakeParser parser = new EarthQuakeParser();
    //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    String source = "./data/nov20quakedata.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    System.out.println("read data for " + list.size() + " quakes");

    /*
        Filter fMagnitude = new MagnitudeFilter(4.0, 5.0); 
        ArrayList<QuakeEntry> f1  = filter(list, fMagnitude);
        Filter fDepth = new DepthFilter(-35000.0, -12000.0); 
        ArrayList<QuakeEntry> f2  = filter(f1, fDepth);
        */
    Filter fDistance = new DistanceFilter(
      new Location(35.42, 139.43),
      100000000,
      "Distance"
    );
    ArrayList<QuakeEntry> f1 = filter(list, fDistance);
    System.out.println(f1);
    Filter fPhrase = new PhraseFilter("end", "Japan", "Phrase");
    ArrayList<QuakeEntry> f2 = filter(f1, fPhrase);

    /*

        */
    for (QuakeEntry qe : f2) {
      System.out.println(qe);
    }
  }

  public void createCSV() {
    EarthQuakeParser parser = new EarthQuakeParser();
    //String source = "../data/nov20quakedata.atom";
    String source = "data/nov20quakedata.atom";
    //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    dumpCSV(list);
    System.out.println("# quakes read: " + list.size());
  }

  public void dumpCSV(ArrayList<QuakeEntry> list) {
    System.out.println("Latitude,Longitude,Magnitude,Info");
    for (QuakeEntry qe : list) {
      System.out.printf(
        "%4.2f,%4.2f,%4.2f,%s\n",
        qe.getLocation().getLatitude(),
        qe.getLocation().getLongitude(),
        qe.getMagnitude(),
        qe.getInfo()
      );
    }
  }

  public void testMatchAllFilter() {
    EarthQuakeParser parser = new EarthQuakeParser();
    //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    String source = "./data/nov20quakedata.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    System.out.println("read data for " + list.size() + " quakes");
    MatchAllFilter maf = new MatchAllFilter();
    DepthFilter fDepth = new DepthFilter(-100000.0, -10000.0, "Depth");
    MagnitudeFilter fMagnitude = new MagnitudeFilter(0.0, 2.0, "Magnitude");
    PhraseFilter fPhrase = new PhraseFilter("any", "a", "Phrase");
    maf.addFilter(fDepth);
    maf.addFilter(fMagnitude);
    maf.addFilter(fPhrase);
    String filterNames = maf.getName();
    ArrayList<QuakeEntry> f2 = filter(list, maf);
    for (QuakeEntry qe : f2) {
      System.out.println(qe);
    }
    System.out.println(String.format("Filters used are: %s", filterNames));
  }

  public void testMatchAllFilter2() {
    EarthQuakeParser parser = new EarthQuakeParser();
    //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    String source = "./data/nov20quakedata.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    System.out.println("read data for " + list.size() + " quakes");
    MatchAllFilter maf = new MatchAllFilter();
    DistanceFilter fDistance = new DistanceFilter(
      new Location(36.1314, -95.9372),
      10000000.0,
      "Distance"
    );
    MagnitudeFilter fMagnitude = new MagnitudeFilter(0.0, 3.0, "Magnitude");
    PhraseFilter fPhrase = new PhraseFilter("any", "Ca", "Phrase");
    maf.addFilter(fDistance);
    maf.addFilter(fMagnitude);
    maf.addFilter(fPhrase);
    ArrayList<QuakeEntry> f2 = filter(list, maf);
    for (QuakeEntry qe : f2) {
      System.out.println(qe);
    }
  }
  public void testSort(){
    EarthQuakeParser parser = new EarthQuakeParser();
    String source = "./nov20quakedata.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    QuakeSort test = new QuakeSort();
    test.sortByMagnitude(list);
    for (QuakeEntry q:list){
      System.out.println(q);
    }
  }
}
