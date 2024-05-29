package algorithm.dynamicprogramming;

import java.util.Arrays;

public class UniquePaths2 {

    /*
     * Recursive solution :
     * Time: O(2^(m*n)) // as for every cell(m,n) we have 2 choices if only recursion and no dp;
     * Stack space: length of path = (m-1) + (n-1)
     *
     *
     *
     * DP with Recursion:
     * Time: m*n // call for each cell dp[i][j]
     * Stack space: length of path = (m-1) + (n-1) + m*n(for dp array)
     *
     * */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; ++i) {
            Arrays.fill(dp[i],-10);
        }
        return uniquePathsWithObstacles1(m-1,n-1,dp,obstacleGrid);
    }

    public static int uniquePathsWithObstacles1(int m, int n,int[][] dp, int[][] grid) {
        if(m>=0 && n>=0 && grid[m][n]==1) return 0;
        if(n<0 || m<0) return 0;
        if(dp[m][n]!=-10) return dp[m][n];
        if(m == 0 && n == 0) return 1;
        return dp[m][n] = uniquePathsWithObstacles1(m-1,n,dp,grid)+uniquePathsWithObstacles1(m,n-1,dp,grid);
    }


    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else if(i==0 && j==0) dp[i][j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }



    /*
    * Approach similar to dp plus recursion
    * */
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; ++i) {
            Arrays.fill(dp[i],-10);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j]==1) dp[i][j] = -1;
            }
        }
        return UniquePathWithObstacle3(dp,m-1,n-1);
    }

    public int UniquePathWithObstacle3(int[][] dp, int m, int n) {
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        if(dp[m][n]==-1) return 0;
        if(dp[m][n]!=-10) return dp[m][n];
        int up = UniquePathWithObstacle3(dp,m-1,n);
        int left = UniquePathWithObstacle3(dp,m,n-1);
        return dp[m][n] = up + left;
    }
}
