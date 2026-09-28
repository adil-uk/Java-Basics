import java.util.Scanner;

public class MilesKm
{
    public static void  main(String[] args)
    {
        float miles;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter miles: ");
        miles = scan.nextFloat();

        System.out.println("Miles to Kilometers: " + miles * 1.60935);
    }
}
