package datastructure.graph;

public class CourseSchedule1_DirectedGraphCycle {

    boolean hasCycleInDirectedGraph(DiGraph g) {
        int n = g.n;
        boolean[] visited = new boolean[n];
        boolean[] visitedInCurrentPath = new boolean[n];
        for(int i = 0; i<n; ++i){
            if (!visited[i]) {
                boolean hasCycle = dfs(g, i, visited, visitedInCurrentPath);
                if (hasCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(DiGraph g, int v,boolean[] visited, boolean[] visitedInCurrentPath) {
        visited[v] = true;
        visitedInCurrentPath[v] = true;
        for(int u: g.adj(v)) {
            if(!visited[u]) {
                boolean hasCycle = dfs(g,u,visited,visitedInCurrentPath);
                if(hasCycle) return true;
            }
            else {
                if(visitedInCurrentPath[u])return true;
            }
        }
        visitedInCurrentPath[v] = false;
        return false;
    }
}
