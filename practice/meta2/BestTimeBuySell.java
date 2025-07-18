package meta2;

public class BestTimeBuySell {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for(int i = prices.length - 1; i >= 0; --i) {
            if( max < prices[i]) max = prices[i];
            if(prices[i] < max) {
                profit = Math.max(profit,max-prices[i]);
            }
        }
        return profit;
    }
}