package algorithm.dynamicprogramming;

import util.Util;

import java.util.Arrays;

public class LongestCommonSubsequence {

    /*
     * Recursive Solution:
     * Time : O(2^(m+n))
     * Space: m+n
     * */
    public int longestCommonSubsequence1(String text1, String text2) {
        return LCSubsequence1(text1,text2,0,0);
    }

    public int LCSubsequence1(String text1, String text2, int i, int j) {
        if(i>=text1.length() || j>=text2.length()) return 0;
        int len = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            len =  1 + LCSubsequence1(text1, text2, i+1, j+1);
        } else {
            len = Math.max(
                    LCSubsequence1(text1,text2,i,j+1),
                    LCSubsequence1(text1,text2,i+1,j)
            );
        }
        return len;
    }

    /*
     * Dp with Recursive Solution:
     * Time : O(m*n)
     * Space: m+n + m*n
     * */
    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] a:dp) {
            Arrays.fill(a,-1);
        }
        return LCSubsequence2(text1,text2,0,0,dp);
    }

    public int LCSubsequence2(String text1, String text2, int i, int j,int[][] dp) {
        if(i>=text1.length() || j>=text2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int len = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            len =  1 + LCSubsequence2(text1, text2, i+1, j+1,dp);
        } else {
            len = Math.max(
                    LCSubsequence2(text1,text2,i,j+1,dp),
                    LCSubsequence2(text1,text2,i+1,j,dp)
            );
        }
        return dp[i][j]=len;
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
    public static int lcs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        Util.printArray(dp);
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "bb";
        String s2 = "jb";
        System.out.println(lcs(s1, s2));
    }
}
