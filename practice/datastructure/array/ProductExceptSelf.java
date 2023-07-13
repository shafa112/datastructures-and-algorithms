package array;

import java.util.Arrays;
import java.util.Stack;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] a = {2,4,5,3,10};
        int[] b = {2,4,3,5};
        int[] c = {9,0,-2};
        productExceptSelf(a);

    }

    private static void productExceptSelf(int[] a) {

        int pre = 1, post = 1;
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ans[i]=pre;
            pre*=a[i];
        }
        for (int i = a.length-1; i >= 0; i--) {
            ans[i]*=post;
            post*=a[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}
