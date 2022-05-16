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

        kiva.move(KivaCommand.FORWARD);

        verifyKivaState("testForwardFromUp",
                kiva,
                new Point(2, 3),
                FacingDirection.UP,
                false,
                false);
    }

    public void testTurnLeftFromUp() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);

        verifyKivaState("testTurnLeftFromUp",
                kiva,
                new Point(2, 4),
                FacingDirection.LEFT,
                false,
                false);
    }

    public void testTurnLeftFromLeft() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);

        verifyKivaState("testTurnLeftFromLeft",
                kiva,
                new Point(2, 4),
                FacingDirection.DOWN,
                false,
                false);
    }

    public void testTurnLeftFromDown() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);

        verifyKivaState("testTurnLeftFromDown",
                kiva,
                new Point(2, 4),
                FacingDirection.RIGHT,
                false,
                false);
    }

    public void testTurnLeftFromRight() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);

        verifyKivaState("testTurnLeftFromRight",
                kiva,
                new Point(2, 4),
                FacingDirection.UP,
                false,
                false);
    }

    public void testTurnRightFromUp() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_RIGHT);

        verifyKivaState("testTurnRightFromUp",
                kiva,
                new Point(2, 4),
                FacingDirection.RIGHT,
                false,
                false);
    }

    public void testTurnRightFromLeft() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);

        verifyKivaState("testTurnRightFromLeft",
                kiva,
                new Point(2, 4),
                FacingDirection.UP,
                false,
                false);
    }

    public void testTurnRightFromDown() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);

        verifyKivaState("testTurnRightFromDown",
                kiva,
                new Point(2, 4),
                FacingDirection.LEFT,
                false,
                false);
    }

    public void testTurnRightFromRight() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);

        verifyKivaState("testTurnRightFromRight",
                kiva,
                new Point(2, 4),
                FacingDirection.DOWN,
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
        } else {
            System.out.println(
                    String.format("%s: carrying pod FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s", expectCarry, actualCarry));
        }

        boolean actualDrop = actual.isSuccessfullyDropped();
        if (actualDrop == expectedDropped) {
            System.out.println(
                    String.format("%s: dropped SUCCESS", testName));
        } else {
            System.out.println(
                    String.format("%s: dropped FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s", expectedDropped, actualDrop));
        }

    }

    public void testForwardWhileFacingLeft() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);

        kiva.move(KivaCommand.FORWARD);
        verifyKivaState("testForwardWhileFacingLeft",
                kiva,
                new Point(1, 4),
                FacingDirection.LEFT,
                false,
                false);
    }

    public void testForwardWhileFacingDown() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        verifyKivaState("testForwardWhileFacingDown",
                kiva,
                new Point(2, 5),
                FacingDirection.DOWN,
                false,
                false);
    }

    public void testForwardWhileFacingRight() {
        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        verifyKivaState("testForwardWhileFacingRight",
                kiva,
                new Point(3, 4),
                FacingDirection.RIGHT,
                false,
                false);
    }

    public void testOutOfBounds() {
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);

    }

    public void testObstacle() {
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);

    }

    public void testPodAtLocation() {
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
    }

    public void testNoPodAtLocation() {
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TAKE);
    }

    public void testDropZone() {
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.DROP);

    }

    public void testNoDropZone() {
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.DROP);
    }

    public void testDropNoPod() {
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.DROP);


    }

    private boolean sameLocation(Point a, Point b) {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }

    public static void main(String[] args) {
        KivaMoveTest kiva = new KivaMoveTest();
        kiva.testObstacle();
    }
}
