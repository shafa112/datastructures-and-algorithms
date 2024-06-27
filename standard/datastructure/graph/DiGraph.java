package datastructure.graph;

import java.util.*;

public class DiGraph {

    ArrayList<ArrayList<Integer>> vertex;
    int n;

    DiGraph(int n) {
        this.n = n;
        vertex = new ArrayList<>();
        for (int i = 0; i < n; i++)
            vertex.add(new ArrayList<>());
    }

    // Connection first to second because it is a digraph
    public void connect(int first, int second) {
        vertex.get(first).add(second);
    }

    public Iterable<Integer> adj(int v) {
        return vertex.get(v);
    }

    // Depth first traversal
    public void dfsRecursive(int v) {
        boolean[] visited = new boolean[n];
        dfsRecursiveHelper(v, visited);
        System.out.println();
    }

    private void dfsRecursiveHelper(int v, boolean[] visited) {
        if (!visited[v]) {
            System.out.print(v + " ");
            visited[v] = true;
            for (int w : vertex.get(v)) {
                dfsRecursiveHelper(w, visited);
            }
        }
    }

    // Depth first traversal
    public void dfsIterative(int v) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int w = stack.pop();
            System.out.print(w + " ");
            visited[w] = true;
            for (int e : vertex.get(w)) {
                if (!visited[e]) {
                    stack.push(e);
                }
            }
        }
        System.out.println();
    }

    public void breadthFirstTraversal() {
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                bfsHelper(v, visited);
            }
        }
    }

    // Breadth first Search (BFS)
    public void bfs(int v) {
        boolean[] visited = new boolean[n];
        bfsHelper(v, visited);
        System.out.println();
    }

    public void bfsHelper(int v, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int w = queue.remove();
            System.out.print(w + " ");
            for (int e : vertex.get(w)) {
                if (!visited[e]) {
                    queue.add(e);
                    visited[e] = true;
                }
            }
        }
    }

    public int numberOfConnectedComponentsDfs() {
        int numComponents = 0;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                dfsRecursiveHelper(v, visited);
                numComponents++;
            }
        }
        return numComponents;
    }

    public int numberOfConnectedComponentsBfs() {
        int numComponents = 0;
        boolean visited[] = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                bfsHelper(v, visited);
                numComponents++;
            }
        }
        return numComponents;
    }

    public static void main(String[] args) {
        DiGraph diGraph = new DiGraph(9);
        diGraph.connect(0, 2);
        diGraph.connect(0, 1);
        diGraph.connect(1, 4);
        diGraph.connect(2, 3);
        diGraph.connect(3, 4);
        diGraph.connect(3, 5);
        diGraph.connect(6, 7);

        System.out.println("Components count using dfs = " + diGraph.numberOfConnectedComponentsDfs());
        //diGraph.dfsRecursive(0);

        /*diGraph.dfsIterative(0);
        System.out.println("-----BFS----");
        diGraph.bfs(0);
        System.out.println("Components count using dfs = " + diGraph.numberOfConnectedComponentsDfs());
        System.out.println("Components count using bfs = " + diGraph.numberOfConnectedComponentsBfs());*/
    }
}
