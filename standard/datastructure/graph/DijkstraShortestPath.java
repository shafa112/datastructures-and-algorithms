package datastructure.graph;


import java.util.Arrays;

/**
 * Constraints
 * Edge weight non-negative
 *
 * Goal of this is to calculate the shortest path from one vertex to every other vertex
 *
 * https://www.coursera.org/learn/algorithms-part2/lecture/2e9Ic/dijkstras-algorithm
 */
public class DijkstraShortestPath {

    // dijkstra for undirected and unweighted graph
    // We will assume edge weight is 1 unit.
    // source is from vertex to which we need to calculate the shortest distance to every other vertex
    public static int dijkstra(Graph graph, int source, int destination){
        int N = graph.size();
        int[] distance = new int[N];
        int[] parent = new int[N];
        boolean[] visited = new boolean[N];

        // initialize distance to infinity
        // all vertices parent to null
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distance[source] = 0;
        parent[source] = -1;
        relax(graph, source, distance, parent);
        visited[source] = true;

        // -1 because one vertex is already solved which is the source
        // Remaining N-1 nodes to be relaxed
        for(int w = 1; w <= N - 1; w++) {
            //get next vertex which is not visited and have min distance and relax it
            int closestVertex = getNextClosestVertex(distance, visited);
            relax(graph, closestVertex, distance, parent);
            visited[closestVertex] = true;
        }
        return distance[destination];
    }

    private static int getNextClosestVertex(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < distance.length; i++) {
            if(!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * relaxing a vertex v means its shortest distance is finalized,
     * and now we are updating its directly connected vertex w's distance
     * and parent if due to this vertex v there is update in minimum distance of w
     *
     */
    private static void relax(Graph graph, int v, int[] distance, int[] parent) {
        for(int w: graph.adj(v)) {
            // In this graph weight of edge is 1 otherwise we will write distance[v] + weight
            if(distance[w] > distance[v] + 1) {
                distance[w] = distance[v] + 1;
                parent[w]=v;
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.connect(0,1);
        g.connect(0,2);
        g.connect(0,4);
        g.connect(1,5);
        g.connect(4,6);
        g.connect(4,3);
        g.connect(5,6);
        g.connect(7,6);
        System.out.println(dijkstra(g, 2, 6));
    }

}
