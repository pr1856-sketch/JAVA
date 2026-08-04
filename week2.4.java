class Rectangle {
    // Data members
    double length;
    double breadth;

    // Method to calculate and display area
    void calculateArea() {
        double area = length * breadth;
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
        System.out.println("Area of Rectangle: " + area);
    }

    public static void main(String[] args) {
        // Create object
        Rectangle r1 = new Rectangle();

        // Store length and breadth
        r1.length = 10;
        r1.breadth = 5;

        // Call method
        r1.calculateArea();
    }
}