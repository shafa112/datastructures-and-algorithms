package datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// https://www.coursera.org/learn/algorithms-part2/lecture/RAMNS/topological-sort

// Note: It works digraph with no cycle i.e. directed acyclic graph (DAG)
public class TopologicalOrderDigraph {

    public static Iterable<Integer> topologicalOrder(DiGraph graph) {
        int N = graph.n;
        boolean[] visited = new boolean[N];
        Stack<Integer> reverseDfs = new Stack<>();
        for(int v = 0; v < N; v++) {
            if(!visited[v]) dfs(graph, v, visited, reverseDfs);
        }
        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        while (!reverseDfs.isEmpty()) topologicalOrder.add(reverseDfs.pop());
        return topologicalOrder;
    }

    private static void dfs(DiGraph diGraph, int v, boolean[] visited, Stack<Integer> reverseDfs) {
        visited[v] = true;
        for(int w: diGraph.adj(v)) {
            if(!visited[w]) {
                dfs(diGraph, w, visited, reverseDfs);
            }
        }
        reverseDfs.push(v);
    }

    public static void main(String[] args) {
        DiGraph graph = new DiGraph(7);
        graph.connect(0,1);
        graph.connect(0,2);
        graph.connect(0,5);

        graph.connect(1,4);

        graph.connect(3,2);
        graph.connect(3,4);
        graph.connect(3,5);
        graph.connect(3,6);

        graph.connect(5,2);

        graph.connect(6,0);
        graph.connect(6,4);

        for(int w: topologicalOrder(graph)) {
            System.out.print(w + " ");
        }
        System.out.println();
    }
}
