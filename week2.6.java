class Employee {
    // Data members
    String name;
    int id;
    String department;

    // Method to display employee details
    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Department: " + department);
    }

    public static void main(String[] args) {
        // Create first employee object
        Employee e1 = new Employee();
        e1.name = "Rahul";
        e1.id = 101;
        e1.department = "HR";

        // Create second employee object
        Employee e2 = new Employee();
        e2.name = "Priya";
        e2.id = 102;
        e2.department = "Finance";

        // Display details of both employees
        System.out.println("Employee 1 Details");
        e1.display();

        System.out.println();

        System.out.println("Employee 2 Details");
        e2.display();
    }
}