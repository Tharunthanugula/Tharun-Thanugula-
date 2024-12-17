import java.util.Scanner;

public class TicTacToe {

    
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final char EMPTY = ' ';

    
    private static char[][] board = {
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
    };

    
    private static char currentPlayer = PLAYER_X;

    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean gameFinished = false;

        printBoard();

        while (!gameFinished) {
            
            int[] move = getPlayerMove();

            
            board[move[0]][move[1]] = currentPlayer;

            
            printBoard();

            
            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins! Congratulations!");
                gameFinished = true;
            } else if (isBoardFull()) {
                System.out.println("It's a tie! The board is full.");
                gameFinished = true;
            } else {
                
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }

        
        scanner.close();
    }

    
    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    
    private static int[] getPlayerMove() {
        int[] move = new int[2];
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
                move[0] = row;
                move[1] = col;
                validInput = true;
            } else {
                System.out.println("Invalid move. Please try again.");
            }

            scanner.nextLine();
        }

        return move;
    }

    
    private static boolean checkWin() {
        
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    
    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    
    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    
    private static boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
