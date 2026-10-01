import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int[] marks = new int[3];
    double attendance;

    Student(int rollNo, String name, int[] marks, double attendance) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.attendance = attendance;
    }

    void display() {
        int total = 0;

        // Calculate total using for loop
        for (int i = 0; i < 3; i++) {
            total += marks[i];
        }

        double average = total / 3.0;

        String result = (average >= 50) ? "Pass" : "Fail";

        String scholarship = (average >= 75 && attendance >= 80)
                ? "Eligible" : "Not Eligible";

        String performance = (average >= 85) ? "Excellent" : "Good";

        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Result: " + result);
        System.out.println("Scholarship: " + scholarship);
        System.out.println("Performance: " + performance);
        System.out.println("Attendance: " + attendance + "%");
        System.out.println();
    }

    double getAverage() {
        int total = 0;

        for (int i = 0; i < 3; i++) {
            total += marks[i];
        }

        return total / 3.0;
    }
}

public class StudentPerformanceManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[5];

        // Input details of 5 students
        for (int i = 0; i < 5; i++) {

            System.out.println("Enter details for Student " + (i + 1));

            System.out.print("Roll Number: ");
            int rollNo = sc.nextInt();

            sc.nextLine();

            System.out.print("Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];

            for (int j = 0; j < 3; j++) {
                System.out.print("Marks in Subject " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }

            System.out.print("Attendance Percentage: ");
            double attendance = sc.nextDouble();

            students[i] = new Student(rollNo, name, marks, attendance);

            System.out.println();
        }

        // Display student details
        System.out.println("========== STUDENT PERFORMANCE ==========");

        for (int i = 0; i < 5; i++) {
            students[i].display();
        }

        // Find student with highest average
        Student highest = students[0];

        for (int i = 1; i < 5; i++) {
            if (students[i].getAverage() > highest.getAverage()) {
                highest = students[i];
            }
        }

        System.out.println("========== HIGHEST AVERAGE ==========");
        System.out.println("Roll Number: " + highest.rollNo);
        System.out.println("Name: " + highest.name);
        System.out.println("Average Marks: " + highest.getAverage());

        sc.close();
    }
}