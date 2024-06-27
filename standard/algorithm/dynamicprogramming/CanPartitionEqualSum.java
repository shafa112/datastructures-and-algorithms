package algorithm.dynamicprogramming;

public class CanPartitionEqualSum {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i: nums) sum = sum + i;
        //System.out.println("sum: "+sum/2);
        if(sum%2!=0) return false;
        //return isSubsetSum(nums, nums.length-1,sum/2);
        return isSubsetDP(nums,sum/2);
    }

    public static boolean isSubsetSum(int[] a, int n, int targetSum) {
        if(n<0) return false;
        if(targetSum==0) return true;
        return isSubsetSum(a,n-1,targetSum) || isSubsetSum(a,n-1,targetSum-a[n]);
    }

    public static boolean isSubsetDP(int[] nums, int sum) {
        Boolean[][] dp = new Boolean[nums.length][sum+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                 if(j==0) dp[i][j] = true;
                else if(i==0) dp[i][j] = (nums[i]==j)? true : false;
                else if(nums[i]>j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
            }

        }
        return dp[nums.length-1][sum];
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,5};
        System.out.println(canPartition(nums));
    }
}
