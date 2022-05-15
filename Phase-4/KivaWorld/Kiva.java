import edu.duke.Point;

public class Kiva {
    private boolean carry;
    private boolean drop;
    private Point location;
    private FloorMap map;
    private FacingDirection directionFacing;

    public Kiva(FloorMap map) {
        this.map = map;
        this.location = map.getInitialKivaLocation();
        carry = false;
        drop = false;
        directionFacing = FacingDirection.UP;
    }

    public Kiva(FloorMap map, Point currentLocation) {
        Kiva kiva = new Kiva(map);
        this.location = currentLocation;
    }

    public Point getCurrentLocation() {
        return location;
    }

    public boolean isCarryingPod() {
        return carry;
    }

    public boolean isSuccessfullyDropped() {
        return drop;
    }

    public FacingDirection getDirectionFacing() {
        return directionFacing;
    }

    public void move(KivaCommand direction) {
        if (direction == KivaCommand.FORWARD) {
            moveForward();
        } else if (direction == KivaCommand.TURN_LEFT) {
            turnLeft();
        } else if (direction == KivaCommand.TURN_RIGHT) {
            turnRight();
        } else if (direction == KivaCommand.TAKE) {
            take();
        } else if (direction == KivaCommand.DROP) {
            drop();
        }
    }

    private void moveForward() {
        int x = 0;
        int y = 0;
        if (directionFacing == FacingDirection.UP) {
            x = location.getX() + FacingDirection.UP.getDelta().getX();
            y = location.getY() + FacingDirection.UP.getDelta().getY();
        } else if (directionFacing == FacingDirection.LEFT) {
            x = location.getX() + FacingDirection.LEFT.getDelta().getX();
            y = location.getY() + FacingDirection.LEFT.getDelta().getY();
        } else if (directionFacing == FacingDirection.RIGHT) {
            x = location.getX() + FacingDirection.RIGHT.getDelta().getX();
            y = location.getY() + FacingDirection.RIGHT.getDelta().getY();
        } else if (directionFacing == FacingDirection.DOWN) {
            x = location.getX() + FacingDirection.DOWN.getDelta().getX();
            y = location.getY() + FacingDirection.DOWN.getDelta().getY();
        }
        location = new Point(x, y);

    }

    private void turnLeft() {
        if (directionFacing == FacingDirection.UP) {
            directionFacing = FacingDirection.LEFT;
        } else if (directionFacing == FacingDirection.LEFT) {
            directionFacing = FacingDirection.DOWN;
        } else if (directionFacing == FacingDirection.DOWN) {
            directionFacing = FacingDirection.RIGHT;
        } else if (directionFacing == FacingDirection.RIGHT) {
            directionFacing = FacingDirection.UP;
        }
    }

    private void turnRight() {
        if (directionFacing == FacingDirection.UP) {
            directionFacing = FacingDirection.RIGHT;
        } else if (directionFacing == FacingDirection.LEFT) {
            directionFacing = FacingDirection.UP;
        } else if (directionFacing == FacingDirection.DOWN) {
            directionFacing = FacingDirection.LEFT;
        } else if (directionFacing == FacingDirection.RIGHT) {
            directionFacing = FacingDirection.DOWN;
        }
    }

    private void take() {
        carry = true;
        drop = false;
    }

    private void drop() {
        carry = false;
        drop = true;
    }
}
