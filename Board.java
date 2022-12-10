import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Board {
    public int[][] board;
    private static final int EMPTY = -1;
    private static final int O = 0;
    private static final int X = 1;
    private static final int Y = 2;
    public int account = 9;

    Board(int column, int row) {

        this.board = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                this.board[r][c] = EMPTY;
            }
        }

    }

    public Board() {
    }

    private String printLetter(int con) {
        if (con == EMPTY) {
            return " ";
        } else if (con == O) {
            return "O";
        } else if (con == Y) {
            return "Y";
        } else {
            return "X";
        }
    }

    public void print() {
        int row = this.board.length;
        int column = this.board[0].length;

        System.out.println("|---|---|---|");
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.print("| " + printLetter(this.board[r][c]) + " ");
            }
            System.out.println("|");
        }
        System.out.println("|---|---|---|");
    }

    public void play(int x, int y, int type) {
        if (this.board[x][y] == EMPTY) {
            this.board[x][y] = type;
            this.print();
            account--;
        }
    }

    public String checkWinner() {

        for (int i = 0; i < board.length; i++) {
            int prevPlay = board[i][0];
            if ((board[i][0] == X && board[i][1] == X && board[i][2] == X) ||
                    (board[i][0] == O && board[i][1] == O && board[i][2] == O)) {
                return printLetter(prevPlay);
            }
        }
        for (int i = 0; i < board.length; i++) {
            int prevPlay = board[0][i];
            if ((board[0][i] == X && board[1][i] == X && board[2][i] == X) ||
                    (board[0][i] == O && board[1][i] == O && board[2][i] == O)) {
                return printLetter(prevPlay);
            }
        }

        if ((board[0][0] == X && board[1][1] == X && board[2][2] == X) || (board[0][2] == X && board[1][1] == X && board[2][0] == X)) {
            return printLetter(X);
        }
        if ((board[0][0] == O && board[1][1] == O && board[2][2] == O) || (board[0][2] == O && board[1][1] == O && board[2][0] == O)) {
            return printLetter(O);
        }
        if (this.account <= 0) {
            System.out.println("Berabere!");
            return printLetter(Y);
        }
        return " ";
    }

    public boolean isEmpty(int row, int colum) {

        if (row < board.length && colum < board.length && 0 <= row && 0 <= colum && board[row][colum] == EMPTY)
            return true;
        return false;
    }

}
