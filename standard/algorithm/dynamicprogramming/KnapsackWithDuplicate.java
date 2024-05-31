package algorithm.dynamicprogramming;

import util.Util;

import java.util.Arrays;

/**
 * Knapsack with duplicate (Each item can be picked multiple times till capacity of knapsack is reached)
 * int wt[], int price[]
 * profit(n, c) = max(profit(n-1, c), price[n]+profit(n, c-wt[n]);
 */
public class KnapsackWithDuplicate {

    public static int maxProfitDp(int n, int capacity, int[] weights, int[] price) {
        int dp[][] = new int[n][capacity+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return maxProfitDp(n-1, capacity, weights, price, dp);
    }

    public static int maxProfitDp(int n, int capacity, int[] weights, int[] price, int[][] dp) {
        if (n < 0 || capacity < 0) return 0;
        if(dp[n][capacity] != -1) return dp[n][capacity];
        int profit = maxProfitDp(n - 1, capacity, weights, price, dp);
        if(weights[n] <= capacity) {
            profit = Math.max(profit, price[n] + maxProfitDp(n, capacity - weights[n], weights, price, dp));
        }
        return dp[n][capacity] = profit;
    }

    // dp[n][c] = max(dp[n-1][c], profit[n]+dp[n][c-wt[n]])
    public static int maxProfitDpIterative(int n, int capacity, int[] weights, int[] price) {
        int dp[][] = new int[n][capacity+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= capacity; j++) {
                if(i==0) {
                    // first element can be picked multiple times
                    dp[i][j] = j/weights[i]*price[i];
                }
                else if(weights[i] > j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], price[i]+dp[i][j-weights[i]]);
                }
            }
        }
         Util.printArray(dp);
        return dp[n-1][capacity];
    }

    public static void main(String[] args) {
//        int c = 4;
//        int price[] = {5, 7, 9};
//        int wt[] = {2, 70, 100};
        int c = 3;
        int price[] = {1, 1};
        int wt[] = {2, 1};
        System.out.println(maxProfitDpIterative(price.length, c, wt, price));
    }
}
