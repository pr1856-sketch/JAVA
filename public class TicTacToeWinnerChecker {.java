public class TicTacToeWinnerChecker {

    // Method to check if a player has won
    public static boolean checkWinner(char[][] board, char playerSymbol) {

        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == playerSymbol &&
                board[row][1] == playerSymbol &&
                board[row][2] == playerSymbol) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == playerSymbol &&
                board[1][col] == playerSymbol &&
                board[2][col] == playerSymbol) {
                return true;
            }
        }

        // Check main diagonal
        if (board[0][0] == playerSymbol &&
            board[1][1] == playerSymbol &&
            board[2][2] == playerSymbol) {
            return true;
        }

        // Check anti-diagonal
        if (board[0][2] == playerSymbol &&
            board[1][1] == playerSymbol &&
            board[2][0] == playerSymbol) {
            return true;
        }

        return false;
    }

    // Main method for testing
    public static void main(String[] args) {

        // Example board (Player 'X' wins)
        char[][] board = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', 'X', 'X'}
        };

        char currentPlayer = 'X';

        if (checkWinner(board, currentPlayer)) {
            System.out.println("Player " + currentPlayer + " WINS!");
        } else {
            System.out.println("No winner yet.");
        }
    }
}