public class QuizTime {
    public static void main(String[] args) {

        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("What is 2 + 2?", "4"));
        quiz.addQuestion(new Question("What is the capital of England?", "London"));
        quiz.addQuestion(new Question("What colour is the sky?", "blue"));

        quiz.giveQuiz();
    }
}