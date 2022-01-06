package FB;

/*
8. String to Integer (atoi)
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
 */
public class ATOI {
    // O(n) O(1)
    static int getAtoi(String s) {
        int index = 0;
        int sign = 1;
        int total = 0;
        if (s.length() == 0) return 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length())
            return 0;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9)
                break;
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
        // Output: 42
        String s1 = "42";
        System.out.println(getAtoi(s1));

        // Output: -42
        String s2 = "   -42";
        System.out.println(s2);

        // 4193
        String s3 = "4193 with words";
        System.out.println(getAtoi(s3));
    }

}
