package FB;
/*
        72. Edit Distance

        Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

        You have the following three operations permitted on a word:

        Insert a character
        Delete a character
        Replace a character
 */

public class EditDistance {
    // O(n*m) O(n*m)
    static int editDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = i;
        for (int i = 0; i < m; i++)
            dp[0][i] = i;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        // 3
        System.out.println(editDistance("horse", "ros"));
        // 5
        System.out.println(editDistance("intention", "execution"));
    }
}
