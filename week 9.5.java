import java.sql.*;
import java.util.Scanner;

/*
 * Q5 - Store Product Management (JDBC + MySQL)
 *
 * SQL setup:
 *   CREATE DATABASE IF NOT EXISTS store_db;
 *   USE store_db;
 *   CREATE TABLE Product (
 *       ProductID   INT PRIMARY KEY,
 *       ProductName VARCHAR(100) NOT NULL,
 *       Price       DECIMAL(10,2),
 *       Quantity    INT
 *   );
 *
 * Compile: javac ProductManagement.java
 * Run:     java -cp .;mysql-connector-j-8.x.x.jar ProductManagement      (Windows)
 *          java -cp .:mysql-connector-j-8.x.x.jar ProductManagement      (Linux/Mac)
 */
public class ProductManagement {

    private static final String URL  = "jdbc:mysql://localhost:3306/store_db";
    private static final String USER = "root";
    private static final String PASS = "your_password";   // change this

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to MySQL successfully.");

            while (true) {
                System.out.println("\n===== PRODUCT MENU =====");
                System.out.println("1. Insert a new product");
                System.out.println("2. Retrieve product by Product ID");
                System.out.println("3. Update product quantity");
                System.out.println("4. Display products with quantity below 10");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number between 1 and 5.");
                    continue;
                }

                switch (choice) {
                    case 1: insertProduct(con, sc);    break;
                    case 2: retrieveProduct(con, sc);  break;
                    case 3: updateQuantity(con, sc);   break;
                    case 4: displayLowStock(con);      break;
                    case 5: System.out.println("Goodbye!"); return;
                    default: System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Insert a new product
    private static void insertProduct(Connection con, Scanner sc) {
        String sql = "INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Product ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Product Name: ");
            String name = sc.nextLine().trim();
            System.out.print("Price: ");
            double price = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Quantity: ");
            int qty = Integer.parseInt(sc.nextLine().trim());

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, qty);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Product inserted successfully." : "Insert failed.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("A product with this ID already exists.");
        } catch (SQLException e) {
            System.out.println("Error inserting product: " + e.getMessage());
        }
    }

    // Retrieve a product using Product ID
    private static void retrieveProduct(Connection con, Scanner sc) {
        String sql = "SELECT * FROM Product WHERE ProductID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Enter Product ID: ");
            ps.setInt(1, Integer.parseInt(sc.nextLine().trim()));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    printHeader();
                    printRow(rs);
                } else {
                    System.out.println("No product found with that ID.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Product ID.");
        } catch (SQLException e) {
            System.out.println("Error retrieving product: " + e.getMessage());
        }
    }

    // Update the quantity of a product
    private static void updateQuantity(Connection con, Scanner sc) {
        String sql = "UPDATE Product SET Quantity = ? WHERE ProductID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter new quantity: ");
            int qty = Integer.parseInt(sc.nextLine().trim());

            ps.setInt(1, qty);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Quantity updated successfully."
                                        : "No product found with that ID.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        } catch (SQLException e) {
            System.out.println("Error updating quantity: " + e.getMessage());
        }
    }

    // Display all products whose quantity is below 10
    private static void displayLowStock(Connection con) {
        String sql = "SELECT * FROM Product WHERE Quantity < 10";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean found = false;
            printHeader();
            while (rs.next()) {
                found = true;
                printRow(rs);
            }
            if (!found) System.out.println("No products with quantity below 10.");
        } catch (SQLException e) {
            System.out.println("Error fetching products: " + e.getMessage());
        }
    }

    // ---- helpers ----
    private static void printHeader() {
        System.out.printf("%-10s %-28s %-12s %-10s%n",
                "ProductID", "ProductName", "Price", "Quantity");
        System.out.println("-".repeat(64));
    }

    private static void printRow(ResultSet rs) throws SQLException {
        System.out.printf("%-10d %-28s %-12.2f %-10d%n",
                rs.getInt("ProductID"),
                rs.getString("ProductName"),
                rs.getDouble("Price"),
                rs.getInt("Quantity"));
    }
}