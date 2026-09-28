import java.util.Random;
import java.util.Scanner;

public class PinEncrypt {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a 4 digit pin to encrypt: ");
        int pin = input.nextInt();

        Encryptor encryptor = new Encryptor();
        System.out.println("Encrypted Pin:" + encryptor.encryptPin(pin));

    }
}

class Encryptor {

    private Random rand = new Random();

    public String encryptPin(int pin) {

        int random1 = rand.nextInt(64536) + 1000;
        int random2 = rand.nextInt(64536) + 1000;

        String hex1 = Integer.toHexString(random1);
        String hex2 = Integer.toHexString(random2);

        return hex1 + Integer.toHexString(pin) + hex2;
    }
}
