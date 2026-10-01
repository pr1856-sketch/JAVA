import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    double monthlySalary;

    Employee(int employeeId, String name, double monthlySalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    // Calculate annual salary
    double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    // Calculate bonus
    double calculateBonus() {
        if (monthlySalary >= 50000) {
            return monthlySalary * 0.10;
        } else {
            return monthlySalary * 0.05;
        }
    }

    // Check bonus eligibility
    String checkBonusEligibility() {
        return (monthlySalary >= 30000) ? "Eligible" : "Not Eligible";
    }

    // Display employee details
    void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: ₹" + monthlySalary);
        System.out.println("Annual Salary: ₹" + calculateAnnualSalary());
        System.out.println("Bonus: ₹" + calculateBonus());
        System.out.println("Bonus Eligibility: " + checkBonusEligibility());
        System.out.println();
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[5];

        // Input details of 5 employees
        for (int i = 0; i < 5; i++) {

            System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("Employee ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Monthly Salary: ");
            double salary = sc.nextDouble();

            employees[i] = new Employee(id, name, salary);

            System.out.println();
        }

        // Display details of all employees
        System.out.println("========== EMPLOYEE DETAILS ==========");

        for (int i = 0; i < 5; i++) {
            employees[i].displayDetails();
        }

        sc.close();
    }
}