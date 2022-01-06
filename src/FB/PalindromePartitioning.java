package FB;

import java.util.ArrayList;
import java.util.List;

/*
131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.
 */
public class PalindromePartitioning {

    // O(n*2^n) O(n)

    static List<List<String>> palindromePartitioning(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, result, 0, new ArrayList<>());
        return result;
    }

    static void backtrack(String s, List<List<String>> result, int l, List<String> inner) {
        if (l == s.length())
            result.add(new ArrayList<>(inner));
        else {
                for(int r = l; r < s.length(); r++){
                    if(isPalindrome(s,l,r)){
                        inner.add(s.substring(l,r+1));
                        backtrack(s,result,r+1,inner);
                        inner.remove(inner.size()-1);
                    }
                }
        }
    }

    static boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        // [["a","a","b"],["aa","b"]]
        String s1 = "aab";
        System.out.println(palindromePartitioning(s1));

        //
        String s2 = "a";
        System.out.println(palindromePartitioning(s2));
    }

}
