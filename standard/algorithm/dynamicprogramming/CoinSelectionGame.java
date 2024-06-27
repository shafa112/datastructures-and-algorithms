package algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * f(i,j)=max(
 * coins[i]+min(f(i+2,j),f(i+1,j-1)),
 * coins[j]+min(f(i+1,j-1),f(i,j-2))
 * )
 */
public class CoinSelectionGame {

    public static void main(String[] args) {
        int[] coins = {5, 3, 7, 10};
        System.out.println(countMaximum(coins));
    }

    public static int countMaximum(int[] coins) {
        int dp[][]= new int[coins.length][coins.length];
        for (int i = 0; i < coins.length; i++) Arrays.fill(dp[i], -1);
        return countMaximum(coins,0,coins.length-1,dp);
    }

    private static int countMaximum(int[] coins, int start, int end,int[][] dp) {
        if(start>end) return 0;
        if(dp[start][end]!=-1) return dp[start][end];
        int moneyWhenPickedStart = coins[start]+Math.min(countMaximum(coins, start+2,end,dp),countMaximum(coins,start+1,end-1,dp));
        int moneyWhenPickedEnd = coins[end]+Math.min(countMaximum(coins, start+1,end-1,dp),countMaximum(coins,start,end-2,dp));
        return dp[start][end] = Math.max(moneyWhenPickedStart,moneyWhenPickedEnd);
    }
}
