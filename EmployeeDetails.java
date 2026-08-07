import java.util.Scanner;

class Employee {
    int empId;
    String empName;
    double salary;

    // Constructor
    Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    // Method to display employee details
    void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Salary : " + salary);
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        String name = sc.nextLine();
        double salary = sc.nextDouble();

        // Create object using constructor
        Employee emp = new Employee(id, name, salary);

        // Display details
        emp.display();

        sc.close();
    }
}