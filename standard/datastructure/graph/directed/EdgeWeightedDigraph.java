package datastructure.graph.directed;

/*
 * Strongly Connected
 * Vertex v and w are strongly connected if there is a directed path from v to w
 * and there is a directed path from w to v. So it is equivalence relation(reflexive, symmetric, transitive)
 */

import java.util.ArrayList;

// Directed graph with weighted edge
public class EdgeWeightedDigraph {

    private final int V; // number of vertices in this digraph
    private int E; // number of edges in this digraph
    private ArrayList<DirectedEdge>[] vertex; // adj[v] = adjacency list for vertex v
    private int[] indegree; // indegree[v] = indegree of vertex v

    /**
     * Initializes an empty edge-weighted digraph with {@code V} vertices and 0 edges.
     *
     * @param V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        this.indegree = new int[V];
        vertex = (ArrayList<DirectedEdge>[]) new ArrayList[V];
        for (int v = 0; v < V; v++)
            vertex[v] = new ArrayList<>();
    }

    /**
     * Returns the number of vertices in this edge-weighted digraph.
     */
    public int V() {
        return V;
    }

    /**
     * @return the number of edges in this edge-weighted digraph
     */
    public int E() {
        return E;
    }

    /**
     * Adds the directed edge {@code e} to this edge-weighted digraph.
     */
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        validateVertex(v);
        validateVertex(w);
        vertex[v].add(e);
        indegree[w]+=1;
        ++E;
    }

    public int outdegree(int v) {
        validateVertex(v);
        return vertex[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * @return all edges in this edge-weighted digraph, as an iterable
     */
    public Iterable<DirectedEdge> edges() {
        ArrayList<DirectedEdge> list = new ArrayList<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : vertex[v]) {
                list.add(e);
            }
        }
        return list;
    }
}
