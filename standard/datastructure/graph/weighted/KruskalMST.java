package datastructure.graph.weighted;

import datastructure.unionfind.UnionFind;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A MST (Minimum spanning tree) will have N-1 edge for N vertex in connected graph
 *
 * while N-1 edges are picked
 *     Keep picking up the edge with minimum weight
 *     If the edge creates a cycle ignore that edge otherwise add to your MST
 */
public class KruskalMST {

    private Queue<Edge> mst;
    private double mstWeight;

    public KruskalMST(WeightedGraph graph) {
        mst = new ArrayDeque<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(Edge::weight));
        for(Edge edge: graph.edges()) {
            pq.add(edge);
        }
        UnionFind unionFind = new UnionFind(graph.size());
        while (!pq.isEmpty() && mst.size() < graph.size()-1) {
            Edge edge = pq.remove();
            int v = edge.either();
            int w = edge.other(v);
            if(!unionFind.isConnected(v, w)) {
                mst.add(edge);
                mstWeight+=edge.weight();
                unionFind.union(v, w);
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

        KruskalMST kruskalMST = new KruskalMST(g);
        System.out.println("MST weight " + kruskalMST.getMstWeight());
        for(Edge e: kruskalMST.edges()) {
            System.out.print(e + ", ");
        }
        System.out.println();
    }
}
