package FB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.
Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons)
is given below. Note that 1 does not map to any letters.

 */
public class LetterCombinationOfPhoneNumber {
    // O(n*4^n) O(n)

    // iterative
    static List<String> letterCombination(String digits){
        Queue<String> result= new LinkedList<>();
        if(digits.isEmpty())
            return new ArrayList<>(result);
        String[] pad = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        result.add("");
        while(result.peek().length() != digits.length()){
            String remove = result.remove();
            String map = pad[digits.charAt(remove.length())-'0'];
            for(char c:map.toCharArray())
                result.add(remove+c);
        }
        return new ArrayList<>(result);
    }

    // recursive
    static String[] pad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> letterCombinationRecursion(String digits){
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) return result;
        combination(digits,result,0, new StringBuilder());
        return result;
    }
    static void combination(String digits, List<String> result, int position, StringBuilder sb){
        if(position == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String letters = pad[digits.charAt(position) - '0'];
        for(int i = 0; i < letters.length();i++){
            int sbLength = sb.length();
            combination(digits,result,position+1,sb.append(letters.charAt(i)));
            sb.setLength(sbLength);
        }
    }

    public static void main(String[] args) {
        // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        String digits1 = "23";
        System.out.println(letterCombination(digits1));
        System.out.println(letterCombinationRecursion(digits1));

        // []
        String digits2 = "";
        System.out.println(letterCombination(digits2));
        System.out.println(letterCombinationRecursion(digits2));

        // ["a","b","c"]
        String digits3 = "2";
        System.out.println(letterCombination(digits3));
        System.out.println(letterCombinationRecursion(digits3));
    }
}
