import java.util.Random;
import java.util.Scanner;

public class snake {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            String[] choices = {"s", "w", "g"};
            boolean playAgain = true;
            
            while (playAgain) {
                // Get user's choice
                System.out.println("Enter 's' for Snake, 'w' for Water, or 'g' for Gun:");
                String userChoice = scanner.nextLine();
                
                // Validate user input
                if (!userChoice.equals("s") && !userChoice.equals("w") && !userChoice.equals("g")) {
                    System.out.println("Invalid input. Please enter 's', 'w', or 'g'.");
                    continue;
                }
                
                // Get computer's choice
                String computerChoice = choices[random.nextInt(choices.length)];
                
                // Determine the winner
                String result = determineWinner(userChoice, computerChoice);
                
                // Show result
                System.out.println("You chose: " + userChoice);
                System.out.println("Computer chose: " + computerChoice);
                System.out.println("Result: " + result);
                
                // Ask to play again
                System.out.println("Do you want to play again? (yes/no)");
                String playAgainResponse = scanner.nextLine();
                playAgain = playAgainResponse.equalsIgnoreCase("yes");
            }
        }
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("s") && computerChoice.equals("w")) ||
                   (userChoice.equals("w") && computerChoice.equals("g")) ||
                   (userChoice.equals("g") && computerChoice.equals("s"))) {
            return "You win!";
        } else {
            return "You lose!";
        }
    }
}