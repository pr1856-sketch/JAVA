import java.util.ArrayList;
import java.util.List;

public class OOPSBannerApp {

    // Static inner class to encapsulate character + pattern
    static class CharacterPattern {
        private char character;
        private String[] pattern;

        // Constructor
        public CharacterPattern(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        // Getter for character
        public char getCharacter() {
            return character;
        }

        // Getter for pattern
        public String[] getPattern() {
            return pattern;
        }
    }

    // Method to create pattern list
    public static List<CharacterPattern> createPatterns() {

        List<CharacterPattern> patterns = new ArrayList<>();

        patterns.add(new CharacterPattern('O', new String[]{
            " *** ",
            "*   *",
            "*   *",
            "*   *",
            " *** "
        }));

        patterns.add(new CharacterPattern('P', new String[]{
            "**** ",
            "*   *",
            "**** ",
            "*    ",
            "*    "
        }));

        patterns.add(new CharacterPattern('S', new String[]{
            " ****",
            "*    ",
            " *** ",
            "    *",
            "**** "
        }));

        return patterns;
    }

    // Method to find pattern using linear search
    public static String[] getPattern(char ch, List<CharacterPattern> patterns) {

        for (CharacterPattern cp : patterns) {
            if (cp.getCharacter() == ch) {
                return cp.getPattern();
            }
        }
        return null; // if not found
    }

    // Method to print banner
    public static void printBanner(String word, List<CharacterPattern> patterns) {

        int rows = 5;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < word.length(); j++) {

                char ch = word.charAt(j);
                String[] pattern = getPattern(ch, patterns);

                if (pattern != null) {
                    System.out.print(pattern[i] + "  ");
                } else {
                    System.out.print("????  ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        try {
            List<CharacterPattern> patterns = createPatterns();

            String word = "OOPS";

            printBanner(word, patterns);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}