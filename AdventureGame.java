import java.util.Scanner;

public class AdventureGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static String currentRoom = "Start Room";

    public static void main(String[] args) {
        System.out.println("Welcome to the Adventure Game!");
        while (true) {
            switch (currentRoom) {
                case "Start Room":
                    startRoom();
                    break;
                case "Forest":
                    forest();
                    break;
                case "Cave":
                    cave();
                    break;
                case "Treasure Room":
                    treasureRoom();
                    break;
                default:
                    System.out.println("You are lost!");
                    return;
            }
        }
    }

    private static void startRoom() {
        System.out.println("You are in the Start Room. You can go to the Forest or Cave.");
        System.out.print("Where do you want to go? (Forest/Cave): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Forest")) {
            currentRoom = "Forest";
        } else if (choice.equalsIgnoreCase("Cave")) {
            currentRoom = "Cave";
        } else {
            System.out.println("Invalid choice! Try again.");
        }
    }

    private static void forest() {
        System.out.println("You are in a lush green forest. You can see a path leading to a Treasure Room.");
        System.out.print("Where do you want to go? (Treasure Room/Start Room): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Treasure Room")) {
            currentRoom = "Treasure Room";
        } else if (choice.equalsIgnoreCase("Start Room")) {
            currentRoom = "Start Room";
        } else {
            System.out.println("Invalid choice! Try again.");
        }
    }

    private static void cave() {
        System.out.println("You are in a dark cave. There's a spooky sound coming from deeper inside.");
        System.out.print("Do you want to go back or explore deeper? (Back/Explore): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Back")) {
            currentRoom = "Start Room";
        } else if (choice.equalsIgnoreCase("Explore")) {
            System.out.println("You found a treasure chest! You win!");
            System.exit(0);
        } else {
            System.out.println("Invalid choice! Try again.");
        }
    }

    private static void treasureRoom() {
        System.out.println("You've entered the Treasure Room. You found gold and jewels!");
        System.out.print("What do you want to do? (Back to Start): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Back to Start")) {
            currentRoom = "Start Room";
        } else {
            System.out.println("Invalid choice! Try again.");
        }
    }
}
