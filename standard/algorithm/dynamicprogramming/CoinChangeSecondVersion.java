package algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * Number of combinations that add to amount
 * f(n,amount) = f(n,amount-coins[n]) + f(n-1,amount)
 *
 *
 */
public class CoinChangeSecondVersion {

    public static int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) Arrays.fill(dp[i],-1);
        return numberOfCombinations(coins,coins.length-1,amount,dp);
    }

    private static int numberOfCombinations(int[] coins, int n, int amount,int [][] dp) {
        if(amount==0) return 1;
        if(n<0) return 0;
        if(dp[n][amount]!=-1) return dp[n][amount];
        int excludingNthCoin = numberOfCombinations(coins,n-1,amount,dp);
        int includingNthCoin = 0;
        if(coins[n]<=amount){
            includingNthCoin = numberOfCombinations(coins,n,amount-coins[n],dp);
        }
        return dp[n][amount] = excludingNthCoin+includingNthCoin;
    }

    public static int combinationIterative(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i<coins.length; ++i) dp[i][0]=1; // for 0 amount we have one combination(empty set)
        for(int i=0; i< coins.length; ++i) {
            for(int j = 1; j < amount+1; ++j) {
                if(i==0) {
                    if(j%coins[i]==0) dp[i][j] = 1;
                }
                else if(coins[i]>j) dp[i][j] = dp[i-1][j];
                else if(coins[i]<=j) {
                    dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j];
                }
            }
        }
        return dp[coins.length-1][amount];
    }

    public static void main(String[] args) {
        int[] coins= {1,2,5};
        int amount = 5;
        System.out.println(change(amount,coins));
        System.out.println(combinationIterative(amount,coins));
    }
}
