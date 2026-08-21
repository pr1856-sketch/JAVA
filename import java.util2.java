import java.util.Scanner;

// Abstract base class representing a general Shape
abstract class Shape {
    // Abstract method to calculate the area of the shape
    public abstract double calculateArea();
}

// Subclass representing a Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Subclass representing a Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Subclass representing a Triangle
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Main class to demonstrate execution with user input
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get dimensions for Circle
        System.out.print("Enter radius of the Circle: ");
        double radius = scanner.nextDouble();

        // Get dimensions for Rectangle
        System.out.print("Enter length of the Rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width of the Rectangle: ");
        double width = scanner.nextDouble();

        // Get dimensions for Triangle
        System.out.print("Enter base of the Triangle: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height of the Triangle: ");
        double height = scanner.nextDouble();

        // Array storing different subclass instances using polymorphism
        Shape[] shapes = new Shape[] {
            new Circle(radius),
            new Rectangle(length, width),
            new Triangle(base, height)
        };

        System.out.println("\n--- Calculated Areas (using Polymorphism) ---");
        
        // Polymorphic call: dynamically invokes the appropriate calculateArea() for each shape
        for (Shape shape : shapes) {
            String shapeName = shape.getClass().getSimpleName();
            System.out.printf("Area of %-10s: %.2f%n", shapeName, shape.calculateArea());
        }

        scanner.close();
    }
}