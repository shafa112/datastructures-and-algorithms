package datastructure.graph;

import datastructure.graph.weighted.Edge;
import datastructure.graph.weighted.WeightedGraph;

public class GraphTest {

    public static void main(String[] args) {
        //testUndirectedUnweightedGraph();
        testUndirectedWeightedGraph();
    }

    private static void testUndirectedWeightedGraph() {
        WeightedGraph g = new WeightedGraph(4);
//        g.addEdge(new Edge(10,0,1));
//        g.addEdge(new Edge(7,0,2));
//        g.addEdge(new Edge(20,0,3));
//        g.addEdge(new Edge(4,1,2));

        for (Edge e : g.edges()) {
            int v = e.either();
            int w = e.other(v);
            System.out.print(v+"---"+e.weight()+"---"+w);
            System.out.println();
        }


    }

    static void testUndirectedUnweightedGraph() {
        Graph g = new Graph(8);
        g.connect(2,3);
        g.connect(2,5);
        g.connect(2,4);
        g.connect(3,5);
        g.connect(4,7);

        System.out.println("Adj of 4");
        for(Integer v : g.adj(4)) {
            System.out.print(v+" ");
        }
        System.out.println();

        System.out.println("Adj of 2");
        for(Integer v : g.adj(2)) {
            System.out.print(v+" ");
        }
        System.out.println();

        System.out.println("Adj of 5");
        for(Integer v : g.adj(5)) {
            System.out.print(v+" ");
        }
        System.out.println();

        System.out.println("Adj of 7");
        for(Integer v : g.adj(7)) {
            System.out.print(v+" ");
        }
        System.out.println();


    }
}
