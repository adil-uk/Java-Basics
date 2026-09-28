import java.util.Scanner;

public class SqaureCalc
{
    public static void main(String[] args)
    {
        int length;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the length of the square");
        length = input.nextInt();

        System.out.println("Perimeter: " + length * 4);
        System.out.println("Area: " + length * length);
    }
}
