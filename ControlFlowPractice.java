import java.util.Scanner;

public class ControlFlowPractice {

    // Method to check number type (if-else + boolean)
    public static void checkNumberType(int number) {

        boolean isPositive = number > 0;
        boolean isZero = number == 0;

        if (isPositive) {
            System.out.println("Number is Positive");
        } else if (isZero) {
            System.out.println("Number is Zero");
        } else {
            System.out.println("Number is Negative");
        }
    }

    // Method to check even/odd using logical operator
    public static void checkEvenOdd(int number) {
        if (number % 2 == 0 && number != 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }

    // Method using for loop and continue
    public static void printNumbersSkipMultiples(int limit) {
        System.out.println("Numbers (skipping multiples of 3):");

        for (int i = 1; i <= limit; i++) {

            if (i % 3 == 0) {
                continue; // skip multiples of 3
            }

            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Method using while loop and break
    public static void countUntilLimit(int limit) {
        int count = 1;

        System.out.println("Counting using while loop:");

        while (true) {
            if (count > limit) {
                break; // stop loop
            }

            System.out.print(count + " ");
            count++;
        }
        System.out.println();
    }

    // Method using switch statement
    public static void showDay(int day) {

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        checkNumberType(number);
        checkEvenOdd(number);

        // Loop operations
        System.out.print("Enter limit for loop: ");
        int limit = scanner.nextInt();

        printNumbersSkipMultiples(limit);
        countUntilLimit(limit);

        // Switch example
        System.out.print("Enter day number (1-7): ");
        int day = scanner.nextInt();

        showDay(day);

        scanner.close();
    }
}