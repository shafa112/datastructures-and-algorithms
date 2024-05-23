package datastructure.tree;

/*
* Given an integer n, return the number of structurally unique BST
* which has exactly n nodes of unique values from 1 to n.
* */
public class UniqueBSTs {
    public int helper(int n, int[] dp) {
        if(n==0 || n==1) return 1;
        if(dp[n]!=0) return dp[n];
        int ans = 0;
        for(int i = 1; i<=n; ++i){
            ans+=helper(i-1,dp)*helper(n-i,dp);
        }
        return dp[n]=ans;
    }

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        return helper(n,dp);
    }
}
