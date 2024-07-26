package datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class CourseSchedule2 {

    int n;
    ArrayList<ArrayList<Integer>> vertex;
    boolean hasCycle = false;
    Stack<Integer> reverseDfs = new Stack<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        initialize(numCourses);
        for(int i = 0; i<prerequisites.length; i++) {
            connect(prerequisites[i][1],prerequisites[i][0]);
        }

        topologicalOrder();
        int[] ans = new int[n];
        int i = 0;
        if(!hasCycle) {
            while (!reverseDfs.isEmpty()) ans[i++] = reverseDfs.pop();
        } else return new int[]{};

        return ans;
    }

    public void initialize(int n) {
        vertex = new ArrayList<>();
        this. n = n;
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

    public void topologicalOrder() {
        boolean[] visited = new boolean[n];
        boolean onPath[] = new boolean[n];
        for(int v = 0; v < n; v++) {
            if(!visited[v]) dfs(v, visited,onPath);
        }
    }

    private void dfs(int v, boolean[] visited, boolean onPath[]) {
        visited[v] = true;
        onPath[v] = true;
        for(int w: adj(v)) {
            if(!visited[w]) {
                dfs(w, visited, onPath);
            } else if(onPath[w]) hasCycle = true;
        }
        onPath[v]=false;
        reverseDfs.push(v);
    }
}