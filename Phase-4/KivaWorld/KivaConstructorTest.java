import edu.duke.Point;

public class KivaConstructorTest {
    String defaultLayout = ""
            + "-------------\n"
            + "        P   *\n"
            + "   **       *\n"
            + "   **       *\n"
            + "  K        D*\n"
            + "*  *  *  * **\n"
            + "-------------\n";
    FloorMap defaultMap = new FloorMap(defaultLayout);

    public void testSingleArgumentConstructor() {
        Kiva kiva = new Kiva(defaultMap);
        Point initialLocation = kiva.getCurrentLocation();
        Point expectedLocation = new Point(2, 4);
        if (sameLocation(initialLocation, expectedLocation)) {
            System.out.println("testSingleArgumentConstructor SUCCESS");
        } else {
            System.out.println(String.format("testSingleArgumentConstructor FAIL> %s != (2,4)!", initialLocation));
        }
    }

    public void testTwoArgumentConstructor() {
        Point expectedLocation = new Point(2, 5);
        Kiva kiva = new Kiva(defaultMap, expectedLocation);
        Point initialLocation = kiva.getCurrentLocation();
        if (sameLocation(initialLocation, expectedLocation)) {
            System.out.println("testTwoArgumentConstructor SUCCESS");
        } else {
            System.out.println(String.format("testTwoArgumentConstructor FAIL> %s != (2,4)!", initialLocation));
        }
    }

    private boolean sameLocation(Point a, Point b) {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }

    public static void main(String[] args) {
        KivaConstructorTest test = new KivaConstructorTest();
        test.testTwoArgumentConstructor();
    }
}