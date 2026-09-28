import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] ranges = new int[10];

        System.out.println("Enter numbers (1–100) or 0 to stop: ");
        int num = scan.nextInt();

        while (num != 0) {
            if (num >= 1 && num <= 100) {
                int index = (num - 1) / 10;
                ranges[index]++;
            }
            num = scan.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            int start = i * 10 + 1;
            int end = i * 10 + 10;

            System.out.print(start + " - " + end + " | ");

            for (int j = 0; j < ranges[i]; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}