public class GreetingApp {

    // Method to build greeting message
    public static String buildGreeting(String[] names) {

        // If no arguments → default message
        if (names.length == 0) {
            return "Hello, World!";
        }

        String result = "Hello ";

        // Enhanced for loop (for-each)
        for (String name : names) {
            result += name + " ";
        }

        return result.trim() + "!";
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