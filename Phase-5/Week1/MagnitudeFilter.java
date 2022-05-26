public class MagnitudeFilter implements Filter {

  private double minMag;
  private double maxMag;

  public MagnitudeFilter(double minMag, double maxMag) {
    this.minMag = minMag;
    this.maxMag = maxMag;
  }

  public boolean satisfies(QuakeEntry qe) {
    if (qe.getMagnitude() >= this.minMag && qe.getMagnitude() <= this.maxMag) {
      return true;
    }
    return false;
  }
}
