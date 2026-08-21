// Abstract base class representing a general Product
abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method to be overridden by subclasses with specific discount rates
    public abstract double calculateDiscount();

    // Calculates the final price after subtracting the discount
    public double calculateFinalPrice() {
        return price - calculateDiscount();
    }

    public void displayDetails() {
        System.out.printf("ID: %s | Name: %-12s | Original Price: $%.2f | Discount: $%.2f | Final Price: $%.2f%n",
                productId, name, price, calculateDiscount(), calculateFinalPrice());
    }
}

// Subclass for Electronics (e.g., 10% discount)
class Electronics extends Product {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% off
    }
}

// Subclass for Clothing (e.g., 20% discount)
class Clothing extends Product {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% off
    }
}

// Subclass for Books (e.g., 5% discount)
class Books extends Product {
    public Books(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% off
    }
}

// Main class demonstrating polymorphism
public class Main {
    public static void main(String[] args) {
        // Polymorphic array holding different Product subclasses
        Product[] cart = new Product[] {
            new Electronics("E101", "Laptop", 1000.00),
            new Clothing("C202", "Jacket", 150.00),
            new Books("B303", "Java Guide", 40.00)
        };

        System.out.println("--- Shopping Cart Items ---");
        
        // Polymorphism in action: calling overridden methods at runtime
        for (Product product : cart) {
            product.displayDetails();
        }
    }
}