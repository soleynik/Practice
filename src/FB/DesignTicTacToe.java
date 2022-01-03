package FB;
/*
348. Design Tic-Tac-Toe

Assume the following rules are for the tic-tac-toe game on an n x n board between two players:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves are allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Implement the TicTacToe class:

TicTacToe(int n) Initializes the object the size of the board n.
int move(int row, int col, int player) Indicates that the player with id player plays at the cell (row, col) of the board. The move is guaranteed to be a valid move.
 */

public class DesignTicTacToe {

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    DesignTicTacToe(int n){
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int r, int c, int player){
        int toAdd = (player == 1)? 1:-1;
        rows[r] = toAdd;
        cols[c] = toAdd;
        if(r == c)
            diagonal += toAdd;
        if(c == (cols.length - r - 1))
            antiDiagonal += toAdd;
        int size = rows.length;
        if(Math.abs(rows[r]) == size ||
           Math.abs(cols[c]) == size ||
           Math.abs(diagonal) == size ||
           Math.abs(antiDiagonal) == size)
            return player;
        return 0;
    }
}
