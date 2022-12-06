import java.util.Arrays;
import java.util.Scanner;

public class Board {
    public int[][] board;
    private static final int EMPTY = -1;
    private static final int O = 0;
    private static final int X = 1;

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
        }
    }

    public String checkWinner() {
        for(int i=0; i<board.length; i++){
            int prevPlay = board[i][0];
            if(prevPlay == EMPTY)
                continue;
            boolean isWin = true;
            for(int j=0; j<board.length; j++){
                if(prevPlay != board[i][j]){
                    isWin = false;
                }
            }
            if (isWin){
                return printLetter(prevPlay);
            }
        }
        return " ";
    }
    public boolean isEmpty(int row, int colum){
        if(board[row][colum] == EMPTY)
            return true;
        return false;
    }

}
