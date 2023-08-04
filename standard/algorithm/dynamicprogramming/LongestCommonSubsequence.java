package algorithm.dynamicprogramming;

import util.Util;

public class LongestCommonSubsequence {

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

    // dp-fy it later
    public static int lcsRecursive(String s1, String s2, int l1, int l2) {
        if(l1 == 0 || l2 == 0) return 0;
        if(s1.charAt(l1-1) == s2.charAt(l2-1)) {
            return 1 + lcsRecursive(s1, s2, l1-1, l2-1);
        } else {
            return Math.max(lcsRecursive(s1, s2, l1, l2-1), lcsRecursive(s1, s2, l1-1, l2));
        }
    }

    public static void main(String[] args) {
        String s1 = "bb";
        String s2 = "jb";
        System.out.println(lcs(s1, s2));
    }
}
