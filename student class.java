public class Main {

    public static void main(String[] args) {

        // 1. Student Class
        System.out.println("1. Student Result");
        Student s1 = new Student();
        Student s2 = new Student();

        s1.setDetails("Rahul", 75);
        s2.setDetails("Priya", 35);

        s1.displayDetails();
        System.out.println("Result: " + s1.getResult());

        s2.displayDetails();
        System.out.println("Result: " + s2.getResult());

        // 2. Calculator Method Overloading
        System.out.println("\n2. Calculator");
        Calculator c = new Calculator();

        System.out.println("Add 2 Integers: " + c.add(10, 20));
        System.out.println("Add 3 Integers: " + c.add(10, 20, 30));
        System.out.println("Add 2 Doubles: " + c.add(5.5, 4.5));

        // 3. Product Highest Price
        System.out.println("\n3. Highest Price Product");

        Product[] products = new Product[3];

        products[0] = new Product("Laptop", 55000);
        products[1] = new Product("Mobile", 25000);
        products[2] = new Product("TV", 45000);

        Product highest = products[0];

        for (int i = 1; i < products.length; i++) {
            if (products[i].price > highest.price) {
                highest = products[i];
            }
        }

        System.out.println("Highest Price Product: " + highest.name + " - " + highest.price);

        // 4. Palindrome Check
        System.out.println("\n4. Palindrome Check");

        String str = "madam";
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        if (str.equals(rev)) {
            System.out.println(str + " is Palindrome");
        } else {
            System.out.println(str + " is Not Palindrome");
        }

        // 5. Second Largest Number
        System.out.println("\n5. Second Largest Number");

        int arr[] = {10, 20, 5, 30, 25};

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }

        System.out.println("Second Largest: " + second);
    }
}

// Student Class
class Student {
    String name;
    int marks;

    void setDetails(String n, int m) {
        name = n;
        marks = m;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", Marks: " + marks);
    }

    String getResult() {
        if (marks >= 40)
            return "Pass";
        else
            return "Fail";
    }
}

// Calculator Class
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

// Product Class
class Product {
    String name;
    double price;

    Product(String n, double p) {
        name = n;
        price = p;
    }
}