import java.util.Scanner;

// Interface
interface Payment {
    void makePayment(double amount);
}

// UPI payment
class UPI implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Payment of ₹" + amount + " made using UPI.");
    }
}

// Credit Card payment
class CreditCard implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Payment of ₹" + amount + " made using Credit Card.");
    }
}

// Net Banking payment
class NetBanking implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Payment of ₹" + amount + " made using Net Banking.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Net Banking");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter payment amount: ₹");
        double amount = sc.nextDouble();

        // Polymorphism
        Payment payment;

        switch (choice) {
            case 1:
                payment = new UPI();
                break;

            case 2:
                payment = new CreditCard();
                break;

            case 3:
                payment = new NetBanking();
                break;

            default:
                System.out.println("Invalid payment method.");
                sc.close();
                return;
        }

        // Same method, different implementation
        payment.makePayment(amount);

        sc.close();
    }
}