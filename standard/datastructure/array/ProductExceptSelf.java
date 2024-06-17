package datastructure.array;

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] a) {
        int n = a.length;
        int[] ans = new int[a.length];
        ans[0] = 1;
        int prev = 1;
        for(int i = 1; i<n; ++i) {
            ans[i] = prev*a[i-1];
            prev = ans[i];
        }
        prev = a[n-1];
        for(int i = n-2; i>=0; --i) {
            ans[i]*=prev;
            prev*=a[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("original array: "+Arrays.toString(nums));
        System.out.println("ans: "+Arrays.toString(productExceptSelf(nums)));
    }
}
