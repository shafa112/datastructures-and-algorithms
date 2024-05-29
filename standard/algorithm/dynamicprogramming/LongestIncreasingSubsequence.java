package algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

// Note: There exist n*log(n) solution. Optional
public class LongestIncreasingSubsequence {

    /*
    * Recursive solution:
    * Time: 2^n
    * Auxillary stack space: O(n)
    * */
    public int lengthOfLIS1(int[] nums) {
        return LIS1(nums,0,-1);
    }

    public int LIS1(int[] nums, int index, int prev) {
        if(index>=nums.length) return 0;
        int len = LIS1(nums, index+1, prev);
        if(prev==-1 || nums[index] > nums[prev]) {
            len = Math.max(len, 1 + LIS1(nums,index+1,index));
        }
        return len;
    }

    /*
    * DP with Recursion:
    * Time: O(n^2)
    * Space: stack space, O(n) + dp array space, O(n^2)
    * */
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }
        return LIS2(nums,0,-1,dp);
    }

    public int LIS2(int[] nums, int index, int prev, int[][] dp) {
        if(index>=nums.length) return 0;
        if(dp[index][prev+1]!=-1) return dp[index][prev+1];
        int len= LIS2(nums, index+1, prev,dp);
        if(prev==-1 || nums[index] > nums[prev]) {
           len = Math.max(len, 1 + LIS2(nums,index+1,index,dp));
        }
        return dp[index][prev+1]=len;
    }


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
