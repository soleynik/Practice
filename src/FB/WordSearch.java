package FB;

/*
79. Word Search
Given an m x n grid of characters board and a string word,
return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once.

 */
public class WordSearch {
    // O(N*3^L) O(L)
    static boolean wordSearch(char[][] board, String word) {
        char[] charWord = word.toCharArray();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (wordSearch(board, charWord, r, c, 0))
                    return true;
            }
        }
        return false;
    }

    static boolean wordSearch(char[][] board, char[] charWord, int r, int c, int i) {
        if (i == charWord.length)
            return true;
        if (r < 0 || c < 0 || r == board.length || c == board[r].length)
            return false;
        if(board[r][c] != charWord[i])
            return false;
        board[r][c] ^= 256;
        boolean exist = wordSearch(board, charWord,r+1, c,i+1)
                || wordSearch(board, charWord,r-1, c,i+1)
                || wordSearch(board, charWord,r, c+1,i+1)
                || wordSearch(board, charWord,r, c-1,i+1);
        board[r][c] ^= 256;
        return exist;

    }

    public static void main(String[] args) {

        // true
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F','C','S'},{'A','D','E','E'}};
        String word1 = "ABCCED";
        System.out.println(wordSearch(board1,word1));

        // true
        char[][] board2 = {{'A', 'B', 'C', 'E'}, {'S', 'F','C','S'},{'A','D','E','E'}};
        String word2 = "SEE";
        System.out.println(wordSearch(board2,word2));

        // false
        char[][] board3 = {{'A', 'B', 'C', 'E'}, {'S', 'F','C','S'},{'A','D','E','E'}};
        String word3 = "ABCB";
        System.out.println(wordSearch(board3,word3));

    }
}
