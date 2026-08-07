import java.util.Scanner;

class Area {

    // Area of Square
    void calculateArea(int side) {
        System.out.println("Area of Square : " + (side * side));
    }

    // Area of Rectangle
    void calculateArea(int length, int breadth) {
        System.out.println("Area of Rectangle : " + (length * breadth));
    }

    // Area of Circle
    void calculateArea(double radius) {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle : " + area);
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Area obj = new Area();

        // Input
        int side = sc.nextInt();
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        double radius = sc.nextDouble();

        // Method Calls
        obj.calculateArea(side);
        obj.calculateArea(length, breadth);
        obj.calculateArea(radius);

        sc.close();
    }
}