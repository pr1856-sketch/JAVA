class Junction extends Thread {
    private String trafficStatus;
    private int delay;

    Junction(String name, String trafficStatus, int delay) {
        setName(name);
        this.trafficStatus = trafficStatus;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Traffic Status: " + trafficStatus);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Junction j1 = new Junction("Junction 1", "Heavy Traffic", 1000);
        Junction j2 = new Junction("Junction 2", "Moderate Traffic", 1500);
        Junction j3 = new Junction("Junction 3", "Low Traffic", 2000);

        j1.start();
        j2.start();
        j3.start();
    }
}