package datastructure.graph.weighted;

/**
 * This is undirected and weighted edge
 */
public class Edge {

    private final double weight;
    private final int v;
    private final int w;

    public Edge(double weight, int v, int w) {
        this.weight = weight;
        this.v = v;
        this.w = w;
    }

    public double weight() {
        return weight;
    }

    /**
     * Gives either vertex of this edge, in this case we return the vertex v
     */
    public int either() {
        return v;
    }

    /**
     * If on en edge object e and I know one vertex v, what is the other v
     * w = e.other(v)
     */
    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    public String toString() {
        return String.format("%d---%d %.5f", v, w, weight);
    }
}
