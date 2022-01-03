package FB;

/*
        349. Intersection of Two Arrays

        Given two integer arrays nums1 and nums2, return an array of their intersection.
        Each element in the result must be unique and you may return the result in any order.

        FOLLOW UP:
        What if elements of nums2 are stored on disk, and the memory is
        limited such that you cannot load all elements into the memory at
        once?

        - If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap,
        read chunks of array that fit into the memory, and record the intersections.

        - If both nums1 and nums2 are so huge that neither fit into the memory,
        sort them individually (external sort),
        then read 2 elements from each array at a time in memory, record intersections.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOf2Arrays {
    // O(n) O(n)
    static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i : nums1)
            set.add(i);
        for (int i : nums2)
            if (set.contains(i))
                intersect.add(i);
        int[] result = new int[intersect.size()];
        int k = 0;
        for (int num : intersect)
            result[k++] = num;
        return result;
    }

    // O(nlogn) O(1)
    static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (int num : set)
            result[k++] = num;
        return result;
    }

    // O(nlogn) O(1)
    static int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int num : nums1)
            if (searchBinary(nums2, num))
                set.add(num);
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set)
            result[i++] = num;
        return result;
    }

    static boolean searchBinary(int[] a, int target) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target)
                return true;
            else if (a[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        // 2
        int[] a1 = {1, 2, 2, 1};
        int[] b1 = {2, 2};
        System.out.println(Arrays.toString(intersection(a1, b1)));
        System.out.println(Arrays.toString(intersection2(a1, b1)));
        System.out.println(Arrays.toString(intersection3(a1, b1)));

        // [9,4] or [4,9]
        int[] a2 = {4, 9, 5};
        int[] b2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(a2, b2)));
        System.out.println(Arrays.toString(intersection2(a2, b2)));
        System.out.println(Arrays.toString(intersection3(a2, b2)));
    }
}
