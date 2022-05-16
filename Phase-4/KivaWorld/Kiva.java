import edu.duke.Point;

public class Kiva {
    private boolean carryingPod;
    private boolean succesfullyDropped;
    private Point currentLocation;
    private FloorMap map;
    private FacingDirection directionFacing;

    // Constructors
    public Kiva(FloorMap map) {
        this.map = map;
        this.currentLocation = map.getInitialKivaLocation();
        carryingPod = false;
        succesfullyDropped = false;
        directionFacing = FacingDirection.UP;
    }

    public Kiva(FloorMap map, Point currentLocation) {
        new Kiva(map);
        this.currentLocation = currentLocation;
    }

    // Getters
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

    private boolean isPositionValid(int x, int y) {
        int maxCol = map.getMaxColNum();
        int maxRow = map.getMaxRowNum();
        int minRow = map.getMinRowNum();
        int minCol = map.getMinColNum();

        if (minRow < y && y < maxRow && minCol < x && x < maxCol) {
            return true;
        }
        return false;
    }

    private FloorMapObject objectAtPosition(int x, int y) {
        FloorMapObject object = map.getObjectAtLocation(new Point(x, y));
        return object;
    }

    private boolean isPositionObstacle(int x, int y) {
        if (objectAtPosition(x, y) == FloorMapObject.OBSTACLE) {
            return true;
        }
        return false;
    }

    private boolean isPositionPod(int x, int y) {
        if (objectAtPosition(x, y) == FloorMapObject.POD) {
            return true;
        }
        return false;
    }

    // Methods
    private boolean isPositionDrop(int x, int y) {
        if (objectAtPosition(x, y) == FloorMapObject.DROP_ZONE) {
            return true;
        }
        return false;
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

    // Setters
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
        if (isPositionValid(x, y)) {
            if (isPositionObstacle(x, y)) {
                throw new IllegalMoveException(String.format("There is a %s at location %s", map.getObjectAtLocation(new Point(x, y)), new Point(x, y)));
            } else {
                if (isPositionPod(x, y) && isCarryingPod()) {
                    throw new IllegalMoveException("The robot is carrying a POD, this would cause a collision");
                } else {
                    currentLocation = new Point(x, y);
                }

            }
        } else {
            throw new IllegalMoveException("The requested movement takes the robot out of boundaries");
        }

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
        if (isPositionPod(currentLocation.getX(), currentLocation.getY())) {
            carryingPod = true;
            succesfullyDropped = false;
        } else {
            throw new NoPodException(String.format(
                "Can't take: location %s is %s, not POD!", currentLocation, map.getObjectAtLocation(currentLocation))
                );
        }

    }

    private void drop() {
        if (isPositionDrop(currentLocation.getX(), currentLocation.getY())) {
            if (!carryingPod) {
                throw new IllegalMoveException("Robot is not carrying a pod");
            } else {
                carryingPod = false;
                succesfullyDropped = true;
            }
        } else {
            throw new IllegalDropZoneException(String.format(
                "Can't DROP: location %s is %s, not DROP!", currentLocation, map.getObjectAtLocation(currentLocation))
                );
        }

    }
}
