package meta;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryGridBFS2 {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) return -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0));
        visited[0][0] = true;
        int level = 1;
        while(!q.isEmpty()) {
            System.out.println("Processing level " + level);
            int sizeAtThisLevel = q.size();
            while(sizeAtThisLevel-->0) {
                Pair p1 = q.remove();
                if(p1.i == m-1 && p1.j == n-1) {
                    return level;
                }
                addReachableNeighbours(q, p1, grid, visited);
            }
            level++;
        }
        return -1;
    }

    private static void addReachableNeighbours(Queue<Pair> q, Pair p, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] neighbours = {
                {-1, -1},{-1, 0},{-1, 1},
                {0, -1},{0, 1},
                {1, -1},{1, 0}, {1, 1}
        };

        int i = p.i;
        int j = p.j;
        for (int k = 0; k < neighbours.length; k++) {
            int i1 = i + neighbours[k][0];
            int j1 = j + neighbours[k][1];
            if(validIndices(i1,j1,m,n) && grid[i1][j1] == 0 && !visited[i1][j1]) {
                q.add(new Pair(i1, j1));
                visited[i1][j1] = true;
            }
        }
    }

    private static boolean validIndices(int i, int j, int m, int n) {
        if(i < 0 || i>=m || j < 0 || j>=n) return false;
        return true;
    }


    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        ShortestPathInBinaryGridBFS2 s = new ShortestPathInBinaryGridBFS2();
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
