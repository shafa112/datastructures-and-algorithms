package algorithm.dynamicprogramming;


import util.Util;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * isSubset(a,n,targetSum) = isSubset(a,n-1,targetSum) || isSubset(a,n-1,targetSum-a[n]);
 *                          //excluding nth index element to check isSubset uptil nth index
 *                          // including nth index element to check isSubset uptil nth index
 */
public class SubsetSum {

    private static boolean isSubset(int[] a,int n, int targetSum) {
        if(n<0) return false;
        if(targetSum==0) return true;
        return isSubset(a,n-1,targetSum) || isSubset(a,n-1,targetSum-a[n]);
    }

    // Complexity: O(n*sum)
    private static Boolean isSubsetDP(int[] a,int n, int sum,Boolean dp[][]) {
        if(sum == 0) return true;
        if(n < 0 || sum < 0) return false;
        if(dp[n][sum] != null)  return dp[n][sum];
        dp[n][sum] = isSubsetDP(a,n-1,sum-a[n],dp) || isSubsetDP(a,n-1,sum,dp);
        return dp[n][sum];
    }

    // int a[]
    // dp[n][sum] = dp[n-1][sum] || dp[n-1][sum-a[n]]
    // Above dp[n][sum] means in array a[] from index 0 to n do we have a subset which addition is equal to sum
    public static Boolean isSubsetDPIterative(int[] a, int sum) {
        if(sum == 0) return true;
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
//        Util.printArray(dp);
        return dp[a.length-1][sum];
    }

    public static void main(String[] args) {
        int[] a = {10, 1, 2};
        int sum = 3;
        System.out.println(isSubsetDPIterative(a, sum));
    }

}
