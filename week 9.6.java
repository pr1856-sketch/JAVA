import java.sql.*;
import java.util.Scanner;

/*
 * Q6 - Course Registration Search (JDBC + MySQL)
 *
 * SQL setup:
 *   CREATE DATABASE IF NOT EXISTS college_db;
 *   USE college_db;
 *   CREATE TABLE CourseRegistration (
 *       StudentID   INT,
 *       StudentName VARCHAR(100),
 *       CourseCode  VARCHAR(10),
 *       CourseName  VARCHAR(100),
 *       Semester    VARCHAR(10)
 *   );
 *
 *   -- sample data
 *   INSERT INTO CourseRegistration VALUES
 *     (101, 'Arun',  'CS101', 'Data Structures', 'Sem 3'),
 *     (102, 'Priya', 'CS101', 'Data Structures', 'Sem 3'),
 *     (103, 'Kiran', 'CS102', 'Databases',       'Sem 4');
 *
 * Compile: javac CourseRegistrationSearch.java
 * Run:     java -cp .;mysql-connector-j-8.x.x.jar CourseRegistrationSearch      (Windows)
 *          java -cp .:mysql-connector-j-8.x.x.jar CourseRegistrationSearch      (Linux/Mac)
 */
public class CourseRegistrationSearch {

    private static final String URL  = "jdbc:mysql://localhost:3306/college_db";
    private static final String USER = "root";
    private static final String PASS = "your_password";   // change this

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Course Code: ");
            String courseCode = sc.nextLine().trim();

            String sql = "SELECT StudentID, StudentName, CourseCode, CourseName, Semester "
                       + "FROM CourseRegistration WHERE CourseCode = ?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, courseCode);

                try (ResultSet rs = ps.executeQuery()) {
                    boolean found = false;

                    while (rs.next()) {
                        if (!found) {
                            System.out.printf("%n%-10s %-20s %-12s %-22s %-10s%n",
                                    "StudentID", "StudentName", "CourseCode", "CourseName", "Semester");
                            System.out.println("-".repeat(78));
                            found = true;
                        }
                        System.out.printf("%-10d %-20s %-12s %-22s %-10s%n",
                                rs.getInt("StudentID"),
                                rs.getString("StudentName"),
                                rs.getString("CourseCode"),
                                rs.getString("CourseName"),
                                rs.getString("Semester"));
                    }

                    if (!found) {
                        System.out.println("No students are registered for course code: " + courseCode);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}