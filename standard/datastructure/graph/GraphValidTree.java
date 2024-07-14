package datastructure.graph;

import datastructure.unionfind.UnionFind;

public class GraphValidTree {

    /**
     *
     * @param n
     * @param edges
     * @return
     *
     * A graph is a valid tree if all vertices are connected and graph has no cycle.
     */
    public boolean validTree(int n, int[][] edges) {
        if(n==0) return true;

        //create graph with edges given
        Graph g = new Graph(n);
        for (int[] edge: edges) {
            g.connect(edge[0],edge[1]);
        }

        //check if graph is connected
        //if we do dfs/bfs from any vertex then all vertices should get visited if the graph is connected
        boolean[] visited = new boolean[n];
        dfs(0,g,visited);
        for (boolean visit: visited) {
            if(!visit) return false;
        }

        //check if graph has cycle
        UnionFind uf = new UnionFind(n);
        for (int i =0; i<edges.length; ++i) {
            if(uf.isConnected(edges[i][0],edges[i][1])) return false;
            else uf.union(edges[i][0],edges[i][1]);
        }
        return true;
    }

    private void dfs(int v, Graph g, boolean[] visited) {
        visited[v] = true;
        for(int u: g.adj(v)) {
            if(!visited[u]) dfs(u,g,visited);
        }
    }
}
