import java.util.Scanner;

public class AttendanceRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] attendance = new int[7];
        int presentDays = 0;

        // Read attendance for 7 days
        for (int i = 0; i < 7; i++) {
            attendance[i] = sc.nextInt();
        }

        // Count present days
        for (int i = 0; i < 7; i++) {
            if (attendance[i] == 1) {
                presentDays++;
            }
        }

        // Calculate attendance percentage
        double percentage = (presentDays * 100.0) / 7;

        System.out.println("Present Days : " + presentDays);

        // Check exam eligibility
        if (percentage >= 75) {
            System.out.println("Eligible for Exam");
        } else {
            System.out.println("Not Eligible");
        }

        sc.close();
    }
}