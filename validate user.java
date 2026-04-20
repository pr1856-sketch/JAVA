public class TicTacToeValidation {

    // Method to check whether move is valid
    public static boolean isValidMove(char[][] board, int row, int col) {

        // Check row and column bounds
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        // Create board
        char[][] board = {
                {'X', '-', 'O'},
                {'-', '-', '-'},
                {'O', 'X', '-'}
        };

        int row = 1;
        int col = 1;

        // Validate move
        if (isValidMove(board, row, col)) {
            System.out.println("Valid Move");
        } else {
            System.out.println("Invalid Move");
        }
    }
}
