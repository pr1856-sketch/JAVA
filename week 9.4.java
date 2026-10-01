import java.sql.*;
import java.util.Scanner;

/*
 * Q4 - Library Book Management (JDBC + MySQL)
 *
 * SQL setup:
 *   CREATE DATABASE IF NOT EXISTS library_db;
 *   USE library_db;
 *   CREATE TABLE Book (
 *       BookID       INT PRIMARY KEY,
 *       Title        VARCHAR(100) NOT NULL,
 *       Author       VARCHAR(100) NOT NULL,
 *       Price        DECIMAL(8,2),
 *       Availability VARCHAR(15) DEFAULT 'Available'   -- 'Available' or 'Issued'
 *   );
 *
 * Compile: javac LibraryManagement.java
 * Run:     java -cp .;mysql-connector-j-8.x.x.jar LibraryManagement      (Windows)
 *          java -cp .:mysql-connector-j-8.x.x.jar LibraryManagement      (Linux/Mac)
 */
public class LibraryManagement {

    private static final String URL  = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";
    private static final String PASS = "your_password";   // change this

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to MySQL successfully.");

            while (true) {
                System.out.println("\n===== LIBRARY MENU =====");
                System.out.println("1. Insert a new book");
                System.out.println("2. Search book by Book ID");
                System.out.println("3. Display all available books");
                System.out.println("4. Issue a book (change availability)");
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
                    case 1: insertBook(con, sc);     break;
                    case 2: searchBook(con, sc);     break;
                    case 3: displayAvailable(con);   break;
                    case 4: issueBook(con, sc);      break;
                    case 5: System.out.println("Goodbye!"); return;
                    default: System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // 1. Insert a new book
    private static void insertBook(Connection con, Scanner sc) {
        String sql = "INSERT INTO Book (BookID, Title, Author, Price, Availability) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Book ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Title: ");
            String title = sc.nextLine().trim();
            System.out.print("Author: ");
            String author = sc.nextLine().trim();
            System.out.print("Price: ");
            double price = Double.parseDouble(sc.nextLine().trim());

            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);
            ps.setString(5, "Available");

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Book inserted successfully." : "Insert failed.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("A book with this ID already exists.");
        } catch (SQLException e) {
            System.out.println("Error inserting book: " + e.getMessage());
        }
    }

    // 2. Search a book by Book ID
    private static void searchBook(Connection con, Scanner sc) {
        String sql = "SELECT * FROM Book WHERE BookID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Enter Book ID: ");
            ps.setInt(1, Integer.parseInt(sc.nextLine().trim()));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    printHeader();
                    printRow(rs);
                } else {
                    System.out.println("No book found with that ID.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Book ID.");
        } catch (SQLException e) {
            System.out.println("Error searching book: " + e.getMessage());
        }
    }

    // 3. Display all available books
    private static void displayAvailable(Connection con) {
        String sql = "SELECT * FROM Book WHERE Availability = 'Available'";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean found = false;
            printHeader();
            while (rs.next()) {
                found = true;
                printRow(rs);
            }
            if (!found) System.out.println("No available books.");
        } catch (SQLException e) {
            System.out.println("Error fetching books: " + e.getMessage());
        }
    }

    // 4. Change availability after a book is issued
    private static void issueBook(Connection con, Scanner sc) {
        String check  = "SELECT Availability FROM Book WHERE BookID = ?";
        String update = "UPDATE Book SET Availability = 'Issued' WHERE BookID = ?";
        try (PreparedStatement psCheck = con.prepareStatement(check);
             PreparedStatement psUpdate = con.prepareStatement(update)) {

            System.out.print("Enter Book ID to issue: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            psCheck.setInt(1, id);
            try (ResultSet rs = psCheck.executeQuery()) {
                if (!rs.next()) {
                    System.out.println("No book found with that ID.");
                    return;
                }
                if ("Issued".equalsIgnoreCase(rs.getString("Availability"))) {
                    System.out.println("This book is already issued.");
                    return;
                }
            }

            psUpdate.setInt(1, id);
            psUpdate.executeUpdate();
            System.out.println("Book issued. Availability changed to 'Issued'.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid Book ID.");
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    // ---- helpers ----
    private static void printHeader() {
        System.out.printf("%-8s %-28s %-22s %-10s %-12s%n",
                "BookID", "Title", "Author", "Price", "Availability");
        System.out.println("-".repeat(84));
    }

    private static void printRow(ResultSet rs) throws SQLException {
        System.out.printf("%-8d %-28s %-22s %-10.2f %-12s%n",
                rs.getInt("BookID"),
                rs.getString("Title"),
                rs.getString("Author"),
                rs.getDouble("Price"),
                rs.getString("Availability"));
    }
}