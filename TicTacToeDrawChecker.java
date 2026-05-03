public class TicTacToeDrawChecker {

    // Method to check if board is full
    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') { // empty cell
                    return false;
                }
            }
        }
        return true;
    }

    // Method to check winner
    public static boolean hasWinner(char[][] board) {

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return true;
            }

            if (board[0][i] != ' ' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    // Method to detect draw
    public static boolean isDraw(char[][] board) {
        boolean boardFull = isBoardFull(board);
        boolean winnerExists = hasWinner(board);

        return boardFull && !winnerExists;
    }

    // Main method for testing
    public static void main(String[] args) {

        // Example board (Draw case)
        char[][] board = {
            {'X', 'O', 'X'},
            {'X', 'O', 'O'},
            {'O', 'X', 'X'}
        };

        if (isDraw(board)) {
            System.out.println("Game is a DRAW.");
        } else {
            System.out.println("Game is NOT a draw.");
        }
    }
}