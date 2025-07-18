package algorithm.dynamicprogramming;

import util.Util;

// https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromicSubsequence {

    // Solution 1 (recursive)
    static public int longestPalindromeSubseq(String s) {
        if(s==null || s.isEmpty()) return 0;
        int dp[][] = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            for(int j = 0 ; j <s.length();j++) {
                dp[i][j] = -1;
            }
        }
        return solve(s, 0, s.length()-1, dp);
    }

    static int solve(String s, int i, int j, int dp[][]) {
        if(i>j) return 0;
        if(i==j) return dp[i][j] = 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(s, i+1, j-1,dp)+2;
        } else {
            return dp[i][j] = Math.max(solve(s, i+1, j, dp), solve(s, i, j-1,dp));
        }
    }

    // Solution 2 (Iterative)
    static int longestPalindromicSubsequence(String s) {
        int l = s.length(); //length of string
        int dp[][] = new  int[l+1][l]; // first is length and second is start index of checking palindrome
        init(dp);
        for(int k = 2; k < dp.length; k++) {
            for (int i = 0; i < dp[0].length; i++) {
                int j = i+k-1; // last index of string starting at index i and of length k
                if(j < l) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[k][i] = 2 + dp[k-2][i+1];
                    } else {
                        dp[k][i] = Math.max(dp[k-1][i], dp[k-1][i+1]);
                    }
                }
            }
        }
        return dp[l][0];
    }

    // length 0, palindrome length 0
    // length 1, palindrome length 1
    private static void init(int[][] dp) {
        // length 0
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
    }

    public static void main(String[] args) {
        //0,4 = 0,3 or 1,4 or if(0 == 4) 2 + 1,3
        System.out.println(longestPalindromicSubsequence("bbbab"));
    }
}
