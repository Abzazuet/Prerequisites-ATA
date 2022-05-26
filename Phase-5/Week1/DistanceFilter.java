public class DistanceFilter implements Filter {

  private Location location;
  private double maxDistance;

  public DistanceFilter(Location location, double maxDistance) {
    this.location = location;
    this.maxDistance = maxDistance;
  }

  public boolean satisfies(QuakeEntry qe) {
    if (
      qe.getLocation().distanceTo(this.location)<this.maxDistance
    ) {
      return true;
    }
    return false;
  }
}
