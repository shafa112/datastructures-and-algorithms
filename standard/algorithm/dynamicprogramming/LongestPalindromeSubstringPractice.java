package algorithm.dynamicprogramming;

import java.util.Arrays;

public class LongestPalindromeSubstringPractice {


    public static int longestPalindrome(String s) {
        if(s=="") return 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int[] a:dp) {
            Arrays.fill(a,-1);
        }
        int ans =  longestPalindromeSize(s,0,s.length()-1,dp);
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return ans;
    }

    private static int longestPalindromeSize(String s, int i, int j, int[][] dp) {
        if(i>j) return 0;
        if(i==j) return 1;
        int len = 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) {
            len = 2 + longestPalindromeSize(s,i+1,j-1,dp);
        } else {
            len = Math.max(longestPalindromeSize(s,i+1,j,dp),longestPalindromeSize(s,i,j-1,dp));
        }
        return dp[i][j] = len;
    }

    /*
    * TODO: Iterative
    * */
    private static int longestPalindromeSizeIterative(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n-1; i++) {
            for (int j = n-1; j >=1; j--) {
                if(i==j) dp[i][j] = 1;
                if(i<j) {
                    if(s.charAt(i)==s.charAt(j)) {
                        if(i < n-2 && j >= 2) dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        if(i < n-2 && j >= 2) dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }


    public static void main(String[] args) {
        String s ="babade";
        System.out.println(longestPalindrome(s));
        //System.out.println("iter: "+longestPalindromeSizeIterative(s));
    }
}
