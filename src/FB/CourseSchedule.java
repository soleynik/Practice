package FB;


import java.util.LinkedList;
import java.util.Queue;

/*
207. Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 */
public class CourseSchedule {

    // O(n) O(n)
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < indegree.length; ++i)
            if (indegree[i] == 0)
                Q.add(i);
        int count = 0;
        while (!Q.isEmpty()) {
            int current = Q.poll();
            for (int i = 0; i < prerequisites.length; ++i) {
                if (prerequisites[i][1] == current) {
                    if (--indegree[prerequisites[i][0]] == 0) {
                        Q.add(prerequisites[i][0]);
                    }
                }
            }
            count++;
        }
        return count == numCourses;
    }

    public static void main(String[] args) {

        // true
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        System.out.println(canFinish(numCourses1, prerequisites1));

        // false
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1,0},{0,1}};
        System.out.println(canFinish(numCourses2, prerequisites2));
    }

}
