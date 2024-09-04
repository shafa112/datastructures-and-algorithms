package algorithm.dynamicprogramming;

public class CoinChange {

    // int coins[]
    // minCoins(n, amount) = Min(minCoins(n-1, amount), 1 + minCoins(n, amount-coin[n));
    public static int coinChange(int[] coins, int amount) {
        Integer dp[][] = new Integer[coins.length][amount + 1];
        return minCoins(coins, coins.length - 1, amount, dp);
    }

    static int minCoins(int[] coins, int n, int amount, Integer dp[][]) {
        if (amount == 0) return 0;
        if (n < 0) return -1;
        if (dp[n][amount] != null) return dp[n][amount];
        int coinCountWithoutIncluding = minCoins(coins, n - 1, amount, dp);
        int coinCountWithIncluding = -1;
        if (coins[n] <= amount) {
            coinCountWithIncluding = minCoins(coins, n, amount - coins[n], dp);
        }
        int coinCount = -1;
        if (coinCountWithoutIncluding != -1 && coinCountWithIncluding != -1) {
            coinCount = Math.min(1 + coinCountWithIncluding, coinCountWithoutIncluding);
        } else if (coinCountWithIncluding != -1) {
            coinCount = Math.max(1 + coinCountWithIncluding, coinCountWithoutIncluding);
        } else {
            coinCount = coinCountWithoutIncluding;
        }
        return dp[n][amount] = coinCount;
    }

    // M(j)=Min(M(j-coins[i]))+1, for all i and j-coin[i]>=0
    // j represents amount
    // In above formula, we are trying the amount with all the coins if that coin is lesser or equal than amount
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

    public static void main(String[] args) {
        int coins[] = {2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }
}
