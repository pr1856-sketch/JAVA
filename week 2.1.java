class Student {
    // Data members
    String name;
    int rollNumber;
    String department;

    public static void main(String[] args) {
        // Create object
        Student s1 = new Student();

        // Assign values
        s1.name = "Puspita Roy";
        s1.rollNumber = 101;
        s1.department = "Computer Science";

        // Display student details
        System.out.println("Student Details");
        System.out.println("Name: " + s1.name);
        System.out.println("Roll Number: " + s1.rollNumber);
        System.out.println("Department: " + s1.department);
    }
}