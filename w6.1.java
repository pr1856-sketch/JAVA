// Parent class
class Vehicle {
    String vehicleNumber;
    String brand;
    double speed;

    // Constructor
    Vehicle(String vehicleNumber, String brand, double speed) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    // Method to display vehicle details
    void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
    }
}

// Child class Car
class Car extends Vehicle {
    int numberOfDoors;

    Car(String vehicleNumber, String brand, double speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    // Overriding displayDetails()
    @Override
    void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

// Child class Bike
class Bike extends Vehicle {
    boolean hasGear;

    Bike(String vehicleNumber, String brand, double speed, boolean hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    // Overriding displayDetails()
    @Override
    void displayDetails() {
        System.out.println("Bike Details:");
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Has Gear: " + hasGear);
    }
}

// Main class
public class VehicleRental {
    public static void main(String[] args) {

        // Runtime polymorphism
        Vehicle vehicle;

        // Vehicle reference referring to Car object
        vehicle = new Car("CAR101", "Toyota", 180, 4);
        vehicle.displayDetails();

        System.out.println();

        // Same Vehicle reference referring to Bike object
        vehicle = new Bike("BIKE202", "Yamaha", 120, true);
        vehicle.displayDetails();
    }
}