import java.util.Scanner;

public class TicTacToeInput {

    // Method to read slot number
    public static int getSlotInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter slot number (1-9): ");
        int slot = scanner.nextInt();

        return slot;
    }

    public static void main(String[] args) {

        // Call method and store returned slot value
        int userSlot = getSlotInput();

        System.out.println("Selected Slot: " + userSlot);
    }
}
