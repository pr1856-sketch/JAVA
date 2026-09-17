class BankTask implements Runnable {
    private String activity;

    BankTask(String activity) {
        this.activity = activity;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " - " + activity + " - Count: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new BankTask("Transaction Processing"));
        Thread t2 = new Thread(new BankTask("Balance Updating"));
        Thread t3 = new Thread(new BankTask("SMS Notification"));

        t1.setName("Transaction Thread");
        t2.setName("Balance Thread");
        t3.setName("SMS Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}