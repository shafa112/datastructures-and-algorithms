package datastructure.graph;


public class UndirectedGraphCycle {

    /**
     * Returns true if cycle exists otherwise return false
     */
    public static boolean hasCycle(Graph graph) {
        boolean[] visited = new boolean[graph.size()];
        for (int v = 0; v < graph.size(); v++) {
            if (!visited[v]) {
                boolean hasCycle = dfsRecursiveHelper(graph, v, visited);
                if (hasCycle) return true;
            }
        }
        return false;
    }

    private static boolean dfsRecursiveHelper(Graph graph, int v, boolean[] visited) {
        if (visited[v]) return true;
        visited[v] = true;
        for (int w : graph.adj(v)) {
            boolean hasCycle = dfsRecursiveHelper(graph, w, visited);
            if (hasCycle) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.connect(0,1);
        graph.connect(1,2);
        //graph.connect(1,3);
        graph.connect(2,3);
        graph.connect(3,4);
        System.out.println(hasCycle(graph));
    }
}
