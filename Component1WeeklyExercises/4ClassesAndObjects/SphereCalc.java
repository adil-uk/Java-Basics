import java.util.Scanner;

public class SphereCalc {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius of the sphere: ");
        double radius = input.nextDouble();

        double volume = (4 * Math.PI * radius * radius * radius) / 3;
        double surfaceArea = 4 * Math.PI * radius * radius;

        System.out.printf("Volume: %.4f\n", volume);
        System.out.printf("Surface Area: %.4f", surfaceArea);

    }
}
