import edu.duke.FileResource;
import java.util.Arrays;

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
    if (!kiva.isSuccessfullyDropped() || commands[commands.length-1]!=KivaCommand.DROP) {
      System.out.println(
        "I'm sorry, the kiva robot did not pick up the pod and then drop it off the right place"
      );
    }
    else{
        System.out.println(
        "The kiva robot successfully picked up the pod and then dropped it off. Thank you"
      );
    }
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
