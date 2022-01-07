package FB;

import java.util.Arrays;
import java.util.Comparator;

/*
252. Meeting Rooms

Given an array of meeting time intervals
where intervals[i] = [starti, endi], determine if a person could attend all meetings.

 */
public class MeetingRooms {
    // O(nlogn) O(1)
    static boolean canAttendMeetings(int[][] intervals) {
        // sort by starting time
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        for(int i = 0; i < intervals.length-1; i++)
            // compare if 1st end time is greater than 2nd start time, if yes --> false
            if(intervals[i][1] > intervals[i+1][0])
                return false;
        return true;
    }

    public static void main(String[] args) {

        // false
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        System.out.println(canAttendMeetings(intervals1));

        // true
        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println(canAttendMeetings(intervals2));
    }
}
