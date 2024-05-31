package algorithm.dynamicprogramming;

import java.util.*;

// Note: There exist n*log(n) solution. Optional
public class LongestIncreasingSubsequence {


    /*
     * lis(i): Means longest increasing subsequence from 0 to index i and including element at index i.
     * lis(i)=1+Max(lis(j)) where 0<=j<=i-1 and a[j]<a[i]
     * Final answer is max of all lis(0), lis(1),..., lis(i),..lis(n-1)
     * Complexity: O(n^2)
     */
    public static int lis(int[] a) {
        int[] dp = new int[a.length];
        dp[0] = 1;
        for (int i = 1; i < a.length; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i] && dp[j] + 1 > max) max = dp[j] + 1;
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

    /*
     * Recursive Solution
     * Time: 2^n
     * Auxiliary stack space: O(n)
     * */
    static int longestIncreasingSubsequence(int a[]) {
        return longestIncreasingSubsequence(a, a.length - 1, Integer.MAX_VALUE);
    }

    static int longestIncreasingSubsequence(int a[], int n, int maxVal) {
        if (n == 0) {
            if (a[n] < maxVal) return 1;
            else return 0;
        }
        if (a[n] >= maxVal) {
            return longestIncreasingSubsequence(a, n - 1, maxVal);
        }
        return Math.max(1 + longestIncreasingSubsequence(a, n - 1, a[n]), longestIncreasingSubsequence(a, n - 1, maxVal));
    }


    /*
    * DP-fied using Hashmap because with dp array[n,maxVal] maxVal can be negative, but then it can't be an index.
    * Here, we can create unique key for Hashmap using getKey function return string of n and maxVal
    *
    * This solution is intuitive but gives Time Limit Exceeded on leetcode
    *
    * */
    static int longestIncreasingSubsequenceDP(int a[]) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        Map<String,Integer> map = new HashMap<>();
        return longestIncreasingSubsequenceDP(a, a.length - 1, max + 1, map);
    }

    static int longestIncreasingSubsequenceDP(int a[], int n, int maxVal, Map<String,Integer> map) {
        String key = getKey(n, maxVal);
        if(map.containsKey(key)) return map.get(key);
        if (n == 0) {
            if (a[n] < maxVal) {
                map.put(key, 1);
                return 1;
            }
            else {
                map.put(key, 0);
                return 0;
            }
        }
        int ans = -1;
        if (a[n] >= maxVal) {
            ans = longestIncreasingSubsequenceDP(a, n - 1, maxVal, map);
        } else {
            ans = Math.max(1 + longestIncreasingSubsequenceDP(a, n - 1, a[n], map), longestIncreasingSubsequenceDP(a, n - 1, maxVal, map));
        }
        map.put(key, ans);
        return ans;
    }

    private static String getKey(int n, int maxVal) {
        return n+"#"+maxVal;
    }


    /*
     * Youtuber Strivers' approach starts from here
     * Recursive solution:
     * Time: 2^n
     * Auxiliary stack space: O(n)
     * */
    public int lengthOfLIS1(int[] nums) {
        return LIS1(nums, 0, -1);
    }

    public int LIS1(int[] nums, int index, int prev) {
        if (index >= nums.length) return 0;
        int len = LIS1(nums, index + 1, prev);
        if (prev == -1 || nums[index] > nums[prev]) {
            len = Math.max(len, 1 + LIS1(nums, index + 1, index));
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
        // n -> in above recursion index goes from 0 to n-1 that is why n rows
        //n+1 -> since we have prev index as negative as per above approach we change the
        // indexes from -1, 0, 1..n-1 to 0, 1, 2..n and that is why n+1 cols
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return LIS2(nums, 0, -1, dp);
    }

    public int LIS2(int[] nums, int index, int prev, int[][] dp) {
        if (index >= nums.length) return 0;
        if (dp[index][prev + 1] != -1) return dp[index][prev + 1];
        int len = LIS2(nums, index + 1, prev, dp);
        if (prev == -1 || nums[index] > nums[prev]) {
            len = Math.max(len, 1 + LIS2(nums, index + 1, index, dp));
        }
        return dp[index][prev + 1] = len;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 2, 3};
        System.out.println(longestIncreasingSubsequenceDP(a));
    }

}
