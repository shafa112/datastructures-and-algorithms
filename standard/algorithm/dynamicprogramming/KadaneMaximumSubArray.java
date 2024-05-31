package algorithm.dynamicprogramming;

public class MaximumSubarrayKadane {

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarrayKadane obj = new MaximumSubarrayKadane();
        System.out.println(obj.maxSubArray(a));
    }

    // Complexity: O(n)
    // Space: O(n)
    // inc[i] means we are including the element a[i] in calculating the sum from index 0 to index i.
    // exc[i] means we are excluding the element a[i] in calculating the sum from index 0 to index i.
    public int maxSubArray(int[] a) {
        int n = a.length;
        int inc[] = new int[n];
        int exc[] = new int[n];
        inc[0] = a[0];
        exc[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            inc[i] = Math.max(a[i], a[i]+inc[i-1]);
            exc[i] = Math.max(inc[i-1], exc[i-1]);
        }
        return Math.max(inc[n-1], exc[n-1]);
    }

    // Complexity: O(n)
    // Space: O(1)
    public int maxSubArray2(int[] a) {
        int n = a.length;
        int inc = a[0];
        int exc = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int prevInclude = inc;
            inc = Math.max(a[i], a[i]+inc);
            exc = Math.max(prevInclude, exc);
        }
        return Math.max(inc, exc);
    }

    // Complexity: O(n)
    // Space: O(n)
    static int dpMaxSubArraySum(int a[]){
        int n = a.length;
        int dp[] =  new int[n];
        dp[0] = a[0];
        int sum = 0;
        for(int i = 1; i < n; i++){
            sum = Math.max(a[i], a[i]+sum);
            dp[i] = Math.max(dp[i-1], sum);
        }
        return dp[n-1];
    }

}
