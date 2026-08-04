class Student {
    // Data members
    String name;
    int rollNumber;

    // Method to display student details
    void display() {
        System.out.println("Student Details");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }

    public static void main(String[] args) {
        // Create object
        Student s1 = new Student();

        // Store student details
        s1.name = "Puspita Roy";
        s1.rollNumber = 101;

        // Call display method
        s1.display();
    }
}    
}
