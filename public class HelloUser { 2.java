public class HelloUser {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello " + args[0]);
        } else {
            System.out.println("Please provide your name as a command-line argument.");
        }
    }
}