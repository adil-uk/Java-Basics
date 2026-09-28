
import java.util.Scanner;
public class Average
{
    public static  void main(String[] args)
    {
        double val1, val2, val3;
        double average;
        Scanner scan = new Scanner(System.in);

        // get three values from user
        System.out.println("Please enter three integers and " + "I will compute their average");

        System.out.print("Enter 1st value: ");
        val1 = scan.nextInt();
        System.out.print("Enter 2nd value: ");
        val2 = scan.nextInt();
        System.out.print("Enter 3rd value: ");
        val3 = scan.nextInt();

        //compute the average
        average = (val1 + val2 + val3) / 3;

        //print the average
        System.out.println("The average is: " + average + ".");
    }
}
