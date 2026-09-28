public class Quiz {

    Question[] questions = new Question[25];
    int totalQuestions = 0;

    public void addQuestion(Question q) {
        if (totalQuestions < 25) {
            questions[totalQuestions] = q;
            totalQuestions++;
        } else {
            System.out.println("Quiz is full");
        }
    }

    public void giveQuiz() {
        int score = 0;

        for (int i = 0; i < totalQuestions; i++) {
            boolean correct = questions[i].askQuestion();

            if (correct) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\nFinal Score: " + score + "/" + totalQuestions);
    }
}