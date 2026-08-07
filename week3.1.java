import java.util.Scanner;

public class SupermarketBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] prices = new int[5];
        int totalBill = 0;

        // Read prices of 5 products
        for (int i = 0; i < 5; i++) {
            prices[i] = sc.nextInt();
        }

        // Calculate total bill
        for (int i = 0; i < 5; i++) {
            totalBill += prices[i];
        }

        // Display total bill
        System.out.println("Total Bill : " + totalBill);

        // Check discount eligibility
        if (totalBill > 5000) {
            System.out.println("Discount Applicable");
        } else {
            System.out.println("No Discount");
        }

        sc.close();
    }
}