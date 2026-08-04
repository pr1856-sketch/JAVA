class Temperature {
    // Data member
    double celsius;

    // Method to convert and display temperature
    void displayTemperature() {
        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println("Temperature in Celsius: " + celsius);
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }

    public static void main(String[] args) {
        // Create object
        Temperature t1 = new Temperature();

        // Store temperature in Celsius
        t1.celsius = 30;

        // Display Celsius and Fahrenheit
        t1.displayTemperature();
    }
}