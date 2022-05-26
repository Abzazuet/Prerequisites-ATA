public class PhraseFilter implements Filter {

  private String lookAt;
  private String phrase;

  public PhraseFilter(String lookAt, String phrase) {
    this.lookAt = lookAt;
    this.phrase = phrase;
  }

  public boolean satisfies(QuakeEntry qe) {
    String title = qe.getInfo();
    if (lookAt == "start" && title.startsWith(phrase)) {
      return true;
    } else if (lookAt == "end" && title.endsWith(phrase)) {
      return true;
    } else {
      if (title.contains(phrase)) {
        return true;
      }
    }
    return false;
  }
}
