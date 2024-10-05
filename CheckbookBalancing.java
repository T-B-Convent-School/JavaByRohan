import java.util.ArrayList;
import java.util.Scanner;

public class CheckbookBalancing {
    private final ArrayList<Transaction> transactions;
    private double balance;

    public CheckbookBalancing(double initialBalance) {
        transactions = new ArrayList<>();
        this.balance = initialBalance;
    }

    public void addTransaction(String description, double amount) {
        transactions.add(new Transaction(description, amount));
        balance += amount;
        System.out.println("Transaction added: " + description + " of amount " + amount);
    }

    public void printTransactions() {
        System.out.println("\nTransactions:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.description() + ": " + transaction.amount());
        }
    }

    public void printBalance() {
        System.out.println("\nCurrent Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        CheckbookBalancing checkbook = new CheckbookBalancing(initialBalance);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter transaction description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter transaction amount (negative for expenses): ");
                    double amount = scanner.nextDouble();
                    checkbook.addTransaction(description, amount);
                    break;
                case 2:
                    checkbook.printTransactions();
                    break;
                case 3:
                    checkbook.printBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
