package meta;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* TC, SC: O(R*C)
* */
public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] != 0 || grid[m-1][n-1] != 0) return -1;
        int[][] neighbors = {
                {-1,1},
                {0, 1},
                {1, 1},
                {1,  0},
                {1, -1},
                {0, -1},
                {-1, -1},
                {-1, 0}
        };

        Queue<Distanceij> q = new ArrayDeque<>();
        q.add(new Distanceij(0,0,1));

        grid[0][0] = 1;

        while(!q.isEmpty()) {
            Distanceij dij = q.remove();
            int x = dij.i;
            int y = dij.j;
            int distance = dij.distance;

            if(x == m-1 && y == n-1) return distance;
            else {
                for(int i = 0; i < neighbors.length; ++i) {
                    int new_x = neighbors[i][0] + x;
                    int new_y = neighbors[i][1] + y;

                    if(isValid(new_x, new_y, m, n) && grid[new_x][new_y] == 0) {
                        q.add(new Distanceij(new_x, new_y, distance + 1));
                        grid[new_x][new_y] = 1;
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class Distanceij
    {
        int i;
        int j;
        int distance;
        public Distanceij(int i, int j, int distance) {
            this. i = i;
            this.j = j;
            this.distance = distance;
        }
    }
}
