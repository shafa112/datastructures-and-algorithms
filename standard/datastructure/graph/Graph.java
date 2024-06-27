package datastructure.graph;

import java.util.ArrayList;

/**
 * Undirected and unweighted graph
 * Integer vertex
 * Capacity is given - N
 * Implementation: Array of ArrayList
 */
public class Graph {

    private ArrayList<Integer>[] vertex; // We sometimes also name this as graph in ds-algo question
    private int N; //capacity (Vertex more than this can't be added)

    public Graph(int N) {
        this.N = N;
        ArrayList<Integer>[] vertex = (ArrayList<Integer>[]) new ArrayList[N];
        for (int i = 0; i < N; i++) vertex[i] = new ArrayList<>();
        this.vertex = vertex;
    }

    public void connect(int v, int w) {
        vertex[v].add(w);
        vertex[w].add(v);
    }

    // Adjacency list
    // Returns iterable of all adjacent vertices of vertex v
    public Iterable<Integer> adj(int v) {
        return vertex[v];
    }

    public int size() {
        return N;
    }

    public int degree(int v) {
        return vertex[v].size();
    }
}
