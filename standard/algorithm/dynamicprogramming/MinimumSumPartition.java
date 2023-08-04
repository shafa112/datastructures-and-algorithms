package algorithm.dynamicprogramming;

import util.Util;

import java.util.Arrays;

/**
 * We will have two partition p1 and p2 with sum s1 and s2 respectively. We call p1 one with lower sum i.e. s1 <= s2
 * Let's say, K = total sum of array / 2 # i.e. half the sum of array
 * We will find the closes partition p1 which is closes to K. That will also give the minDiff
 * i.e. s2-s1 for the partition p1 closest to K.
 * How do we find p1 whose sum is closes to K.
 * We know sum of p1 <= K because p1 sum is not greater than p2 sum (As we have chosen)
 * Now to find the p1 with clos-est sum to K.
 * we will call isSubsetSum(a, K), isSubsetSum(a, k-1)...., isSubsetSum(a, 0)
 * The first to give true in the above order is our answer p1 and sum will be
 * second argument in the above function returning true i.e. isSubsetSum(a, x) giving true so p1 sum is x.
 *
 * p2 sum = total sum of a - x
 * minDiff = p2 sum - p1 sum
 */
public class MinimumSumPartition {

    // Solution 1: As per comments write above clas...s
    public static int minDiffUsingSubsetSum(int a[]) {
        int totalSum = Arrays.stream(a).sum();
        int K = totalSum/2;
        Boolean dp[][] = calculateSubsetDPIterative(a, K);
        for(int sum = K ; sum >=0 ; sum--) {
            if(dp[a.length-1][sum]) {
                int partitionOneSum = sum;
                int partitionTwoSum = totalSum - sum;
                return partitionTwoSum - partitionOneSum;
            }
        }
        return Integer.MAX_VALUE;
    }
    public static Boolean[][] calculateSubsetDPIterative(int[] a, int sum) {
        Boolean dp[][] = new Boolean[a.length][sum+1];
        for(int i=0; i< a.length; i++) {
            for(int j = 0; j <= sum; j++) {
                if(j == 0) dp[i][j] = true;
                else if(i == 0) {
                    // first element is equal to the sum itself
                    dp[i][j] = a[i] == j ? true : false;
                } else if(a[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-a[i]];
                }
            }
        }
        return dp;
    }

    // Solution 2
    public static int minDiff(int a[]) {
        // constant and half the total sum. We will pass this constant to recursive function
        int totalSum = Arrays.stream(a).sum();
        int K = totalSum/2;
        int dp[][] = new int[a.length][K+1];
        for(int i = 0; i < a.length; i++) Arrays.fill(dp[i], -1);
        int minDiffFromK = minDiff(a, a.length - 1, 0, K, dp);
        int leftPartitionSum = K - minDiffFromK;
        int rightPartitionSum = totalSum - leftPartitionSum;
        return rightPartitionSum - leftPartitionSum;
    }

    static int minDiff(int a[], int n, int sumYet, int K, int dp[][]) {
        if(sumYet > K) return Integer.MAX_VALUE;
        if(n < 0) return K - sumYet;
        if(dp[n][sumYet] != -1) {
            return dp[n][sumYet];
        }
        dp[n][sumYet] = K - sumYet;
        dp[n][sumYet] = Math.min(dp[n][sumYet], minDiff(a, n-1, sumYet, K, dp));
        if(a[n] <= K) {
            dp[n][sumYet] = Math.min(dp[n][sumYet], minDiff(a, n-1, sumYet+a[n], K, dp));
        }
        return dp[n][sumYet];
    }


    public static void main(String[] args) {
        // {20, 20}=40 and {16,18,19}=53. Answer = 13
        // int a[] = {20, 19, 18, 20, 16};
        // Util.printArray(a);
        int a[] = {1};
        System.out.println(minDiffUsingSubsetSum(a));
    }
}
