import java.util.*;

public class EarthQuakeClient {
  //Setters
  public ArrayList<QuakeEntry> filterByMagnitude(
    ArrayList<QuakeEntry> quakeData,
    double magMin
  ) {
    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    //TODO
    for (QuakeEntry qe : quakeData) {
      if (qe.getMagnitude() > magMin) {
        answer.add(qe);
      }
    }
    return answer;
  }

  public ArrayList<QuakeEntry> filterByDistanceFrom(
    ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from
  ) {
    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    // TODO
    for (QuakeEntry qe : quakeData) {
      if (qe.getLocation().distanceTo(from) < distMax) {
        answer.add(qe);
      }
    }
    return answer;
  }

  public ArrayList<QuakeEntry> filterByDepth(
    ArrayList<QuakeEntry> quakeData,
    double minDepth,
    double maxDepth
  ) {
    ArrayList<QuakeEntry> quakeWithDepth = new ArrayList<QuakeEntry>();
    for (QuakeEntry qe : quakeData) {
      if (qe.getDepth() > minDepth && qe.getDepth() < maxDepth) {
        quakeWithDepth.add(qe);
      }
    }
    System.out.println(
      String.format(
        "Find quakes with depth between %s and %s",
        minDepth,
        maxDepth
      )
    );
    for (QuakeEntry qe : quakeWithDepth) {
      System.out.println(qe);
    }
    System.out.println(
      String.format(
        "Found %s quakes that match that criteria",
        quakeWithDepth.size()
      )
    );

    return quakeWithDepth;
  }

  public ArrayList<QuakeEntry> filterByPhrase(
    ArrayList<QuakeEntry> quakeData,
    String lookAt,
    String phrase
  ) {
    ArrayList<QuakeEntry> phraseFiltered = new ArrayList<QuakeEntry>();
    for (QuakeEntry qe : quakeData) {
      String title = qe.getInfo();
      if (lookAt == "start" && title.startsWith(phrase)) {
        phraseFiltered.add(qe);
      } else if (lookAt == "end" && title.endsWith(phrase)) {
        phraseFiltered.add(qe);
      } else {
        if (title.contains(phrase)) {
          phraseFiltered.add(qe);
        }
      }
    }
    for (QuakeEntry qe : phraseFiltered){
      System.out.println(qe);
    }
    System.out.println(String.format("Found %s quakes that match %s at %s", phraseFiltered.size(), phrase, lookAt));
    return phraseFiltered;
  }

  //Helpers
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

  public void createCSV() {
    EarthQuakeParser parser = new EarthQuakeParser();
    String source = "data/nov20quakedata.atom";
    //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    dumpCSV(list);
    System.out.println("# quakes read: " + list.size());
  }

  //Getters
  public void bigQuakes() {
    EarthQuakeParser parser = new EarthQuakeParser();
    //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    String source = "data/nov20quakedata.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    System.out.println("read data for " + list.size() + " quakes");
    /*
        for (QuakeEntry qe : list) {
            if (qe.getMagnitude() > 5.0) {
                System.out.println(qe);
            }
        }
        */
    ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
    for (QuakeEntry qe : listBig) {
      System.out.println(qe);
    }
    System.out.println(
      String.format("Found %s quakes that match that criteria", listBig.size())
    );
  }

  public void closeToMe() {
    EarthQuakeParser parser = new EarthQuakeParser();
    String source = "data/nov20quakedata.atom";
    //String source =
    //  "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    System.out.println("# quakes read: " + list.size());

    //Durham, NC
    //Location city = new Location(35.988, -78.907);
    //Bridgeport, CA
    Location city = new Location(38.17, -118.82);
    ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000 * 1000, city);
    for (int k = 0; k < close.size(); k++) {
      QuakeEntry entry = close.get(k);
      double distanceInMeters = city.distanceTo(entry.getLocation());
      System.out.println(distanceInMeters / 1000 + " " + entry.getInfo());
    }
    System.out.println(
      String.format("Found %s quakes that match that criteria", close.size())
    );
  }

  public void quakesOfDepth() {
    EarthQuakeParser parser = new EarthQuakeParser();
    String source = "data/nov20quakedata.atom";
    //String source =
    //  "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    System.out.println("# quakes read: " + list.size());
    filterByDepth(list, -8000.0, -5000.0);
  }
  
  public void quakesByPhrase(){
    EarthQuakeParser parser = new EarthQuakeParser();
    String source = "data/nov20quakedata.atom";
    //String source =
    //  "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    System.out.println("# quakes read: " + list.size());
    filterByPhrase(list, "start", "Explosion");
  }
}
