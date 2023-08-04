package algorithm.dynamicprogramming;

import java.util.Arrays;

// Note: There exist n*log(n) solution. Optional
public class LongestIncreasingSubsequence {

    /*
     * lis(i)=1+Max(lis(j)) where 0<=j<=i-1 and a[j]<a[i]
     * Complexity: O(n^2)
     */
    public static int lis(int[] a) {
        int[] dp = new int[a.length];
        dp[0] = 1;
        for (int i = 1; i < a.length; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) if (dp[j] + 1 > max) max = dp[j] + 1;
            }
            dp[i] = max;
        }
        return max(dp);
    }

    private static int max(int[] dp) {
        int max = -1;
        for (int data : dp) max = (max < data) ? max = data : max;
        return max;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 2, 3};
        System.out.println(lis(a));
    }

}
