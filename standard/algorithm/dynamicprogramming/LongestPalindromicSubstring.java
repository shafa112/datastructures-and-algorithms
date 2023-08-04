package algorithm.dynamicprogramming;

import util.Util;

/**
 * Implemented Method:
 * We will calculate palindrome for each length and the palindrome found for largest length is the answer
 * To calculate palindrome for each length, we will check this from each index till length
 * So, dp[k][i] represents, checking if palindrome of k length from index i in the string
 * dp[k][i] = if (s.charAt(i) == s.charAt(k+i-1)) return dp[k-2][i+1]; else return false;
 *
 * This problem can be solved using longest common substring solution on given string and its reverse.
 */
public class LongestPalindromicSubstring {

    static public String longestPalindrome(String s) {
        int l = s.length(); //length of string
        boolean dp[][] = new  boolean[l+1][l]; // first is length and second is start index of checking palindrome
        initializeDP(dp);
        int maxLengthPalindrome = 1;
        int startIndexOfMaxLengthPalindrome = 0;
        for(int k = 2; k < dp.length; k++) {
            for (int i = 0; i < dp[0].length; i++) {
                if((i+k-1) < l  && s.charAt(i) == s.charAt(i+k-1)) {
                    dp[k][i] = dp[k-2][i+1];
                    if(dp[k][i]) {
                        if(maxLengthPalindrome<k) {
                            maxLengthPalindrome=k;
                            startIndexOfMaxLengthPalindrome=i;
                        }
                    }
                } else dp[k][i]=false;
            }
        }
        Util.printArray(dp);
        return s.substring(startIndexOfMaxLengthPalindrome,startIndexOfMaxLengthPalindrome+maxLengthPalindrome);
    }

    // string of length 0 is palindrome
    // string of length 1 is palindrome for each index
    private static void initializeDP(boolean[][] dp) {
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]=true;
            dp[1][i]=true;
        }
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));

    }
}
