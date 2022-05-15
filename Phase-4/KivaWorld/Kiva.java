import edu.duke.Point;

public class Kiva {
    private boolean carryingPod;
    private boolean succesfullyDropped;
    private Point currentLocation;
    private FloorMap map;
    private FacingDirection directionFacing;

    //Constructors
    public Kiva(FloorMap map) {
        this.map = map;
        this.currentLocation = map.getInitialKivaLocation();
        carryingPod = false;
        succesfullyDropped = false;
        directionFacing = FacingDirection.UP;
    }

    public Kiva(FloorMap map, Point currentLocation) {
        Kiva kiva = new Kiva(map);
        this.currentLocation = currentLocation;
    }

    //Getters
    public Point getCurrentLocation() {
        return currentLocation;
    }

    public boolean isCarryingPod() {
        return carryingPod;
    }

    public boolean isSuccessfullyDropped() {
        return succesfullyDropped;
    }

    public FacingDirection getDirectionFacing() {
        return directionFacing;
    }
    
    //Methods
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
    //Setters
    private void moveForward() {
        int x = 0;
        int y = 0;
        if (directionFacing == FacingDirection.UP) {
            x = currentLocation.getX() + FacingDirection.UP.getDelta().getX();
            y = currentLocation.getY() + FacingDirection.UP.getDelta().getY();
        } else if (directionFacing == FacingDirection.LEFT) {
            x = currentLocation.getX() + FacingDirection.LEFT.getDelta().getX();
            y = currentLocation.getY() + FacingDirection.LEFT.getDelta().getY();
        } else if (directionFacing == FacingDirection.RIGHT) {
            x = currentLocation.getX() + FacingDirection.RIGHT.getDelta().getX();
            y = currentLocation.getY() + FacingDirection.RIGHT.getDelta().getY();
        } else if (directionFacing == FacingDirection.DOWN) {
            x = currentLocation.getX() + FacingDirection.DOWN.getDelta().getX();
            y = currentLocation.getY() + FacingDirection.DOWN.getDelta().getY();
        }
        currentLocation = new Point(x, y);

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
        carryingPod = true;
        succesfullyDropped = false;
    }

    private void drop() {
        carryingPod = false;
        succesfullyDropped = true;
    }
}
