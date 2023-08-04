package algorithm.dynamicprogramming;

import util.Util;

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
public class DpCountSquareSubMatrices {

    //
    static public int countSquares(int[][] a) {
        int m = a.length; // number of rows
        int n = a[0].length; // number of cols
        int dp[][] = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1][j - 1] == 1) {
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i-1][j-1]);
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }

    static int min(int... x) {
        int minVal = Integer.MAX_VALUE;
        for(int num: x) minVal = Math.min(minVal, num);
        return minVal;
    }

    public static void main(String[] args) {
        int a[][] = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(countSquares(a));
    }
}
