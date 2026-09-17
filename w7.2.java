class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private double consultationFee;

    Doctor(int doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    int getDoctorId() {
        return doctorId;
    }

    String getName() {
        return name;
    }

    String getSpecialization() {
        return specialization;
    }

    double getConsultationFee() {
        return consultationFee;
    }

    void display() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Doctor Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: " + consultationFee);
    }
}

class Patient {
    private int patientId;
    private String name;
    private String disease;
    private int age;

    Patient(int patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    int getPatientId() {
        return patientId;
    }

    String getName() {
        return name;
    }

    String getDisease() {
        return disease;
    }

    int getAge() {
        return age;
    }

    void display() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + name);
        System.out.println("Disease: " + disease);
        System.out.println("Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Doctor d1 = new Doctor(101, "Dr. Ravi", "Cardiologist", 1000);
        Doctor d2 = new Doctor(102, "Dr. Priya", "Dermatologist", 800);

        Patient p1 = new Patient(201, "Arun", "Heart Problem", 45);
        Patient p2 = new Patient(202, "Meena", "Skin Allergy", 30);
        Patient p3 = new Patient(203, "Kiran", "Heart Problem", 50);

        System.out.println("Patient 1 Details");
        p1.display();
        System.out.println("Treating Doctor");
        d1.display();

        System.out.println();

        System.out.println("Patient 2 Details");
        p2.display();
        System.out.println("Treating Doctor");
        d2.display();

        System.out.println();

        System.out.println("Patient 3 Details");
        p3.display();
        System.out.println("Treating Doctor");
        d1.display();

        System.out.println();

        int count1 = 2;
        int count2 = 1;

        double total1 = count1 * d1.getConsultationFee();
        double total2 = count2 * d2.getConsultationFee();

        System.out.println("Total Fee Collected by Dr. Ravi: " + total1);
        System.out.println("Total Fee Collected by Dr. Priya: " + total2);
    }
}