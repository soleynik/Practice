package FB;
/*
        161. One Edit Distance

        Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

        A string s is said to be one distance apart from a string t if you can:

        Insert exactly one character into s to get t.
        Delete exactly one character from s to get t.
        Replace exactly one character of s with a different character to get t.
 */

/*
 * There're 3 possibilities to satisfy one edit distance apart:
 *
 * 1) Replace 1 char:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s:
	  s: a D  b c
	  t: a    b c
 * 3) Delete 1 char from t
	  s: a   b c
	  t: a D b c
 */
public class EditOneDistance {
    // O(max(m, n)) O(1)
    static boolean editOneDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
                    return s.substring(i).equals(t.substring(i + 1));
                else // s is longer than t, so the only possibility is deleting one char from s
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
        return Math.abs(s.length() - t.length()) == 1;
    }


    public boolean isOneEditDistance(String s, String t) {
        int i = 0;
        while (i < s.length() && i < t.length()) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (c1 != c2) {
                return s.substring(i + 1).equals(t.substring(i + 1)) //replace
                        || s.substring(i).equals(t.substring(i + 1)) //add
                        || s.substring(i + 1).equals(t.substring(i));  //delete
            }
            i++;
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    // Two pointers
    public boolean isOneEditDistanceTwoPointers(String s, String t) {
        if (s == null || s.length() == 0) {
            return t.length() == 1;
        }
        if (t == null || t.length() == 0) {
            return s.length() == 1;
        }
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while (p1 < m && p2 < n) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
            } else {
                count++;
                if (count > 1) {
                    return false;
                }
                if (m == n) {
                    p1++;
                    p2++;
                } else if (m > n) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }
        count += m - p1 + n - p2;
        return count == 1;
    }

    public static void main(String[] args) {
        // true
        System.out.println(editOneDistance("ab", "acb"));
        // false
        System.out.println(editOneDistance("",""));
        // false
        System.out.println(editOneDistance("a",""));
    }
}
