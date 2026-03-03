public class UC5 {
    public static void main(String[] args) {

        // Array Declaration + Initialization + String.join() in ONE STEP
        String[] bannerLines = {
            String.join("", "*", "*", "*", "*", "*", "*", "*"),
            String.join("", "*", " ", " ", " ", " ", " ", "*"),
            String.join("", "*", " ", "U", "C", "5", " ", "*"),
            String.join("", "*", " ", "-", "-", "-", " ", "*"),
            String.join("", "*", " ", "J", "A", "V", "A", "*"),
            String.join("", "*", " ", " ", " ", " ", " ", "*"),
            String.join("", "*", "*", "*", "*", "*", "*", "*")
        };

        // Enhanced For Loop to print banner
        for (String line : bannerLines) {
            System.out.println(line);
        }
    }
}