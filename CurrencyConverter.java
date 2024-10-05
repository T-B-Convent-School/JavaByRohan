import java.util.Scanner;

public class CurrencyConverter {

    // Method to convert currency
    public static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    public static void main(String[] args) {
        // Exchange rates (as of a certain date, can be updated)
        double usdToInr = 83.00;
        double eurToInr = 88.00;
        double inrToUsd = 1 / usdToInr;
        double inrToEur = 1 / eurToInr;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");

        // Input amount to convert
        System.out.print("Enter the amount you want to convert: ");
        double amount = scanner.nextDouble();

        // Display conversion options
        System.out.println("Select the currency you want to convert from:");
        System.out.println("1. USD to INR");
        System.out.println("2. EUR to INR");
        System.out.println("3. INR to USD");
        System.out.println("4. INR to EUR");

        int choice = scanner.nextInt();
        double result;

        // Perform conversion based on user choice
        switch (choice) {
            case 1:
                result = convertCurrency(amount, usdToInr);
                System.out.println(amount + " USD is equal to " + result + " INR.");
                break;
            case 2:
                result = convertCurrency(amount, eurToInr);
                System.out.println(amount + " EUR is equal to " + result + " INR.");
                break;
            case 3:
                result = convertCurrency(amount, inrToUsd);
                System.out.println(amount + " INR is equal to " + result + " USD.");
                break;
            case 4:
                result = convertCurrency(amount, inrToEur);
                System.out.println(amount + " INR is equal to " + result + " EUR.");
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                break;
        }

        scanner.close();
    }
}
