public class TicTacToeUC6 {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void main(String[] args) {

        // Human move
        makeMove(1, 'X');

        // Computer move
        makeMove(5, 'O');

        // Display board
        printBoard();
    }

    // Update board with symbol
    static void makeMove(int slot, char symbol) {

        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        if (board[row][col] == ' ') {
            board[row][col] = symbol;
            System.out.println("Move placed successfully.");
        } else {
            System.out.println("Cell already occupied.");
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
