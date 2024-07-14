package algorithm.dynamicprogramming;
//DO NOT CHANGE ANY EXISTING CODE IN THIS FILE
//DO NOT CHANGE THE NAMES OF ANY EXISTING FUNCTIONS
public class CoinChangeHW{

    public static int NumberofCoins(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        return minCoin(coins.length-1,coins,amount,dp);

    }

    public static int coinChangeIterativeDifferentApproach(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i=1; i < dp.length; i++) {
            dp[i] = dp.length;
            for (int j=0; j < coins.length; j++) {
                if (i >= coins[j]) dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
            }
        }
        return dp[amount] == dp.length ? -1 : dp[amount];
    }

    public static int minCoin(int n, int[] coins, int amount, Integer[][] dp) {
        if(amount==0) return 0;
        if(n<0) return -1;
        if(dp[n][amount]!=null) return dp[n][amount];
        int excluding = minCoin(n-1,coins,amount,dp);
        int including = -1;
        if(coins[n]<=amount) {
            including = minCoin(n,coins,amount-coins[n],dp);
        }

        int coinChange = -1;
        if(including!=-1 && excluding!=-1) coinChange = Math.min(1+including,excluding);
        else if(including!=-1) coinChange = 1+including;
        else coinChange = excluding;

        return dp[n][amount] = coinChange;

    }

    public static void main(String[] args) {
        int[] denomination = {1,5,10,25};
        int value = 37;
        System.out.println(coinChangeIterativeDifferentApproach(denomination,value)==4);

        int[] denomination1 = {1,6,10};
        int value1 = 11;
        System.out.println(coinChangeIterativeDifferentApproach(denomination1,value1)==2);

        int[] denomination2 = {1,9,15};
        int value2 = 37;
        System.out.println(coinChangeIterativeDifferentApproach(denomination2,value2)==5);

        int[] denomination3 = {1,83,186,408,419};
        int value3 = 6249;
        System.out.println(coinChangeIterativeDifferentApproach(denomination3,value3)==18);

        int[] denomination4 = {1,2,4,6,8,10,12};
        int value4 = 40303;
        System.out.println(coinChangeIterativeDifferentApproach(denomination4,value4)==3360);

        int[] d= {1,5,10,25,50};
        int value5 = 0;
        System.out.println(coinChangeIterativeDifferentApproach(d,value5));
    }
}
