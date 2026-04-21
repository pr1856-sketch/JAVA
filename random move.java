import java.util.Random;

public class TicTacToeUC7 {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void main(String[] args) {

        // Human move example
        placeMove(5, 'X');

        // Computer move
        computerMove();

        // Display board
        printBoard();
    }

    // Computer random move
    static void computerMove() {
        Random random = new Random();
        boolean validMove = false;

        while (!validMove) {
            int slot = random.nextInt(9) + 1;   // 1 to 9

            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (board[row][col] == ' ') {
                board[row][col] = 'O';
                validMove = true;
                System.out.println("Computer chose slot: " + slot);
            }
        }
    }

    // Human or common move placement
    static void placeMove(int slot, char symbol) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        if (board[row][col] == ' ') {
            board[row][col] = symbol;
        }
    }

    // Print board
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2)
                System.out.println("--+---+--");
        }
    }
}