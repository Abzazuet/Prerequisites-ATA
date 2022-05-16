import edu.duke.FileResource;
import edu.duke.Point;

/**
 * This is the class that controls Kiva's actions. Implement the <code>run()</code>
 * method to deliver the pod and avoid the obstacles.
 *
 * This is starter code that may or may not work. You will need to update the code to
 * complete the project.
 */
public class RemoteControl {

  KeyboardResource keyboardResource;

  /**
   * Build a new RemoteControl.
   */
  public RemoteControl() {
    keyboardResource = new KeyboardResource();
  }

  /**
   * The controller that directs Kiva's activity. Prompts the user for the floor map
   * to load, displays the map, and asks the user for the commands for Kiva to execute.
   *
   * [Here's the method you'll execute from within BlueJ. It may or may not run successfully
   * as-is, but you'll definitely need to add more to complete the project.]
   */
  public void run() {
    System.out.println("Please select a map file.");
    FileResource fileResource = new FileResource();
    String inputMap = fileResource.asString();
    FloorMap floorMap = new FloorMap(inputMap);
    System.out.println(floorMap);
    Kiva kiva = new Kiva(floorMap);
    System.out.println(
      String.format(
        "The initial location of the robot is %s and is facing %s",
        kiva.getCurrentLocation(),
        kiva.getDirectionFacing()
      )
    );

    System.out.println(
      "Please enter the directions for the Kiva Robot to take."
    );

    String directions = keyboardResource.getLine();
    System.out.println("Directions that you typed in: " + directions);
    KivaCommand[] commands = convertToKivaCommands(directions);
    for (KivaCommand command : commands) {
      kiva.move(command);
    }
    if (
      !kiva.isSuccessfullyDropped() ||
      commands[commands.length - 1] != KivaCommand.DROP
    ) {
      System.out.println(
        "I'm sorry, the kiva robot did not pick up the pod and then drop it off the right place"
      
        );
        mapRecreation(kiva, floorMap);

    } else {
      System.out.println(
        "The kiva robot successfully picked up the pod and then dropped it off. Thank you"
      );
    }
  }

  public FloorMap mapRecreation(Kiva kiva, FloorMap map) {
    int columns = map.getMaxColNum();
    int rows = map.getMaxRowNum();
    Point kivaLocation = kiva.getCurrentLocation();
    Point pod = map.getPodLocation();
    Point dropZone = map.getDropZoneLocation();
    System.out.println(String.format("Last kiva location: %s", kivaLocation));
    System.out.println(String.format("Pod location: %s", pod));
    System.out.println(String.format("Drop zone: %s", dropZone));
    StringBuilder newMap = new StringBuilder();
    
    for (int i = 0; i <= rows; i++) {
      for (int j = 0; j <= columns; j++) {
        Point current = new Point(j, i);
        FloorMapObject object = map.getObjectAtLocation(current);
        if (
          current.getX() == kivaLocation.getX() &&
          current.getY() == kivaLocation.getY()
        ) {
          newMap.append('K');
        } else {
          if (i == 0 || i == rows) {
            newMap.append('-');
          } else {
            if (object == FloorMapObject.OBSTACLE) {
              if (j == 0 || j == columns) {
                newMap.append('|');
              } else {
                newMap.append('*');
              }
            } else {
              newMap.append(object.toChar());
            }
          }
        }
      }
      newMap.append("\n");
    }
    System.out.println(newMap.toString());

    return new FloorMap(newMap.toString());
  }

  /**
   * Convert instructions into an array of kiva commands
   * @param directions
   */
  public KivaCommand[] convertToKivaCommands(String directions) {
    KivaCommand[] commands = new KivaCommand[directions.length()];
    int i = 0;
    for (char direction : directions.toCharArray()) {
      if (direction == KivaCommand.FORWARD.getDirectionKey()) {
        commands[i] = KivaCommand.FORWARD;
      } else if (direction == KivaCommand.TURN_RIGHT.getDirectionKey()) {
        commands[i] = KivaCommand.TURN_RIGHT;
      } else if (direction == KivaCommand.TURN_LEFT.getDirectionKey()) {
        commands[i] = KivaCommand.TURN_LEFT;
      } else if (direction == KivaCommand.DROP.getDirectionKey()) {
        commands[i] = KivaCommand.DROP;
      } else if (direction == KivaCommand.TAKE.getDirectionKey()) {
        commands[i] = KivaCommand.TAKE;
      } else {
        throw new IllegalArgumentException("An invalid direction was entered");
      }
      i++;
    }
    return commands;
  }

  public static void main(String[] args) {
    RemoteControl remote = new RemoteControl();
    remote.run();
  }
}
