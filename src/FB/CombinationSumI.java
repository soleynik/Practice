package FB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
39. Combination Sum

Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than
150 combinations for the given input.

 */
public class CombinationSumI {

    // O(n^(i/m) O(i/m)

    static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,result,new ArrayList<>(),0);
        return result;
    }

    static void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> inner, int position){
        if(target < 0) return;
        else if(target == 0) {
            result.add(new ArrayList<>(inner));
        }
        else{
            for(int i = position; i <candidates.length; i++){
                inner.add(candidates[i]);
                backtrack(candidates, target - candidates[i],result,inner,i); // not i+1 because we can reuse same element
                inner.remove(inner.size()-1);
            }
        }
    }

    public static void main(String[] args) {

        // [[2,2,3],[7]]
        int[] candidates1 = {2,3,6,7};
        int target1 = 7;
        System.out.println(combinationSum(candidates1,target1));

        // [[2,2,2,2],[2,3,3],[3,5]]
        int[] candidates2 = {2,3,5};
        int target2 = 8;
        System.out.println(combinationSum(candidates2,target2));

        // []
        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println(combinationSum(candidates3,target3));
    }

}
