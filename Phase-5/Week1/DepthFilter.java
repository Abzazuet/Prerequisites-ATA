public class DepthFilter implements Filter {

  private double minDepth;
  private double maxDepth;
  private String name;

  public DepthFilter(double minDepth, double maxDepth, String name) {
    this.minDepth = minDepth;
    this.maxDepth = maxDepth;
    this.name = name;
  }

  public boolean satisfies(QuakeEntry qe) {
    if (qe.getDepth() >= this.minDepth && qe.getDepth() <= this.maxDepth) {
      return true;
    }
    return false;
  }

  public String getName() {
    return this.name;
  }
}
