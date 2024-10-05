import java.util.ArrayList;
import java.util.Scanner;

record Investor(String name, double investmentAmount) {

    @Override
    public String toString() {
        return "Investor Name: " + name + ", Investment Amount: $" + investmentAmount;
    }
}

class InvestorManagementSystem {
    private final ArrayList<Investor> investors = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addInvestor() {
        System.out.print("Enter Investor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Investment Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        investors.add(new Investor(name, amount));
        System.out.println("Investor added successfully!");
    }

    public void displayInvestors() {
        if (investors.isEmpty()) {
            System.out.println("No investors found.");
        } else {
            System.out.println("List of Investors:");
            for (Investor investor : investors) {
                System.out.println(investor);
            }
        }
    }

    public void run() {
        while (true) {
            System.out.println("\nInvestor Management System");
            System.out.println("1. Add Investor");
            System.out.println("2. Display Investors");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addInvestor();
                    break;
                case 2:
                    displayInvestors();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InvestorManagementSystem ims = new InvestorManagementSystem();
        ims.run();
    }
}
