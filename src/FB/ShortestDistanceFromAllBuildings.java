package FB;

import java.util.LinkedList;
/*
        317. Shortest Distance from All Buildings

        You are given an m x n grid grid of values 0, 1, or 2, where:

        each 0 marks an empty land that you can pass by freely,
        each 1 marks a building that you cannot pass through, and
        each 2 marks an obstacle that you cannot pass through.
        You want to build a house on an empty land that reaches all buildings in
        the shortest total travel distance. You can only move up, down, left, and right.

        Return the shortest travel distance for such a house. If it is not possible
        to build such a house according to the above rules, return -1.

        The total travel distance is the sum of the distances between the houses of the friends and the meeting point.

*/

public class ShortestDistanceFromAllBuildings {

    // O(N^2 * M^2)
    static int shortestDistance(int[][] a) {
        int minDistance = Integer.MAX_VALUE;
        int R = a.length;
        int C = a[0].length;
        int[] rd = {-1, 1, 0, 0};
        int[] cd = {0, 0, 1, -1};
        int[][] reach = new int[R][C];
        int[][] distance = new int[R][C];
        int totalBuildings = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (a[r][c] == 1) {
                    totalBuildings++;
                    LinkedList<Integer> rq = new LinkedList<>();
                    LinkedList<Integer> cq = new LinkedList<>();
                    rq.add(r);
                    cq.add(c);
                    boolean[][] visited = new boolean[R][C];
                    int level = 0;
                    while (!rq.isEmpty()) {
                        int queueSize = rq.size();
                        level++;
                        for (int q = 0; q < queueSize; q++) {
                            int currentR = rq.remove();
                            int currentC = cq.remove();
                            for (int i = 0; i < 4; i++) {
                                int rr = currentR + rd[i];
                                int cc = currentC + cd[i];
                                if (rr >= 0 && rr < R && cc >= 0 && cc < C && a[rr][cc] == 0 && !visited[rr][cc]) {
                                    distance[rr][cc] += level;
                                    reach[rr][cc]++;
                                    visited[rr][cc] = true;
                                    rq.add(rr);
                                    cq.add(cc);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (reach[r][c] == totalBuildings && distance[r][c] < minDistance)
                    minDistance = distance[r][c];
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}};
        System.out.println(shortestDistance(a));
    }
}
