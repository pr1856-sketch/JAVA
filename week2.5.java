class Student {
    // Data members
    String name;
    int age;

    // Method to display student details
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Create first student object
        Student s1 = new Student();
        s1.name = "Puspita";
        s1.age = 20;

        // Create second student object
        Student s2 = new Student();
        s2.name = "Rahul";
        s2.age = 21;

        // Display details of both students
        System.out.println("Student 1 Details");
        s1.display();

        System.out.println();

        System.out.println("Student 2 Details");
        s2.display();
    }
}