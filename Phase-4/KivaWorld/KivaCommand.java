public enum KivaCommand {
    FORWARD('F'),
    TURN_RIGHT('R'), 
    TURN_LEFT('L'), 
    TAKE('T'), 
    DROP('D');

    private char action;

    private KivaCommand(char action) {
        this.action = action;
    }
    public char getDirectionKey(){
        return this.action;
    }
}
