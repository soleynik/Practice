package FB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {
    // O(2^n) O(n)
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    static void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> inner, int position) {
        if (target < 0) return;
        else if (target == 0)
            result.add(new ArrayList<>(inner));
        else {
            for (int i = position; i < candidates.length; i++) {
                if (i > position && candidates[i] == candidates[i - 1])
                    continue;
                inner.add(candidates[i]);
                backtrack(candidates, target - candidates[i], result, inner, i + 1);
                inner.remove(inner.size() - 1);
            }
        }

    }

    public static void main(String[] args) {

        // [[1,1,6],[1,2,5],[1,7],[2,6]]
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println(combinationSum2(candidates1, target1));

        // [[1,2,2],[5]]
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println(combinationSum2(candidates2, target2));
    }
}
