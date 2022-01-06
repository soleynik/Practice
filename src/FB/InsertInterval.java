package FB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
57. Insert Interval
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

 */
public class InsertInterval {
    // O(n) O(n)
    static int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while(i<n && intervals[i][1] < newInterval[0])
            result.add(intervals[i++]);
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);
        while(i < n)
            result.add(intervals[i++]);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        // [[1,5],[6,9]]
        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};
        int[][] result1 = insert(intervals1, newInterval1);
        for(int[] a: result1) {
            System.out.print("[ ");
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.print("]");
        }

        System.out.println();

        //[[1,2],[3,10],[12,16]]
        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};
//        int[][] result2 = insert(intervals2, newInterval2);
//        for(int[] a: result2) {
//            System.out.print("[ ");
//            for (int i : a) {
//                System.out.print(i + " ");
//            }
//            System.out.print("]");
//        }
    }
}
