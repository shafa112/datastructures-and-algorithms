package algorithm.dynamicprogramming;

public class LongestCommonSubstring {

    static int longestCommonSubstring(String s1, String s2){
        int max = 0;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }
                else dp[i][j]=0;
            }
        }
       return max;
    }


    /*
     * if in 2D array solution like above we have prev row, prev col then we can space optimise
     * with 1d array. (like we did in UniquePaths.java line 65)
     *
     *
     *
     * */
    int longestCommonSubstr(String text1, String text2, int m, int n){
        int[] prev = new int[n+1];
        int[] dp;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i<m+1; ++i) {
            dp = new int[n+1];
            for(int j = 1; j<n+1; ++j) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[j] = 1 + prev[j-1];
                max = Math.max(max,dp[j]);
            }
            prev = dp;
        }
        return max;
    }



    // todo: to complete below function, find max like above function by dp-fying the below
    static int longestCommonSubstring(String s1, String s2, int l1, int  l2){
        if(l1==0 || l2==0) return 0;
        if(s1.charAt(l1-1)==s2.charAt(l2-1)) {
            return 1+longestCommonSubstring(s1,s2,l1-1,l2-1);
        } else return 0;
    }



    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ACB";
        System.out.println(longestCommonSubstring(s1, s2));
    }
}
