package array;

public class BuySellStock2 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        for(int i = n-1 ; i>=0; --i) {
            for(int b = 0; b<=1; ++b) {
                int profit = 0;
                if(b==1) {
                    //you can buy or move to next day
                    profit = Math.max(-1*prices[i]+dp[i+1][0],
                            dp[i+1][1]);

                } else {
                    //you can sell or move to next day
                    profit = Math.max(prices[i]+dp[i+1][1],
                            dp[i+1][0]);
                }
                dp[i][b] = profit;
            }
        }
        return dp[0][1];
    }
}
