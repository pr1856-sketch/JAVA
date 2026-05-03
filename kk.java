public class GreetingApp {

    // Method to build greeting
    public static String buildGreeting(String[] args) {

        String name;

        // If argument provided → use it
        if (args.length > 0) {
            name = args[0];
        } 
        // Else → default
        else {
            name = "World";
        }

        return "Hello " + name + "!";
    }

    public static void main(String[] args) {
        try {
            String message = buildGreeting(args);
            System.out.println(message);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}