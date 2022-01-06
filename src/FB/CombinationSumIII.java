package FB;

import java.util.ArrayList;
import java.util.List;

/*
216. Combination Sum III

Find all valid combinations of k numbers that sum up to n
such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice,
and the combinations may be returned in any order.
 */
public class CombinationSumIII {

    // O(m*9K) O(n)
    static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, result, new ArrayList<>(), 1);
        return result;
    }

    static void backtrack(int k, int n, List<List<Integer>> result, List<Integer> inner, int position) {
        if (inner.size() > k) return;
        if (inner.size() == k && n == 0) {
            result.add(new ArrayList<>(inner));
            return;
        } else {
            for (int i = position; i <= 9; i++) {
                inner.add(i);
                backtrack(k, n - i, result, inner, i + 1);
                inner.remove(inner.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        // [[1,2,4]] --> 1 + 2 + 4 = 7
        System.out.println(combinationSum3(3, 7));

        // [[1,2,6],[1,3,5],[2,3,4]]
        System.out.println(combinationSum3(3, 9));

        // []
        System.out.println(combinationSum3(4, 1));
    }
}
