public class GreetingApp {

    public static String buildGreeting(String[] names) {

        // If no arguments → default message
        if (names.length == 0) {
            return "Hello, World!";
        }

        String result = "Hello ";

        // Enhanced for loop
        for (String name : names) {
            result += name + ", ";
        }

        // Remove last ", " using substring
        result = result.substring(0, result.length() - 2);

        result += "!";

        return result;
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