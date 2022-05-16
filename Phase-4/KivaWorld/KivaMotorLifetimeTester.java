
public class KivaMotorLifetimeTester{
    
    String defaultLayout = ""
                            +"-----\n"
                            +"|K D|\n"
                            +"| P |\n"
                            +"|* *|\n"
                            +"-----\n";

    FloorMap defaultMap = new FloorMap(defaultLayout);

    public void test(){
        Kiva kiva = new Kiva(defaultMap);
        System.out.println(kiva.getMotorLifeTime());
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println(kiva.getMotorLifeTime());
        kiva.move(KivaCommand.FORWARD);
        System.out.println(kiva.getMotorLifeTime());
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println(kiva.getMotorLifeTime());
        kiva.move(KivaCommand.FORWARD);
        System.out.println(kiva.getMotorLifeTime());
        kiva.move(KivaCommand.TAKE);
        System.out.println(kiva.getMotorLifeTime());
    }
    public static void main(String[] args) {
        KivaMotorLifetimeTester test = new KivaMotorLifetimeTester();
        test.test();
    }

}