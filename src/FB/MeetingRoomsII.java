package FB;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
253. Meeting Rooms II

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.

 */
public class MeetingRoomsII {
    // O(nlogn) O(n)
    static int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= pq.peek())
                pq.poll();
            pq.add(intervals[i][1]);
        }
    return pq.size();
    }

    public static void main(String[] args) {

        // 2
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals1));

        // 1
        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println(minMeetingRooms(intervals2));
    }

}
