package algorithm.dynamicprogramming;

import java.util.Arrays;

public class UniquePathsSecondVersion {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length-1;
        int n = obstacleGrid[0].length-1;
        int dp[][] = new int[m+1][n+1];
        for(int i = 0 ; i <= m; i++) Arrays.fill(dp[i], -1);
        dp[0][0] = 1;
        if(obstacleGrid[m][n] == 1) return 0;
        return uniquePathsWithObstacles(obstacleGrid,m,n, dp);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n, int dp[][] ) {
        if(n<0 || m<0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        int numberOfUniquePaths = 0;
        if(m>=1 && obstacleGrid[m-1][n] != 1) {
            numberOfUniquePaths=  uniquePathsWithObstacles(obstacleGrid,m-1,n, dp);
        }
        if(n>=1 && obstacleGrid[m][n-1] != 1) {
            numberOfUniquePaths +=  uniquePathsWithObstacles(obstacleGrid,m,n-1, dp);
        }
        return dp[m][n] = numberOfUniquePaths;
    }

    public static void main(String[] args) {
         int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] obstacleGrid = {{0,1,0}};
//        int[][] obstacleGrid = {{0,0},{0,1}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
