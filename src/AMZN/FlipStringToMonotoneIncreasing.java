package AMZN;
/*
926. Flip String to Monotone Increasing

A binary string is monotone increasing if it consists of some number of 0's (possibly none),
followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.
 */
public class FlipStringToMonotoneIncreasing {
    // O(n) O(1)
    static int minFlipsMonoIncr(String s) {
        int f0 = 0, f1 = 0;
        for (int i = 0; i < s.length(); ++i) {
            f0 += s.charAt(i) - '0';
            f1 = Math.min(f0, f1 + 1 - (s.charAt(i) - '0'));
        }
        return f1;
    }

    public static void main(String[] args) {
        // 1
        String s1 = "00110";
        System.out.println(minFlipsMonoIncr(s1));

        // 2
        String s2 = "010110";
        System.out.println(minFlipsMonoIncr(s2));

        // 2
        String s3 = "00011000";
        System.out.println(minFlipsMonoIncr(s3));

    }
}
