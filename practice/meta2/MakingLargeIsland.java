package meta2;

import java.util.HashSet;
import java.util.Set;

public class MakingLargeIsland {

    public static void main(String[] args) {
        int[][] grid = {{1,0}, {1,1}};
        System.out.println("Largest island: "+ largestIsland(grid));
    }

    private static int largestIsland(int[][] grid) {
        int maxLen = Integer.MIN_VALUE;
        //create UF DS and connect the neighbors
        UnionFind uf = new UnionFind(grid.length*grid[0].length);
        connectAll(grid,uf);

        //convert 0 to 1 one by one and check if it forms the largest island;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    //check if any one of the 4 neighbor has value 1
                    // if has value 1, then take its size else don't
                    int len = islandSize(grid,i,j,uf);
                    maxLen = Math.max(maxLen,len);
                }
            }
        }
        return maxLen;
    }

    private static int islandSize(int[][] grid, int i, int j, UnionFind uf) {
        int[][] neighbors = {
                {-1,0}, {0,-1}, {1,0}, {0,1}
        };
        Set<Integer> visitedParent = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        int len = 0;
        for(int p = 0; p < neighbors.length; ++p){
            int x = i + neighbors[p][0];
            int y = j + neighbors[p][1];
            int cellVal = x * grid.length + y;
            if(validIndices(m,n,x,y) && grid[x][y] == 1 && !visitedParent.contains(cellVal)) {
                int root =  uf.root(cellVal);
                visitedParent.add(cellVal);
                len += uf.children[root];
            }
        }
        return len;
    }

    private static void connectAll(int[][] grid, UnionFind uf) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    //union to connect neighbors
                    connectNeighbors(grid,i,j,uf);
                }
            }
        }
    }

    private static void connectNeighbors(int[][] grid, int i, int j, UnionFind uf) {
        if(!validIndices(grid.length, grid[0].length,i,j)) return;
        int[][] neighbors = {
            {-1,0}, {0,-1}, {1,0}, {0,1}
        };

        int n = grid.length;
        int m = grid[0].length;
        int cellVal = i * n + j;
        for(int p = 0; p < neighbors.length; ++p){
            int x = i + neighbors[p][0];
            int y = j + neighbors[p][1];
            int newCellVal = x * n + y;
            if(validIndices(m,n,x,y) && grid[x][y] == 1 && !uf.isConnected(cellVal, newCellVal)) {
                uf.union(cellVal, newCellVal);
            }
        }

    }

    private static boolean validIndices(int m, int n, int i, int j) {
        return false;
    }

    static class UnionFind {
        int[] parent;
        int[] children;

        public UnionFind(int N) {
            parent = new int[N];
            children = new int[N];
            for (int i = 0; i < N; ++i) parent[i] = i;
        }

        public int root(int i) {
            while (i != parent[i]) i = parent[i];
            return i;
        }

        public int rootPathCompression(int i) {
            while (i != parent[i]) i = parent[parent[i]];
            return i;
        }

        public void union(int i, int j) {
            int p = root(i);
            int q = root(j);

            if (p == q) return;
            if (children[p] > children[q]) {
                parent[q] = p;
                children[p] += children[q] + 1;
            } else {
                parent[p] = q;
                children[q] += children[p] + 1;
            }
        }

        public boolean isConnected(int i, int j) {
            return root(i) == root(j);
        }
    }
}



