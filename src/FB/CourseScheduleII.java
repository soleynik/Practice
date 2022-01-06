package FB;

import java.util.LinkedList;
import java.util.Queue;

/*
210. Course Schedule II

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers,
return any of them. If it is impossible to finish all courses, return an empty array.

 */
public class CourseScheduleII {

    // O(n) O(n)
    static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; ++i)
            indegree[prerequisites[i][0]]++;
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 0; i < indegree.length; ++i)
            if(indegree[i] == 0)
                Q.add(i);
        int[] sorted = new int[numCourses];
        int first = 0;
        int count = 0;
        while(!Q.isEmpty() && first < sorted.length){
            int current = Q.poll();
            sorted[first++] = current;
            for(int i = 0; i<prerequisites.length; ++i){
                if(prerequisites[i][1] == current){
                    if(--indegree[prerequisites[i][0]] == 0)
                        Q.add(prerequisites[i][0]);
                }
            }
            count++;
        }
        if(count != numCourses){
            return new int[0];
        }
        return sorted;
    }

    public static void main(String[] args) {

        // [0,1]
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        int[] result1 = findOrder(numCourses1, prerequisites1);
        for(int n:result1)
            System.out.print(n + " ");

        System.out.println();
        // [0,2,1,3]
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
        int[] result2 = findOrder(numCourses2, prerequisites2);
        for(int n:result2)
            System.out.print(n + " ");

        System.out.println();
        // []
        int numCourses3 = 1;
        int[][] prerequisites3 = {};
        int[] result3 = findOrder(numCourses3, prerequisites3);
        for(int n:result3)
            System.out.print(n + " ");
    }


}
