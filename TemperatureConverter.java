import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter temperature: ");
            double temp = sc.nextDouble();

            System.out.println("Is this in (1) Celsius or (2) Fahrenheit? Enter 1 or 2:");
            int choice = sc.nextInt();

            if (choice == 1) {
                // Celsius to Fahrenheit
                double fahrenheit = (temp * 9 / 5) + 32;
                System.out.println("Temperature in Fahrenheit: " + fahrenheit);
            } else if (choice == 2) {
                // Fahrenheit to Celsius
                double celsius = (temp - 32) * 5 / 9;
                System.out.println("Temperature in Celsius: " + celsius);
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
