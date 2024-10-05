import java.util.Scanner;

public class BillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Invoice invoice = new Invoice();

        while (true) {
            System.out.print("Enter product name (or 'exit' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();  // consume newline

            Product product = new Product(name, price);
            invoice.addProduct(product);
        }

        invoice.printInvoice();
        scanner.close();
    }
}
