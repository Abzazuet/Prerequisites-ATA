public class MagnitudeFilter implements Filter {

  private double minMag;
  private double maxMag;
  private String name;

  public MagnitudeFilter(double minMag, double maxMag, String name) {
    this.minMag = minMag;
    this.maxMag = maxMag;
    this.name = name;
  }

  public boolean satisfies(QuakeEntry qe) {
    if (qe.getMagnitude() >= this.minMag && qe.getMagnitude() <= this.maxMag) {
      return true;
    }
    return false;
  }

  public String getName() {
    return this.name;
  }
}
