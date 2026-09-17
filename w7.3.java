class ExamTask implements Runnable {
    private String activity;

    ExamTask(String activity) {
        this.activity = activity;
    }

    public void run() {
        String name = Thread.currentThread().getName();

        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " - " + activity);

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
        Thread t1 = new Thread(new ExamTask("Displaying remaining time"));
        Thread t2 = new Thread(new ExamTask("Auto-saving student answers"));
        Thread t3 = new Thread(new ExamTask("Checking network connection"));

        t1.setName("Time Thread");
        t2.setName("Auto-Save Thread");
        t3.setName("Network Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}