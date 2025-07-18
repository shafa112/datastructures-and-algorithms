package meta2;
import java.util.*;

public class ShortestPathBinaryMat {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;


        Deque<int[]> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][n];

        q.add(new int[]{0,0,1});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cell = q.remove();
            int i = cell[0];
            int j = cell[1];
            int len = cell[2];

            //if(Math.min(i,j) < 0 || Math.max(i,j) >= n || grid[i][j] == 1) continue;
            if(i == n-1 && j == n-1) return len;
            int[][] neighbors = {
                    {-1, -1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}
            };

            for(int k = 0; k < neighbors.length; ++k) {
                int x = neighbors[k][0] + i;
                int y = neighbors[k][1] + j;

                if(isValidIndex(x,y,n) && grid[x][y]==0 && !visited[x][y]) {
                    q.add(new int[]{x,y,len+1});
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }

    private boolean isValidIndex(int i, int j, int n) {
        return i >= 0 && i < n && j >=0 && j < n;
    }
}