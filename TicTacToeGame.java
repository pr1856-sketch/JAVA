import java.util.Scanner;

public class TicTacToeGame {

    // Display board
    public static void printBoard(char[][] board) {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    // Check winner (UC9)
    public static boolean checkWinner(char[][] board, char player) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;

            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    // Check draw (UC10)
    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    // Main Game Loop (UC8)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char currentPlayer = 'X';
        boolean gameOver = false;

        while (!gameOver) {

            printBoard(board);

            System.out.println("Player " + currentPlayer + " turn.");
            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("Enter col (0-2): ");
            int col = scanner.nextInt();

            // Validate move
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            // Place move
            board[row][col] = currentPlayer;

            // Check win
            if (checkWinner(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " WINS!");
                gameOver = true;
            }

            // Check draw
            else if (isDraw(board)) {
                printBoard(board);
                System.out.println("Game is a DRAW.");
                gameOver = true;
            }

            // Switch turn
            else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }
}