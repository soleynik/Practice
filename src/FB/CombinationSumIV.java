package FB;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
377. Combination Sum IV

Given an array of distinct integers nums and a target integer target, return the number of
possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

 */
public class CombinationSumIV {

    // O(T * N) O(T)

    // DP Bottom-Up
    static int combinationSum4DPBottomUp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++)
            for (int num : nums)
                if (i - num >= 0)
                    dp[i] += dp[i - num];
        return dp[target];
    }

    // DP Top-Down
    static int combinationSum4DPTopDown(int[] nums, int target){
        int[] cache = new int[target+1];
        Arrays.fill(cache,-1);
        cache[0] = 1;
        return combinationTopDown(nums, target, cache);
    }

    static int combinationTopDown(int[] nums, int target, int[] cache){
        if(cache[target] != -1)
            return cache[target];
        int result = 0;
        for(int i = 0; i<nums.length; i++){
            if(target >= nums[i])
                result += combinationTopDown(nums, target - nums[i], cache);
        }
        cache[target] = result;
        return result;
    }

    // Recursion
    static int combinationSum4Recursion(int[] nums, int target){
        if(target == 0)
            return 1;
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(target >= nums[i])
                result += combinationSum4Recursion(nums, target - nums[i]);
        }
        return result;
    }




}
