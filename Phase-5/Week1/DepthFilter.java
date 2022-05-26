public class DepthFilter implements Filter {

  private double minDepth;
  private double maxDepth;

  public DepthFilter(double minDepth, double maxDepth) {
    this.minDepth = minDepth;
    this.maxDepth = maxDepth;
  }

  public boolean satisfies(QuakeEntry qe) {
    if (qe.getDepth() >= this.minDepth && qe.getDepth() <= this.maxDepth) {
      return true;
    }
    return false;
  }
}
