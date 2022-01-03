package FB;

import java.util.ArrayDeque;
import java.util.Deque;

/*
        200. Number of Islands

        Given an m x n 2D binary grid grid which represents a map of '1's (land)
        and '0's (water), return the number of islands.

        An island is surrounded by water and is formed by connecting adjacent lands
        horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    private static int numberOfIslands(int[][] a) {
        int count = 0;
        int R = a.length;
        int C = a[0].length;
        int[] rd = {-1, 1, 0, 0};
        int[] cd = {0, 0, 1, -1};
        Deque<Integer> rs = new ArrayDeque<>();
        Deque<Integer> cs = new ArrayDeque<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (a[r][c] == 1) {
                    rs.push(r);
                    cs.push(c);
                    a[r][c] = 8;
                    while (!rs.isEmpty()) {
                        int currentR = rs.pop();
                        int currentC = cs.pop();
                        for (int i = 0; i < 4; i++) {
                            int rr = currentR + rd[i];
                            int cc = currentC + cd[i];
                            if (rr >= 0 && rr < R && cc >= 0 && cc < C && a[rr][cc] == 1) {
                                rs.push(rr);
                                cs.push(cc);
                                a[rr][cc] = 8;
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};

        System.out.println(numberOfIslands(graph));
    }

}
