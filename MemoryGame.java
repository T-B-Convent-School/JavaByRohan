import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MemoryGame {
    private static final int SIZE = 4; // 4x4 grid
    private static final String[][] board = new String[SIZE][SIZE];
    private static final boolean[][] revealed = new boolean[SIZE][SIZE];
    private static final String[] cards = {
            "A", "A", "B", "B",
            "C", "C", "D", "D",
            "E", "E", "F", "F",
            "G", "G", "H", "H"
    };

    public static void main(String[] args) {
        initializeBoard();
        Scanner scanner = new Scanner(System.in);
        int matches = 0;

        while (matches < 8) {
            printBoard();
            System.out.println("Enter the coordinates of the first card (row and column):");
            int row1 = scanner.nextInt();
            int col1 = scanner.nextInt();

            System.out.println("Enter the coordinates of the second card (row and column):");
            int row2 = scanner.nextInt();
            int col2 = scanner.nextInt();

            if (revealCards(row1, col1, row2, col2)) {
                matches++;
                System.out.println("It's a match!");
            } else {
                System.out.println("Not a match, try again.");
                revealed[row1][col1] = false;
                revealed[row2][col2] = false;
            }
        }

        System.out.println("Congratulations! You've found all the pairs!");
        scanner.close();
    }

    private static void initializeBoard() {
        Collections.shuffle(Arrays.asList(cards));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = cards[i * SIZE + j];
                revealed[i][j] = false;
            }
        }
    }

    private static void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (revealed[i][j]) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private static boolean revealCards(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row1 >= SIZE || col1 < 0 || col1 >= SIZE ||
                row2 < 0 || row2 >= SIZE || col2 < 0 || col2 >= SIZE ||
                revealed[row1][col1] || revealed[row2][col2] || (row1 == row2 && col1 == col2)) {
            System.out.println("Invalid move! Try again.");
            return false;
        }

        revealed[row1][col1] = true;
        revealed[row2][col2] = true;

        return board[row1][col1].equals(board[row2][col2]);
    }
}
