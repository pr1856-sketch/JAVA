public class HelloWorld {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Hello, World!");
        } else {
            String names = String.join(", ", args);
            System.out.println("Hello, " + names + "!");
        }
    }
}  
