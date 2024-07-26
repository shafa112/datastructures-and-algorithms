package ibmShebi;

/**
 * mxn matrix
 * cell - [0,0] reach to the last cell - MXN
 * Every cell has value associated. +ve, -ve. When you hit the cell. You have to accumulate that value.
 * Maximize the accumulation. Can traverse to the right or bottom
 *
 */
public class MaxGridSumFrom00CellMNCell {

    //recursive
    int getMaxSum(int[][] a) {
        Integer[][] dp = new Integer[a.length][a[0].length];
        return getMaxSum(a, a.length - 1, a[0].length - 1, dp);
    }

    int getMaxSum(int[][] a, int m, int n, Integer[][] dp) {
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != null) return dp[m][n];
        if (m == 0 && n == 0) return a[m][n];
        dp[m][n] = Math.max(a[m][n] + getMaxSum(a, m - 1, n, dp), a[m][n] + getMaxSum(a, m, n - 1, dp));
        return dp[m][n];
    }

    //iterative
    int getMaxSumIterative(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        //initializing 0th row

        dp[0][0] = a[0][0];
        for (int i = 1; i < a[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + a[0][i];
        }

        //initializing 0th col
        for (int i = 1; i < a[0].length; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                dp[i][j] = Math.max(a[i][j] + dp[i - 1][j], a[i][j] + dp[i][j - 1]);
            }
        }
        return dp[a.length - 1][a[0].length - 1];
    }
}
