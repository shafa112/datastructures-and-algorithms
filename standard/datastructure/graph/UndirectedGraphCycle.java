package datastructure.graph;


import java.util.Arrays;

public class UndirectedGraphCycle {

    /**
     * Returns true if cycle exists otherwise return false
     */
    public static boolean hasCycle(Graph graph) {
        int[] parent = new int[graph.size()];
        Arrays.fill(parent, -1);
        parent[0] = 0;
        boolean[] visited = new boolean[graph.size()];
        for (int v = 0; v < graph.size(); v++) {
            if (!visited[v]) {
                boolean hasCycle = dfsRecursiveHelper(graph, v, visited, parent);
                if (hasCycle) return true;
            }
        }
        return false;
    }

    private static boolean dfsRecursiveHelper(Graph graph, int v, boolean[] visited, int[] parent) {
        if (!visited[v]) {
            visited[v] = true;
            for (int w : graph.adj(v)) {
                if (parent[w] == -1) parent[w] = v;
                // MOSTLY below condition correction visited[w]
                if (parent[v] != w && parent[w] != v && visited[w]) {
                    System.out.println(w+" "+v);
                    return true;
                }
                boolean hasCycle = dfsRecursiveHelper(graph, w, visited, parent);
                if (hasCycle) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.connect(0, 1);
        //graph.connect(0, 2);
        graph.connect(1, 2);
        System.out.println(hasCycle(graph));
    }
}
