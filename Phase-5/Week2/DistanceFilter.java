public class DistanceFilter implements Filter {

  private Location location;
  private double maxDistance;
  private String name;

  public DistanceFilter(Location location, double maxDistance, String name) {
    this.location = location;
    this.maxDistance = maxDistance;
    this.name = name;
  }

  public boolean satisfies(QuakeEntry qe) {
    if (qe.getLocation().distanceTo(this.location) < this.maxDistance) {
      return true;
    }
    return false;
  }

  public String getName() {
    return this.name;
  }
}
