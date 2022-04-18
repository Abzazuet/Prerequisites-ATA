public class Debugging1 {

  public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
      if (index == -1) {
        break;
      }
      if (index + 4 > input.length()) {
        break;
      }
      String found = input.substring(index + 1, index + 4);
      System.out.println(found);

      index = input.indexOf("abc", index + 4);
    }
  }

  public void test() {
    String str = "abcdabc";
    findAbc(str);
  }

  public static void main(String args[]) {
    Debugging1 deb1 = new Debugging1();
    deb1.test();
  }
}
