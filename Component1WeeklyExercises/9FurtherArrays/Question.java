public class Question {

    String questionText;
    String correctAnswer;

    public Question(String question, String answer) {
        questionText = question;
        correctAnswer = answer;
    }

    public boolean askQuestion() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println(questionText);
        String userAnswer = scanner.nextLine();

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            return true;
        } else {
            return false;
        }
    }
}