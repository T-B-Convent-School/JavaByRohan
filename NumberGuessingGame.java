import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        try (Scanner sc = new Scanner(System.in)) {
            int guess;
            int attempts = 0;

            do {
                System.out.println("Guess the number (between 1 and 100): ");
                guess = sc.nextInt();
                attempts++;

                if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                }
            } while (guess != targetNumber);

            System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
        }
    }
}
