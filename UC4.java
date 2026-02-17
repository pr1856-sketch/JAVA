public class OOPSBannerUC4 {
    public static void main(String[] args) {

        String[] banner = {
            String.join(" ", " OOO  ", " PPP  ", " SSSS "),
            String.join(" ", "O   O ", " P   P", " S     "),
            String.join(" ", "O   O ", " PPPP  ", "  SSS  "),
            String.join(" ", "O   O ", " P     ", "     S "),
            String.join(" ", " OOO  ", " P     ", " SSSS  ")
        };

        for (String line : banner) {
            System.out.println(line);
        }
    }
}
