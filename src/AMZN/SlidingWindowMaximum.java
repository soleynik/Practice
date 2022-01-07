package AMZN;
/*
239. Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k
which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SlidingWindowMaximum {

    static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[dq.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // [3,3,5,5,6,7]
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        Arrays.stream(maxSlidingWindow(nums1, k1)).forEach(i -> System.out.print(i + " "));

        System.out.println();
        // [1]
        int[] nums2 = {1};
        int k2 = 1;
        Arrays.stream(maxSlidingWindow(nums2, k2)).forEach(i -> System.out.print(i + " "));
    }
}
