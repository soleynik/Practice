package FB;

import java.util.ArrayList;
import java.util.List;

/*
22. Generate Parentheses

Given n pairs of parentheses,
write a function to generate all combinations of well-formed parentheses.

 */
public class GenerateParentheses {
    // O(2^n) O(n)
    static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, result, new StringBuilder(), 0, 0);
        return result;
    }

    static void generate(int n, List<String> result, StringBuilder sb, int open, int close){
        if(sb.length() == n<<1){
            result.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            generate(n,result,sb,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            generate(n,result,sb,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {

        // ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(generateParenthesis(3));
        // ["()"]
        System.out.println(generateParenthesis(1));

    }
}
