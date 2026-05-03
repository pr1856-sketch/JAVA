public class GreetingApp {

    // Method to build greeting message
    public static String buildGreeting(String[] names) {

        // Default case
        if (names.length == 0) {
            return "Hello World!";
        }

        String result = "Hello ";

        // Process multiple names
        for (int i = 0; i < names.length; i++) {
            result += names[i];

            // Add comma if not last element
            if (i < names.length - 1) {
                result += ", ";
            }
        }

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