package datastructure.graph;

import datastructure.graph.weighted.Edge;
import datastructure.graph.weighted.WeightedGraph;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Constraints
 * Edge weight non-negative
 *
 * Goal of this is to calculate the shortest path from one vertex to every other vertex
 *
 * https://www.coursera.org/learn/algorithms-part2/lecture/2e9Ic/dijkstras-algorithm
 */
public class DijkstraShortestPathWeightedGraph {

    public static double dijkstra(WeightedGraph graph, int source, int destination){
        int N = graph.size();
        double distance[] = new double[N];
        Edge edgeTo[] = new Edge[N];
        Arrays.fill(distance, Integer.MAX_VALUE);  // initialize distance to infinity
        // prioritizing that vertex which has next minimum distance
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> Double.compare(distance[v1], distance[v2]));
        pq.add(source);
        distance[source] = 0;
        //Note: We are not using visited array because all elements in pq is not visited.
        // Visited means the edges are all relaxed
        // And we are also not adding already visited vertex in pq because the visited vertex already had
        // minimum distance found.
        while (!pq.isEmpty()) {
            int v = getNextClosestVertex(pq);
            relax(graph, v, distance, edgeTo, pq);
        }
        return distance[destination];
    }

    private static int getNextClosestVertex(PriorityQueue<Integer> pq) {
        return pq.remove();
    }

    private static void relax(WeightedGraph graph, int v, double[] distance, Edge edgeTo[], PriorityQueue<Integer> pq) {
        for(Edge edge: graph.adj(v)) {
            int w = edge.other(v);
            if(distance[w] > distance[v]+edge.weight()) {
                distance[w] =  distance[v]+edge.weight();
                edgeTo[w] = edge;
                pq.remove(w);
                pq.add(w);
            }
        }
    }

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph(8);
        g.addEdge(new Edge(0,1, 40));
        g.addEdge(new Edge(0,2, 12));
        g.addEdge(new Edge(0,4, 3));
        g.addEdge(new Edge(1,5, 7));
        g.addEdge(new Edge(4,6, 5));
        g.addEdge(new Edge(2,3, 9));
        g.addEdge(new Edge(3,4, 6));
        g.addEdge(new Edge(5,6, 2));
        g.addEdge(new Edge(6,7, 3));
        System.out.println(dijkstra(g, 0, 7));
    }

}
