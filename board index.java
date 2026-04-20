import java.util.Scanner;

public class TicTacToeSlotMapping {

    // Method to convert slot number into row and column
    public static int[] getRowCol(int slot) {
        int row = (slot - 1) / 3;   // Row index
        int col = (slot - 1) % 3;   // Column index

        return new int[]{row, col};
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter slot number (1-9): ");
        int slot = scanner.nextInt();

        int[] position = getRowCol(slot);

        System.out.println("Row Index: " + position[0]);
        System.out.println("Column Index: " + position[1]);
    }
}
