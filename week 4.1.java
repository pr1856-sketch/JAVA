import java.util.Scanner;

class Product {
    int productId;
    String productName;
    double price;
    int quantity;

    Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        double totalPrice = price * quantity;
        double discount;

        if (totalPrice >= 5000) {
            discount = totalPrice * 0.10;
        } else {
            discount = totalPrice * 0.05;
        }

        double finalPrice = totalPrice - discount;

        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + productName);
        System.out.println("Total Price: ₹" + totalPrice);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Price: ₹" + finalPrice);
        System.out.println();
    }
}

public class ProductBillingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Product " + (i + 1));

            System.out.print("Product ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            products[i] = new Product(id, name, price, quantity);

            System.out.println();
        }

        System.out.println("----- PRODUCT BILL -----");

        for (int i = 0; i < 5; i++) {
            products[i].display();
        }

        sc.close();
    }
}