package datastructure.graph.weighted;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A MST (Minimum spanning tree) will have N-1 edge for N vertex in connected graph
 * <p>
 * Start with vertex 0 and greedily grow tree T
 * Add to T the min weight edge with exactly one endpoint in T
 * Repeat until V-1
 *
 * https://www.coursera.org/learn/algorithms-part2/lecture/HoHKu/prims-algorithm
 *
 * TODO: Watch eager PrimMST implementation
 */
public class LazyPrimMST {

    private boolean visited[];
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;
    private double mstWeight;

    public LazyPrimMST(WeightedGraph weightedGraph) {
        int N = weightedGraph.size();
        visited = new boolean[N];
        mst = new ArrayDeque<>();
        pq = new PriorityQueue<>(Comparator.comparingDouble(Edge::weight));
        visit(weightedGraph, 0);

        while (!pq.isEmpty() && mst.size() < N - 1) {
            Edge edge = pq.remove();
            int v = edge.either();
            int w = edge.other(v);
            if(visited[v] && visited[w]) continue;
            mst.add(edge);
            mstWeight+=edge.weight();
            if(!visited[v]) visit(weightedGraph, v);
            if(!visited[w]) visit(weightedGraph, w);
        }
    }

    private void visit(WeightedGraph g, int v) {
        visited[v] = true;
        for (Edge e : g.adj(v)) {
            int w = e.other(v);
            if (!visited[w]) {
                pq.add(e);
            }
        }
    }

    public double getMstWeight() {
        return mstWeight;
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph(5);
        g.addEdge(new Edge(0,1,9));
        g.addEdge(new Edge(0,2,12));
        g.addEdge(new Edge(1,2,6));
        g.addEdge(new Edge(1,3,18));
        g.addEdge(new Edge(1,4,20));
        g.addEdge(new Edge(2,4,15));

        LazyPrimMST lazyPrimMST = new LazyPrimMST(g);
        System.out.println("MST weight " + lazyPrimMST.getMstWeight());
        for(Edge e: lazyPrimMST.edges()) {
            System.out.print(e + ", ");
        }
        System.out.println();
    }


}
