package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * If cycle exists on the SAME PATH, the vertex has to be visited again
 */
public class DiGraph {

    int n;
    ArrayList<ArrayList<Integer>> vertex;

    public DiGraph(int n) {
        vertex = new ArrayList<>();
        this.n = n;
        for (int i = 0; i < n; i++) {
            vertex.add(new ArrayList<>());
        }
    }

    public void connect(int first, int second) {
        vertex.get(first).add(second);
    }

    public ArrayList<Integer> adj(int v) {
        return vertex.get(v);
    }

    boolean hasCycle() {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                boolean hasCycle = dfs(i, visited, parent);
                if (hasCycle) return true;
            }
        }
        return false;
    }

    private boolean dfs(int v, boolean[] visited, int[] parent) {
        visited[v] = true;
        for (int u : adj(v)) {
            if(parent[v]==u) return true;
            if(parent[u]==-1) parent[u] = v;
            if (!visited[u]) {
                boolean hasCycle = dfs(u, visited, parent);
                if (hasCycle) return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{0, 1},{2,0},{1,2}};
        DiGraph g = new DiGraph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            g.connect(prerequisites[i][1], prerequisites[i][0]);
        }
        if (g.hasCycle()) System.out.println("has cycle, can't finish");
        else System.out.println("no cycle, can finish");
    }
}
