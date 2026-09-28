import java.util.Scanner;

public class PostCode {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Person[] people = new Person[25];
        int totalPeople = 0;

        System.out.println("Enter first name, last name, postcode (separated by spaces)");
        System.out.println("Type 'stop' to finish");

        while (totalPeople < 25) {

            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("stop")) {
                break;
            }

            String[] parts = line.split(" ", 3);

            if (parts.length == 3) {
                people[totalPeople] = new Person(parts[0], parts[1], parts[2]);
                totalPeople++;
            } else {
                System.out.println("Invalid input.");
            }
        }

        System.out.println("\nStored Data:");
        for (int i = 0; i < totalPeople; i++) {
            people[i].displayPerson();
        }
    }
}