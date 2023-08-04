package datastructure.graph.weighted;


import java.util.ArrayList;

// Implementation: Array of ArrayList
public class WeightedGraph {

    ArrayList<Edge>[] vertex;
    int edgeCount = 0;// number of edges
    int N; //capacity

    public WeightedGraph(int N) {
        this.N = N;
        vertex = (ArrayList<Edge>[]) new ArrayList[N];
        for (int i = 0; i < N; i++) {
            vertex[i] = new ArrayList<>();
        }
    }


    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        vertex[v].add(edge);
        vertex[w].add(edge);
        ++edgeCount;
    }

    public Iterable<Edge> adj(int v) {
        return vertex[v];
    }

    public int edgeCount() {
        return edgeCount;
    }

    public Iterable<Edge> edges() {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(vertex[i] != null ) {
                for(Edge e : vertex[i]) {
                    int v = i;
                    int w = e.other(v);
                    if(v<w) edges.add(e);
                }
            }
        }
        return edges;
    }

    public int degree(int v) {
        return vertex[v].size();
    }

    public int size() {
        return N;
    }

}
