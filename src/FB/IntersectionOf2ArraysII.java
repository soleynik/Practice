package FB;

/*
        350. Intersection of Two Arrays II

        Given two integer arrays nums1 and nums2, return an array of their intersection.
        Each element in the result must appear as many times as it shows in both arrays
        and you may return the result in any order.
*/

import java.util.*;

public class IntersectionOf2ArraysII {
    // O(n+m) O(n)
    static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums1)
            map.put(i, map.getOrDefault(i,0)+1);
        for(int i:nums2){
            if(map.containsKey(i) && map.get(i) > 0){
                list.add(i);
                map.put(i,map.get(i)-1);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }

    public static void main(String[] args) {
        // [2,2]
        int[] a1 = {1,2,2,1};
        int[] b1 = {2,2};
        System.out.println(Arrays.toString(intersection(a1, b1)));

        // [9,4] or [4,9]
        int[] a2 = {4,9,5};
        int[] b2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(a2, b2)));
    }

}
