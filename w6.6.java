// Online Banking System

// Parent class
class Account {
    String accountNumber;
    String holderName;
    double balance;

    Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: Rs." + balance);
    }
}

// Savings Account
class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String accountNumber, String holderName,
                   double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayDetails() {
        System.out.println("Savings Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: Rs." + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Current Account
class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(String accountNumber, String holderName,
                   double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void displayDetails() {
        System.out.println("Current Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: Rs." + balance);
        System.out.println("Overdraft Limit: Rs." + overdraftLimit);
    }
}

// Payment interface
interface Payment {
    void pay(double amount);
}

// Tagging interface
interface OnlineTransaction {
}

// SecurePayment extends Payment
interface SecurePayment extends Payment {
    void verifyPayment();
}

// UPI Payment implements SecurePayment and OnlineTransaction
class UPIPayment implements SecurePayment, OnlineTransaction {

    @Override
    public void pay(double amount) {
        System.out.println("UPI Payment of Rs." + amount + " successful.");
    }

    @Override
    public void verifyPayment() {
        System.out.println("UPI Payment verified successfully.");
    }
}

// Card Payment implements Payment and OnlineTransaction
class CardPayment implements Payment, OnlineTransaction {

    @Override
    public void pay(double amount) {
        System.out.println("Card Payment of Rs." + amount + " successful.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Runtime Polymorphism using Account reference
        Account account;

        account = new SavingsAccount(
            "SA101", "Rahul", 50000, 6.5
        );
        account.displayDetails();

        System.out.println();

        account = new CurrentAccount(
            "CA202", "Priya", 75000, 20000
        );
        account.displayDetails();

        System.out.println("\n-------------------------\n");

        // Payment using Payment reference
        Payment payment;

        // UPI Payment
        payment = new UPIPayment();

        if (payment instanceof OnlineTransaction) {
            System.out.println("UPI is an online transaction.");
        }

        payment.pay(5000);

        // Verify UPI payment
        if (payment instanceof SecurePayment) {
            SecurePayment secure = (SecurePayment) payment;
            secure.verifyPayment();
        }

        System.out.println();

        // Card Payment
        payment = new CardPayment();

        if (payment instanceof OnlineTransaction) {
            System.out.println("Card is an online transaction.");
        }

        payment.pay(10000);
    }
}