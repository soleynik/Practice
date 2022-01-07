package AMZN;

import java.util.*;

/*
1481. Least Number of Unique Integers after K Removals

Given an array of integers arr and an integer k.
Find the least number of unique integers after removing exactly k elements.
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {

    // O(nlogn) O(n)

    static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);

        int count = 0;
        for(int n : values) {
            k -= n;

            if (k < 0)
                break;
            else
                count++;
        }

        return map.keySet().size() - count;
    }

    public static void main(String[] args) {

        // 1
        int[] a1 = {5,5,4};
        int k1 = 1;
        System.out.println(findLeastNumOfUniqueInts(a1,k1));

        // 2
        int[] a2 = {4,3,1,1,3,3,2};
        int k2 = 3;
        System.out.println(findLeastNumOfUniqueInts(a2,k2));

    }
}
