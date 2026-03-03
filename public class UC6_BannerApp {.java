public class UC6_BannerApp {

    public static void main(String[] args) {

        // Build banner by calling static helper functions
        String[] banner = {
            getO(),   // O
            getP(),   // P
            getP(),   // P
            getS()    // S
        };

        // Print final banner
        for (int line = 0; line < 7; line++) {   // All letters have 7 lines
            for (String letterPattern : banner) {
                String[] lines = letterPattern.split("\n");
                System.out.print(lines[line] + "   "); // spacing between letters
            }
            System.out.println();
        }
    }

    // -------------------- STATIC HELPER METHODS --------------------

    public static String getO() {
        return
            " ***** \n" +
            "*     *\n" +
            "*     *\n" +
            "*     *\n" +
            "*     *\n" +
            "*     *\n" +
            " ***** ";
    }

    public static String getP() {
        return
            "***** \n" +
            "*    *\n" +
            "*    *\n" +
            "***** \n" +
            "*     \n" +
            "*     \n" +
            "*     ";
    }

    public static String getS() {
        return
            " *****\n" +
            "*     \n" +
            "*     \n" +
            " *****\n" +
            "     *\n" +
            "     *\n" +
            "***** ";
    }
}