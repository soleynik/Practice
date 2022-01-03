package FB;

import java.util.Arrays;

/*
        34. Find First and Last Position of Element in Sorted Array

        Given an array of integers nums sorted in ascending order,
        find the starting and ending position of a given target value.

        If target is not found in the array, return [-1, -1].
*/
public class FirstAndLastPositionOfElementInSortedArray {

    // O(logN) O(1)
    static int[] searchRange(int[] nums, int target) {
        int first = searchPosition(nums, target);
        int last = searchPosition(nums, target+1)-1;
        if(first <= last)
            return new int[]{first, last};
        return new int[]{-1,-1};
    }

    static int searchPosition(int[] nums, int target) {
        int firstPositiom = nums.length;
        int l = 0;
        int r = nums.length-1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (nums[mid] >= target) {
                firstPositiom = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return firstPositiom;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        // Output: [3,4]
        System.out.println(Arrays.toString(searchRange(nums1, target1)));

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        // Output: [-1,-1]
        //System.out.println(Arrays.toString(searchRange(nums2, target2)));

        int[] nums3 = new int[]{};
        int target3 = 0;
        //Output: [-1,-1]
        //System.out.println(Arrays.toString(searchRange(nums3, target3)));
    }
}
