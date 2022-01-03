package FB;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
/*
        785. Is Graph Bipartite?

        There is an undirected graph with n nodes, where each node is numbered between 0
        and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is
        adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v.
        The graph has the following properties:

        There are no self-edges (graph[u] does not contain u).
        There are no parallel edges (graph[u] does not contain duplicate values).
        If v is in graph[u], then u is in graph[v] (the graph is undirected).
        The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
        A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in
        the graph connects a node in set A and a node in set B.

        Return true if and only if it is bipartite.
 */
public class IsGraphBipartite {

    static boolean isGraphBipartite(int[][] a){
        int N = a.length;
        int[] color = new int[N];
        Arrays.fill(color,-1);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int u = 0; u < N; u++){
            if(color[u] == -1){
                stack.push(u);
                color[u] = 0;
                while(!stack.isEmpty()){
                    int x = stack.pop();
                    for(int v : a[x]){
                        if(color[v] == -1){
                            stack.push(v);
                            color[v] = color[x] ^ 1;
                        }else if(color[v] == color[x])
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //false
        int[][] a = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isGraphBipartite(a));

        // true
        int[][] a1 = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isGraphBipartite(a1));

    }
}
