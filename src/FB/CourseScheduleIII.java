package FB;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
630. Course Schedule III

There are n different online courses numbered from 1 to n.
You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith course
should be taken continuously for durationi days and must be finished before or on lastDayi.

You will start on the 1st day and you cannot take two or more courses simultaneously.

Return the maximum number of courses that you can take.
 */
public class CourseScheduleIII {

    // O(nlogn) O(n)
    static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); //Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] c : courses) {
            time += c[0]; // add current course to a priority queue
            pq.add(c[0]);
            if (time > c[1])
                time -= pq.poll(); //If time exceeds, drop the previous course which costs the most time. (That must be the best choice!)
        }
        return pq.size();
    }

    public static void main(String[] args) {

        // 3
        int[][] courses1 = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(scheduleCourse(courses1));

        // 1
        int[][] courses2 = {{1,2}};
        System.out.println(scheduleCourse(courses2));

        // 0
        int[][] courses3 = {{3,2},{4,3}};
        System.out.println(scheduleCourse(courses3));
    }
}
