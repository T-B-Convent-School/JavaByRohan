import java.util.Scanner;

public class TheaterReservationSystem {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private static final char[][] seats = new char[ROWS][COLUMNS];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSeats();
        int choice;
        do {
            System.out.println("\nTheater Reservation System");
            System.out.println("1. View Seats");
            System.out.println("2. Make a Reservation");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displaySeats();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = 'A'; // 'A' means available
            }
        }
    }

    private static void displaySeats() {
        System.out.println("\nCurrent Seat Availability:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void makeReservation() {
        displaySeats();
        System.out.print("Enter the row (0-4): ");
        int row = scanner.nextInt();
        System.out.print("Enter the column (0-4): ");
        int column = scanner.nextInt();

        if (row < 0 || row >= ROWS || column < 0 || column >= COLUMNS) {
            System.out.println("Invalid seat selection. Try again.");
            return;
        }

        if (seats[row][column] == 'R') {
            System.out.println("Seat already reserved. Choose another seat.");
        } else {
            seats[row][column] = 'R'; // 'R' means reserved
            System.out.println("Reservation successful for seat (" + row + ", " + column + ")");
        }
    }
}
