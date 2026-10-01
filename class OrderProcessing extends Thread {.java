class OrderProcessing extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Processing customer orders...");
    }
}

class DeliveryTracking extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Tracking delivery location...");
    }
}

class Notification extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Sending order status notification...");
    }
}

public class FoodDelivery {
    public static void main(String[] args) {

        OrderProcessing order = new OrderProcessing();
        DeliveryTracking delivery = new DeliveryTracking();
        Notification notification = new Notification();

        order.setName("OrderProcessing");
        delivery.setName("DeliveryTracking");
        notification.setName("Notification");

        order.setPriority(10);
        delivery.setPriority(5);
        notification.setPriority(1);

        order.start();
        delivery.start();
        notification.start();
    }
}