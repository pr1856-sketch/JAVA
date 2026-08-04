class Marks {
    // Data members
    int subject1;
    int subject2;
    int subject3;

    // Method to calculate and display total and average
    void displayResult() {
        int total = subject1 + subject2 + subject3;
        double average = total / 3.0;

        System.out.println("Subject 1 Marks: " + subject1);
        System.out.println("Subject 2 Marks: " + subject2);
        System.out.println("Subject 3 Marks: " + subject3);
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
    }

    public static void main(String[] args) {
        // Create object
        Marks m1 = new Marks();

        // Store marks
        m1.subject1 = 85;
        m1.subject2 = 90;
        m1.subject3 = 80;

        // Display total and average
        m1.displayResult();
    }
}