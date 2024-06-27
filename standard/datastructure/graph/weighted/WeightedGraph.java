package datastructure.graph.weighted;


import java.util.ArrayList;

// Implementation: Array of ArrayList
public class WeightedGraph {

    ArrayList<Edge>[] vertex;
    int E = 0;// Edge count
    int V; //capacity

    public WeightedGraph(int V) {
        this.V = V;
        vertex = (ArrayList<Edge>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            vertex[i] = new ArrayList<>();
        }
    }


    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        vertex[v].add(edge);
        vertex[w].add(edge);
        ++E;
    }

    public Iterable<Edge> adj(int v) {
        return vertex[v];
    }

    public int edgeCount() {
        return E;
    }

    public Iterable<Edge> edges() {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (vertex[i] != null) {
                for (Edge e : vertex[i]) {
                    int v = i;
                    int w = e.other(v);
                    if (v < w) edges.add(e);
                }
            }
        }
        return edges;
    }

    public int degree(int v) {
        return vertex[v].size();
    }

    public int size() {
        return V;
    }

}
