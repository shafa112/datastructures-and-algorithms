package meta;

import util.Util;

public class ShortestPathInBinaryGrid {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        ShortestPathInBinaryGrid s = new ShortestPathInBinaryGrid();
        System.out.println(s.shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) return -1;
        int m = grid.length + 1;
        int n = grid[0].length + 1;
        int[][] dp = new int[m][n];
        init(dp);
        if(grid[0][0] == 0) dp[1][1]=1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
//                System.out.println("i="+i +", j="+j);
                if(grid[i-1][j-1] == 0) {
//                    System.out.println("Updating dp");
                    updateIJ(dp, i, j, grid);
//                    Util.printArray(dp);
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        return dp[m-1][n-1];
    }

    private void updateIJ(int[][] dp, int i, int j,int[][] grid) {
        int m = dp.length;
        int n = dp[0].length;
        int[][] neighbours = {
                {-1, -1},{-1, 0},{-1, 1},
                {0, -1},{0, 1},
                {1, -1},{1, 0}, {1, 1}
        };
        for (int k = 0; k < neighbours.length; k++) {
            int i1 = i + neighbours[k][0];
            int j1 = j + neighbours[k][1];
            if(validIndices(i1,j1,m,n)) {
                if(dp[i1][j1] != -1) {
                    if(dp[i][j] == -1) {
                        dp[i][j] = 1 + dp[i1][j1];
                    } else
                    dp[i][j] = Math.min(1+dp[i1][j1], dp[i][j]);
                }
            }
        }
    }

    private static boolean validIndices(int i, int j, int m, int n) {
        if(i < 0 || i>=m || j < 0 || j>=n) return false;
        return true;
    }

    private void init(int[][] dp) {
        for (int i =0; i< dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0]=0;
    }
}
