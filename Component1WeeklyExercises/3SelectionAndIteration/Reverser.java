import java.util.Scanner;

public class Reverser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence and this will reverse the characters in each word: ");
        String sentence = sc.nextLine();

        Scanner words = new Scanner(sentence);
        String result = "";
        while (words.hasNext()) {
            String word = words.next();
            String reversed = "";

            for (int i = word.length() - 1; i >= 0; i--) {
                reversed += word.charAt(i);
            }

            result += reversed + " ";
        }

        System.out.println(result.trim());

    }
}
