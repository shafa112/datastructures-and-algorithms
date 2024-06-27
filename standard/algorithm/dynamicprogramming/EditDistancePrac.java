package algorithm.dynamicprogramming;

public class EditDistancePrac {


    /*
     * Note: Consider below ith string is getting converted to jth string
     * Also, insertion/deletion/replacement operation is taking place in ith string
     *
     * Insertion case
     * After a character is inserted to i that means i+1 character is good now with respect to j,
     * and now we are left with problem i, j-1
     *
     * Deletion case
     * After a character is deleted in ith string, we are left i-1
     *
     * e(i,j) = Min { e(i-1, j) + D
     *                e(i, j-1) + I
     *                e(i-1, j-1) + R if(first[i]!=second[j])
     *                e(i-1, j-1) if(first[i]=second[j])
     *              }
     *
     * d : deletion cost
     * r : replacement cost
     * i : insertion cost
     */


    /*
    * recursive
    *
    * */
    public int minDistance(String s1, String s2) {
        return minDistance(s1,s1.length()-1,s2,s2.length()-1);
    }

    public int minDistance(String s1, int n1, String s2, int n2) {
        if(n1<0) return n2+1;
        if(n2<0) return n1+1;
        if(s1.charAt(n1) == s2.charAt(n2)) {
            return minDistance(s1, n1-1, s2, n2-1);
        } else {
            return min(
                    1 + minDistance(s1,n1,s2,n2-1), //insert
                        1 + minDistance(s1, n1-1,s2,n2), //delete
                        1+ minDistance(s1,n1-1,s2,n2-1) //replace
            );
        }
    }

    public int minDistanceDP(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        return minDistanceDP(s1,s1.length()-1,s2,s2.length()-1,dp);
    }

    public int minDistanceDP(String s1, int n1, String s2, int n2, int[][] dp) {
        if(n1<0) return n2+1;
        if(n2<0) return n1+1;
        if(dp[n1][n2]!=0) return dp[n1][n2];
        if(s1.charAt(n1) == s2.charAt(n2)) {
            dp[n1][n2] = minDistanceDP(s1, n1-1, s2, n2-1, dp);
        } else {
            dp[n1][n2]=  min(
                    1 + minDistanceDP(s1,n1,s2,n2-1, dp), //insert
                    1 + minDistanceDP(s1, n1-1,s2,n2, dp), //delete
                    1+ minDistanceDP(s1,n1-1,s2,n2-1, dp) //replace
            );
        }
        return dp[n1][n2];
    }

    /*
    * Iterative
    *
    * */
    public int minDistanceIterative(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = min (1 + dp[i][j-1], 1 + dp[i-1][j], 1 + dp[i-1][j-1]);
            }
        }
        return dp[n1][n2];
    }



    public int min(int...a) {
        int min = a[0];
        for (int i = 1; i<a.length; ++i) {
            min = Math.min(min,a[i]);
        }
        return min;
    }
}
