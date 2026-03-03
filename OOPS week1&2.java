import java.util.Scanner;

public class CombinedPracticeProgram {

    public static void main(String[] args) {

        // -------------------------------
        // Taking User Input
        // -------------------------------
        Scanner input = new Scanner(System.in);

        // LEVEL 1 – 4 Problems
        // 1. Add two numbers
        System.out.println("Enter two numbers to add:");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double sum = num1 + num2;

        // 2. Area of a Rectangle
        System.out.println("Enter length and width of rectangle:");
        double length = input.nextDouble();
        double width = input.nextDouble();
        double areaRectangle = length * width;

        // 3. Celsius to Fahrenheit Conversion
        System.out.println("Enter temperature in Celsius:");
        double celsius = input.nextDouble();
        double fahrenheit = (celsius * 9 / 5) + 32;

        // 4. Simple Interest Calculation
        System.out.println("Enter Principal, Rate, and Time:");
        double principal = input.nextDouble();
        double rate = input.nextDouble();
        double time = input.nextDouble();
        double simpleInterest = (principal * rate * time) / 100;

        // -------------------------------
        // LEVEL 2 – 3 Problems
        // 1. BMI Calculation
        System.out.println("Enter weight (kg) and height (meters):");
        double weight = input.nextDouble();
        double height = input.nextDouble();
        double bmi = weight / (height * height);

        // 2. Minutes to Hours Conversion (Type Conversion)
        System.out.println("Enter minutes:");
        int minutes = input.nextInt();
        double hours = minutes / 60.0;

        // 3. Distance Calculation using Speed * Time
        System.out.println("Enter speed and time:");
        double speed = input.nextDouble();
        double travelTime = input.nextDouble();
        double distanceTravelled = speed * travelTime;

        // -------------------------------
        // LEVEL 3 – 2 Problems
        // 1. Operator Precedence Example: (a + b * c) / d
        System.out.println("Enter values for a, b, c, d:");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double precedenceResult = (a + b * c) / d;

        // 2. Type Casting Example
        System.out.println("Enter a decimal number to convert into integer:");
        double decimalValue = input.nextDouble();
        int integerValue = (int) decimalValue;

        // -------------------------------
        // OUTPUT SECTION
        // -------------------------------
        System.out.println("\n--------- RESULTS ---------");
        System.out.println("Sum = " + sum);
        System.out.println("Area of Rectangle = " + areaRectangle);
        System.out.println("Fahrenheit = " + fahrenheit);
        System.out.println("Simple Interest = " + simpleInterest);
        System.out.println("BMI = " + bmi);
        System.out.println("Hours = " + hours);
        System.out.println("Distance Travelled = " + distanceTravelled);
        System.out.println("Operator Precedence Result = " + precedenceResult);
        System.out.println("Converted Integer Value = " + integerValue);

        input.close();
    }
}