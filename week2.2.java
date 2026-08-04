class Book {
    // Data members
    String title;
    String author;
    double price;

    public static void main(String[] args) {
        // Create object
        Book b1 = new Book();

        // Store book details
        b1.title = "Java Programming";
        b1.author = "James Gosling";
        b1.price = 599.00;

        // Display book details
        System.out.println("Book Details");
        System.out.println("Title: " + b1.title);
        System.out.println("Author: " + b1.author);
        System.out.println("Price: ₹" + b1.price);
    }
}