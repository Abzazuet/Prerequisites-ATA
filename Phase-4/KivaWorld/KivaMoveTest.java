import edu.duke.Point;

public class KivaMoveTest {
    String defaultLayout = ""
            + "-------------\n"
            + "        P   *\n"
            + "   **       *\n"
            + "   **       *\n"
            + "  K        D*\n"
            + "*  *  *  * **\n"
            + "-------------\n";
    FloorMap defaultMap = new FloorMap(defaultLayout);

    public void testForwardFromUp() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.DROP);

        verifyKivaState("testForwardFromUp",
                kiva,
                new Point(2, 3),
                FacingDirection.RIGHT,
                false,
                false);

    }

    public void verifyKivaState(
            String testName,
            Kiva actual,
            Point expectedLocation,
            FacingDirection expectedDirecion,
            boolean expectCarry,
            boolean expectedDropped) {
        Point actualLocation = actual.getCurrentLocation();
        if (sameLocation(actualLocation, expectedLocation)) {
            System.out.println(
                    String.format("%s: current location SUCCESS", testName));
        } else {
            System.out.println(
                    String.format("%s: current location FAIL", testName));
            System.out.println(
                    String.format("Expected %s, got %s", expectedLocation, actualLocation));
        }

        FacingDirection actuaDirection = actual.getDirectionFacing();
        if (actuaDirection == expectedDirecion) {
            System.out.println(
                    String.format("%s: facing direction SUCCESS", testName));
        } else {
            System.out.println(
                    String.format("%s: facing direction FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s", expectedDirecion, actuaDirection));
        }

        boolean actualCarry = actual.isCarryingPod();
        if (actualCarry == expectCarry) {
            System.out.println(
                    String.format("%s: carrying pod SUCCESS", testName));
        } 
        else {
            System.out.println(
                    String.format("%s: carrying pod FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s", expectCarry, actualCarry));
        }

        boolean actualDrop = actual.isSuccessfullyDropped();
        if (actualDrop == expectedDropped) {
            System.out.println(
                    String.format("%s: dropped SUCCESS", testName));
        } 
        else {
            System.out.println(
                    String.format("%s: dropped FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s", expectedDropped, actualDrop));
        }

    }

    private boolean sameLocation(Point a, Point b) {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }

    public static void main(String[] args) {
        KivaMoveTest kiva = new KivaMoveTest();
        kiva.testForwardFromUp();
    }
}
