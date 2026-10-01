import java.util.Scanner;

class Patient {
    String patientName;
    double consultationFee;

    // Parameterized constructor
    Patient(String patientName, double consultationFee) {
        this.patientName = patientName;
        this.consultationFee = consultationFee;
    }

    // Method with argument to calculate final amount
    double calculateFinalAmount(double fee) {
        double discount;

        if (fee >= 2000) {
            discount = fee * 0.10;
        } else {
            discount = fee * 0.05;
        }

        return fee - discount;
    }

    // Method to display details
    void display() {
        double finalAmount = calculateFinalAmount(consultationFee);
        double discount = consultationFee - finalAmount;

        System.out.println("Patient Name: " + patientName);
        System.out.println("Original Consultation Fee: ₹" + consultationFee);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Amount: ₹" + finalAmount);
        System.out.println();
    }
}

public class HospitalBillingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Patient[] patients = new Patient[5];

        // Input details of 5 patients
        for (int i = 0; i < 5; i++) {

            System.out.println("Enter details for Patient " + (i + 1));

            System.out.print("Patient Name: ");
            String name = sc.nextLine();

            System.out.print("Consultation Fee: ");
            double fee = sc.nextDouble();
            sc.nextLine();

            // Create Patient object
            patients[i] = new Patient(name, fee);

            System.out.println();
        }

        // Display details of all patients
        System.out.println("========== CONSULTATION BILL ==========");

        for (int i = 0; i < 5; i++) {
            patients[i].display();
        }

        sc.close();
    }
}