import java.util.Scanner;

// Custom Exception
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class StringAnalyzer {

    // Method to count vowels
    public static int countVowels(String input) {
        int count = 0;
        String lower = input.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    // Method to reverse string
    public static String reverseString(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }

    // Method to print ASCII values
    public static void printASCII(String input) {
        System.out.println("\nASCII Values:");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            System.out.println(ch + " = " + (int) ch);
        }
    }

    // Method to count words
    public static int countWords(String input) {
        if (input.trim().isEmpty()) {
            return 0;
        }
        String[] words = input.trim().split("\\s+");
        return words.length;
    }

    // Method to validate input
    public static void validateInput(String input) throws InvalidInputException {
        if (input.length() < 3) {
            throw new InvalidInputException("Input must be at least 3 characters long.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking input
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Validate input
            validateInput(input);

            // Using methods
            System.out.println("\n--- String Analysis ---");
            System.out.println("Original String: " + input);
            System.out.println("Length: " + input.length());
            System.out.println("Uppercase: " + input.toUpperCase());
            System.out.println("Reversed: " + reverseString(input));
            System.out.println("Vowel Count: " + countVowels(input));
            System.out.println("Word Count: " + countWords(input));

            // ASCII values
            printASCII(input);

            // Escape sequence demo
            System.out.println("\nEscape Sequence Demo:");
            System.out.println("Hello \"Java\" \nNew Line Example");

        } catch (InvalidInputException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}