import java.util.Random;

public class DiceRolls {

    public void simulate(int rolls) {
        int[] counts = new int[13];
        Random rand = new Random();
        for (int k = 0; k < rolls; k++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            counts[d1 + d2] += 1;
        }
        for (int k = 2; k <= 12; k++) {
            System.out.println(k + "'s=\t" + counts[k] + "\t" + 100.0 * counts[k] / rolls);
        }
    }

    public static void main(String[] args) {
        DiceRolls dice = new DiceRolls();
        dice.simulate(10);
    }
}