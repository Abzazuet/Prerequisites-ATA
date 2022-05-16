import edu.duke.Point;

public class Kiva {

  private boolean carryingPod;
  private boolean succesfullyDropped;
  private Point currentLocation;
  private FloorMap map;
  private FacingDirection directionFacing;
  private long motorLifeTime;

  /**
   * Constructor used when only map is provided
   * @param map
   */
  public Kiva(FloorMap map) {
    this.map = map;
    this.currentLocation = map.getInitialKivaLocation();
    carryingPod = false;
    succesfullyDropped = false;
    directionFacing = FacingDirection.UP;
  }
/**
   * Constructor used when map and initial location are provided
   * @param map 
   * @param currentLocation
   */
  public Kiva(FloorMap map, Point currentLocation) {
    new Kiva(map);
    this.currentLocation = currentLocation;
  }

  // Getters
  /**
   * Get the current location of the POD
   */
  public Point getCurrentLocation() {
    return currentLocation;
  }
/**
   * Return true if robot is carrying pod
   */
  public boolean isCarryingPod() {
    return carryingPod;
  }
/**
   * Return true if robot dropped pod
   */
  public boolean isSuccessfullyDropped() {
    return succesfullyDropped;
  }
/**
   * Method that returns the direction of the robot
   */
  public FacingDirection getDirectionFacing() {
    return directionFacing;
  }
/**
   * Evaluates if the desired position to move the robot is inside the provided map
   */
  private boolean isPositionValid(int x, int y) {
    int maxCol = map.getMaxColNum();
    int maxRow = map.getMaxRowNum();
    int minRow = map.getMinRowNum();
    int minCol = map.getMinColNum();

    if (minRow <= y && y <= maxRow && minCol <= x && x <= maxCol) {
      return true;
    }
    return false;
  }
/**
   * Returns the object type where ther robot is indicated to go
   */
  private FloorMapObject objectAtPosition(int x, int y) {
    FloorMapObject object = map.getObjectAtLocation(new Point(x, y));
    return object;
  }
/**
   * Evaluates if the position has an obstacle
   */
  private boolean isPositionObstacle(int x, int y) {
    if (objectAtPosition(x, y) == FloorMapObject.OBSTACLE) {
      return true;
    }
    return false;
  }
/**
   * Evaluates if the position has a POD
   */
  private boolean isPositionPod(int x, int y) {
    if (objectAtPosition(x, y) == FloorMapObject.POD) {
      return true;
    }
    return false;
  }
/**
   * Return the lifetime of the motor in miliseconds
   */
  public long getMotorLifeTime() {
    return motorLifeTime;
  }
/**
   * Evaluates if the positionis a drop zone
   */
  // Methods
  private boolean isPositionDrop(int x, int y) {
    if (objectAtPosition(x, y) == FloorMapObject.DROP_ZONE) {
      return true;
    }
    return false;
  }
/**
   * Executes the provided direction
   */
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
  /**
   * Evaluates the next position and moves the robot to that position, adds 1000ms to motorLifeTime
   */
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
        throw new IllegalMoveException(
          String.format(
            "There is a %s at location %s",
            map.getObjectAtLocation(new Point(x, y)),
            new Point(x, y)
          )
        );
      } else {
        if (isPositionPod(x, y) && isCarryingPod()) {
          throw new IllegalMoveException(
            "The robot is carrying a POD, this would cause a collision"
          );
        } else {
          currentLocation = new Point(x, y);
          incrementMotorLifeTime();
        }
      }
    } else {
      throw new IllegalMoveException(
        "The requested movement takes the robot out of boundaries"
      );
    }
  }
/**
   * Turns the robot to the left, adds 1000ms to motorLifeTime
   */
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
    incrementMotorLifeTime();
  }
/**
   * Turns the robot to the right, adds 1000ms to motorLifeTime
   */
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
    incrementMotorLifeTime();
  }

  private void take() {
    if (isPositionPod(currentLocation.getX(), currentLocation.getY())) {
      carryingPod = true;
      succesfullyDropped = false;
    } else {
      throw new NoPodException(
        String.format(
          "Can't take: location %s is %s, not POD!",
          currentLocation,
          map.getObjectAtLocation(currentLocation)
        )
      );
    }
  }

  private void drop() {
    if (isPositionDrop(currentLocation.getX(), currentLocation.getY())) {
      if (!carryingPod) {
        throw new IllegalMoveException("Robot is not carrying a pod");
      } else {
        succesfullyDropped = true;
        carryingPod = false;
      }
    } else {
      throw new IllegalDropZoneException(
        String.format(
          "Can't DROP: location %s is %s, not DROP!",
          currentLocation,
          map.getObjectAtLocation(currentLocation)
        )
      );
    }
  }

  private void incrementMotorLifeTime() {
    motorLifeTime += 1000;
  }
}
