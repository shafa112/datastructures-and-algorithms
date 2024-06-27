package algorithm.dynamicprogramming;



public class UniquePaths {

    /*
    * Recursive solution :
    * Time: O(2^(m*n)) // as for every cell(m,n) we have 2 choices if only recursion and no dp;
    * Stack space: length of path = (m-1) + (n-1)
    *
    *
    *
    * DP with Recursion:
    * Time: m*n // call for each cell dp[i][j]
    * Stack space: length of path = (m-1) + (n-1) + m*n(for dp array)
    *
    * */
    public static int uniquePaths(int m, int n,int[][] dp) {
        if(n<0 || m<0) return 0;
        if(dp[m][n]!=0) return dp[m][n];
        if(m == 0 || n == 0) return 1;
        return dp[m][n] = uniquePaths(m-1,n,dp)+uniquePaths(m,n-1,dp);
    }

    private static void initializeDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
    }

    /*
    * DP Solution with tabulation:
    * Time: m*n // call for each cell dp[i][j]
    *  Stack space: length of path = m*n(for dp array)
    * */
    public int UniquePathWithTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i==0 || j==0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /*
     * DP Solution with tabulation + Space optimization (1D ARRAY):
     *If there is prev row and prev col then we can space optimize it
     *
     *
     * prev row = [0,0,0,0]
     * curr row = [0,0,0,0];
     * curr row[i] = prev[i] + curr row[i-1]
     * prev = curr
     *
     *
     * Time: m*n
     *  Stack space: length of path = n(for dp array)
     * */
    public int UniquePathWithTabulationWithSpaceOptimized(int m, int n) {
        int[] prev = new int[n];
        int[] curr ;
        for(int i = 0; i < m; ++i) {
            curr = new int[n];
            for(int j = 0; j < n; ++j) {
                if(i==0 || j==0) curr[j] = 1;
                else curr[j] = prev[j] + curr[j-1];
            }
            prev = curr;
        }


        return prev[n-1];
    }

    /*
     * Solution 2
     * To reach from start to end, one has to walk m-1 steps down and n-1 steps right
     *
     * Concept:
     * if we have 2 identical apple A, 3 identical banana B
     * Number of ways of arrangement = (2+3)!/2!3!
     * So below we are arranging (m-1) down step and (n-1) steps
     *
     * ex: Some combination like this for m = 3 n = 3-> DRRD
     * So, if we count all pattern permutation we get the answer
     * so ans  = (m-1 + n - 1)!/((m-1)! * (n-1)!)
     * which is nothing but C(m+n-2, m-1) , which is nothing but nCr represented as C(n,r)
     * So let's write the ncr function first
     *
     * ncr = n!/(n-r)!r!
     * So, C(m+n-2, m-1) = (m-1 + n - 1)!/((m-1)! * (n-1)!)
     */

    static int solveII(int m, int n) {
        return ncr(m+n-2, m-1);
    }

    static int ncr(int n, int r) {
        double ans = 1D;
        for(long j=r; j>0 ;j--) {
            ans = ((n-r+j)*ans)/(r+1-j);
        }
        return (int)(ans+0.5d);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int[][] dp = new int[m][n];
        initializeDP(dp);
        System.out.println(uniquePaths(m-1,n-1,dp));
    }
}
