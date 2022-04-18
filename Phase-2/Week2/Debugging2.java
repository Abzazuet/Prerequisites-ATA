public class Debugging2 {

  public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
      if (index == -1) {
        break;
      }
      if (index + 4 > input.length() || index >= input.length() - 3) {
        break;
      }
      System.out.println(index);
      String found = input.substring(index + 1, index + 4);
      System.out.println(found);
      index = input.indexOf("abc", index + 3);
      System.out.println("index after updating " + index);
    }
  }

  public void test() {
    String str = "abcabcabcabca";
    findAbc(str);
  }

  public static void main(String args[]) {
    Debugging2 deb1 = new Debugging2();
    deb1.test();
  }
}
