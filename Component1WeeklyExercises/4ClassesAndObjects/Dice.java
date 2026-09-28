import java.util.Scanner;
import java.util.Random;

public class Dice {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("How many sides does die 1 have? ");
        int sides1 = input.nextInt();

        System.out.print("How many sides does die 2 have? ");
        int sides2 = input.nextInt();

        Die die1 = new Die(sides1);
        Die die2 = new Die(sides2);

        int sum1 = 0;
        int sum2 = 0;

        die1.roll();
        die2.roll();
        System.out.println("Die 1 first roll = " + die1.getResult());
        System.out.println("Die 2 first roll = " + die2.getResult());
        sum1 = sum1 + die1.getResult();
        sum2 = sum2 + die2.getResult();

        die1.roll();
        die2.roll();
        System.out.println("Die 1 second roll = " + die1.getResult());
        System.out.println("Die 2 second roll = " + die2.getResult());
        sum1 = sum1 + die1.getResult();
        sum2 = sum2 + die2.getResult();

        die1.roll();
        die2.roll();

        System.out.println("Die 1 third roll = " + die1.getResult());

        System.out.println("Die 2 third roll = " + die2.getResult());
        sum1 = sum1 + die1.getResult();
        sum2 = sum2 + die2.getResult();
        double average1 = (double) sum1 / 3;
        double average2 = (double) sum2 / 3;
        System.out.println("Die 1 rolled a total of " + sum1 + " and rolled " + average1 + " on average");
        System.out.println("Die 2 rolled a total of " + sum2 + " and rolled " + average2 + " on average");
    }
}

class Die {

    private int sides;
    private int value;
    private Random random = new Random();

    public Die(int numberOfSides) {
        sides = numberOfSides;
    }

    public void roll() {
        value = random.nextInt(sides) + 1;
    }

    public int getResult() {
        return value;
    }
}
