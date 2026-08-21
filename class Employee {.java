class Employee {
    String name;
    int employeeId;
    double basicSalary;

    // Constructor
    Employee(String name, int employeeId, double basicSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
    }

    // Method to be overridden
    double calculateSalary() {
        return basicSalary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: $" + calculateSalary());
        System.out.println();
    }
}

// Child class: Professor
class Professor extends Employee {

    Professor(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + 5000;
    }
}

// Child class: LabAssistant
class LabAssistant extends Employee {

    LabAssistant(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + 2000;
    }
}

// Child class: AdministrativeStaff
class AdministrativeStaff extends Employee {

    AdministrativeStaff(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + 3000;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Professor professor =
                new Professor("Dr. John", 101, 50000);

        LabAssistant labAssistant =
                new LabAssistant("Alice", 102, 30000);

        AdministrativeStaff staff =
                new AdministrativeStaff("Bob", 103, 35000);

        // Display salary details
        professor.displayDetails();
        labAssistant.displayDetails();
        staff.displayDetails();
    }
}