/**
 * Provides the available directions a user can choose from
 */
public enum KivaCommand {
  /**Moves robot forward */
  FORWARD('F'),
  /**Turns the robot one direction to the right */
  TURN_RIGHT('R'),
  /**Turns the robot one direction to the left */
  TURN_LEFT('L'),
  /**The robot takes the pod */
  TAKE('T'),
  /**The robot drops the pod */

  DROP('D');

  private char action;

  private KivaCommand(char action) {
    this.action = action;
  }
/**
 * Method to return the direction corresponding to the char
 * @return
 */
  public char getDirectionKey() {
    return this.action;
  }
}
