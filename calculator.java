import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.println("Enter second number: ");
            double num2 = sc.nextDouble();

            System.out.println("Choose operation: +, -, *, /");
            char operation = sc.next().charAt(0);

            double result = 0;
            switch (operation) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> {
                    if (num2 != 0)
                        result = num1 / num2;
                    else
                        System.out.println("Error! Division by zero.");
                }
                default -> {
                    System.out.println("Invalid operation!");
                    return;
                }
            }

            System.out.println("The result is: " + result);
        }
    }
}
