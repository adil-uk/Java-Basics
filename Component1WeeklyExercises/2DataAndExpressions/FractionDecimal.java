import java.util.Scanner;

public class FractionDecimal
{
    public static void main(String[] args)
    {
        int numerator, denominator;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        numerator = input.nextInt();
        System.out.print("Enter denominator: ");
        denominator = input.nextInt();

        System.out.println("Decimal:" + (double) numerator/denominator);
    }
}
