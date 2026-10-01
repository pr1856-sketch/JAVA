class EmergencyAlert extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Handling critical patient alerts...");
    }
}

class VitalMonitor extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Monitoring vital signs...");
    }
}

class ReportGenerator extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Generating routine reports...");
    }
}

public class HospitalMonitoring {
    public static void main(String[] args) {

        EmergencyAlert emergency = new EmergencyAlert();
        VitalMonitor vital = new VitalMonitor();
        ReportGenerator report = new ReportGenerator();

        emergency.setName("EmergencyAlert");
        vital.setName("VitalMonitor");
        report.setName("ReportGenerator");

        emergency.setPriority(Thread.MAX_PRIORITY);   // 10
        vital.setPriority(Thread.NORM_PRIORITY);      // 5
        report.setPriority(Thread.MIN_PRIORITY);      // 1

        emergency.start();
        vital.start();
        report.start();
    }
}