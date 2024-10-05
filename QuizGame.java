import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int answerIndex;

    public Question(String question, String[] options, int answerIndex) {
        this.question = question;
        this.options = options;
        this.answerIndex = answerIndex;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == answerIndex;
    }
}

public class QuizGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Question> questions = new ArrayList<>();

    public static void main(String[] args) {
        createQuestions();
        playGame();
    }

    private static void createQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 2));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"}, 1));
        questions.add(new Question("What is the largest ocean on Earth?", new String[]{"1. Atlantic", "2. Indian", "3. Arctic", "4. Pacific"}, 3));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"1. Charles Dickens", "2. Mark Twain", "3. William Shakespeare", "4. J.K. Rowling"}, 2));
        questions.add(new Question("What is the boiling point of water?", new String[]{"1. 100°C", "2. 0°C", "3. 50°C", "4. 25°C"}, 0));
    }

    private static void playGame() {
        int score = 0;
        System.out.println("Welcome to the Quiz Game!");
        System.out.println("You will be asked 5 questions. Choose the correct option (1-4).");

        for (Question question : questions) {
            System.out.println("\n" + question.question);
            for (String option : question.options) {
                System.out.println(option);
            }
            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt() - 1;

            if (question.isCorrect(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + (question.answerIndex + 1));
            }
        }

        System.out.println("\nYour total score is: " + score + "/" + questions.size());
        System.out.println("Thank you for playing!");
    }
}
