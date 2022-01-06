package FB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    // O(nlogn) O(n)
    static int[][] mergeIntervals(int[][] intervals){
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for(int[] interval:intervals){
            if(interval[0] <= newInterval[1])
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            else{
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        // [[1,6],[8,10],[15,18]]
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result1 = mergeIntervals(intervals1);
        for(int[] a: result1) {
            System.out.print("[ ");
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.print("]");
        }
        System.out.println();

        // [[1,5]]
        int[][] intervals2 = {{1,4},{4,5}};
        int[][] result2 = mergeIntervals(intervals2);
        for(int[] a: result2) {
            System.out.print("[ ");
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.print("]");
        }

    }
}
