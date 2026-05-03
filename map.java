import java.util.HashMap;
import java.util.Map;

public class OOPSBannerApp {

    // Method to initialize character patterns
    public static Map<Character, String[]> createPatternMap() {

        Map<Character, String[]> patternMap = new HashMap<>();

        // Pattern for 'O'
        patternMap.put('O', new String[]{
            " *** ",
            "*   *",
            "*   *",
            "*   *",
            " *** "
        });

        // Pattern for 'P'
        patternMap.put('P', new String[]{
            "**** ",
            "*   *",
            "**** ",
            "*    ",
            "*    "
        });

        // Pattern for 'S'
        patternMap.put('S', new String[]{
            " ****",
            "*    ",
            " *** ",
            "    *",
            "**** "
        });

        return patternMap;
    }

    // Method to print banner word
    public static void printBanner(String word, Map<Character, String[]> patternMap) {

        int rows = 5; // each character has 5 rows

        for (int i = 0; i < rows; i++) { // row loop

            for (int j = 0; j < word.length(); j++) { // character loop

                char ch = word.charAt(j);

                // Get pattern from HashMap
                String[] pattern = patternMap.get(ch);

                if (pattern != null) {
                    System.out.print(pattern[i] + "  ");
                } else {
                    System.out.print("????  "); // fallback
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        try {
            // Create pattern map
            Map<Character, String[]> patternMap = createPatternMap();

            // Word to display
            String word = "OOPS";

            // Print banner
            printBanner(word, patternMap);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}