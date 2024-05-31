package algorithm.dynamicprogramming;

import util.Util;

import java.util.Arrays;

public class LongestCommonSubsequence {

    /*
     * Recursive Solution:
     * Time : O(2^(m+n))
     * Space: m+n
     * */
    public int longestCommonSubseq(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] a: dp) Arrays.fill(a,-1);
        return longestCommonSubseq(s1, s1.length() - 1, s2, s2.length() - 1,dp);
    }

    public int longestCommonSubseq(String s1, int n1, String s2, int n2, int[][] dp) {
        if(n1 < 0 || n2 < 0) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];
        int len = 0;
        if (s1.charAt(n1) == s2.charAt(n2)) {
            len = 1 + longestCommonSubseq(s1, n1 - 1, s2, n2 - 1,dp);
        } else {
            len = Math.max(longestCommonSubseq(s1,n1-1,s2,n2,dp),longestCommonSubseq(s1,n1,s2,n2-1,dp));
        }
        return dp[n1][n2] = len;
    }


    // DP with tabulation //removes the auxiliary stack space
    // Time: mn
    // Space: (mn)
    //
    // "abcde" "afce"
    // lcs is ace and length of the longest common subsequence is 3
    /*
     * dp[i][j]= {
     *            dp[i-1][j-1]+1 ,if i and j > 0 and s1[i]=s2[j]
     *            max(dp[i][j-1], dp[i-1][j]) , if s1[i]!=s2[j]
     *          }
     */
    public static int longestCommonSubsequenceIterative(String s1, String s2) {
        int n1 = s1.length() + 1;
        int n2 = s2.length() + 1;
        int[][] dp = new int[n1][n2];
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n1-1][n2-1];
    }

    public static void main(String[] args) {
        String s1 = "bb";
        String s2 = "jb";
        System.out.println(longestCommonSubsequenceIterative(s1, s2));
    }
}
