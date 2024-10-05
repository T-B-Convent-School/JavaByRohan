import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private final List<Product> products;

    public Invoice() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printInvoice() {
        double total = 0;
        System.out.println("----- Invoice -----");
        for (Product product : products) {
            System.out.printf("%s - $%.2f%n", product.name(), product.price());
            total += product.price();
        }
        System.out.printf("Total: $%.2f%n", total);
        System.out.println("-------------------");
    }
}
