package AMZN;
/*
696. Count Binary Substrings

Give a binary string s, return the number of non-empty substrings that have the same
number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.
 */
public class CountBinarySubstrings {
    // O(n) O(1)

    static int countBinarySubstrings(String s) {
        int cur = 1, pre = 0, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, pre);
    }

    public static void main(String[] args) {

        // 6
        String s1 = "00110011";
        System.out.println(countBinarySubstrings(s1));

        // 4
        String s2 = "10101";
        System.out.println(countBinarySubstrings(s2));


    }

}
