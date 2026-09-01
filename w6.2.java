
interface Payment {
    void pay(double amount);
}


class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " made using Credit Card.");
    }
}


class UPIPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " made using UPI.");
    }
}


class NetBankingPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " made using Net Banking.");
    }
}


public class OnlineShopping {
    public static void main(String[] args) {

        
        Payment payment;

        
        payment = new CreditCardPayment();
        payment.pay(5000);

        System.out.println();

    
        payment = new UPIPayment();
        payment.pay(2500);

        System.out.println();

        // Net Banking payment
        payment = new NetBankingPayment();
        payment.pay(7500);
    }
}