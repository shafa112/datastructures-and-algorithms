package datastructure.array;

import java.util.Arrays;

/*
* 2 numbers are missing from 1 to n
* ex. {3,6,1,2}, missing: 3,5
*
* Method 1: with hashmap - space and time both O(n)
* Method 2: 2 equation, 2 variable
* Method 3 (Implemented):
* pivot = (x+y)/2 -- say pivot=4
* one of x or y will be <4 and other will be >4
* That is why we xor..(1,2,3,4)^array elements less than 4(pivot) we get one x or y
* and (5,6)^array elements greater than 4(pivot) we get x or y.
*
* */
public class TwoMissing {

    public static void main(String[] args) {
        int[] a = {4,6,1,2};
        System.out.println(Arrays.toString(twoMissing(a)));
    }

    private static int[] twoMissing(int[] a) {
        int N = a.length+2;
        int sumN = N*(N+1)/2;
        int sumArr = 0;
        for (int i = 0; i < a.length; i++) {
            sumArr+=a[i];
        }

        int pivot = (sumN-sumArr)/2;

        int leftXor = 0, rightXor = 0;
        for (int i = 1; i <=pivot ; i++)  leftXor^=i;
        for (int i =pivot+1; i <=N; ++i) rightXor^=i;

        for (int i = 0; i < a.length; i++) {
            if(a[i]<=pivot) leftXor^=a[i];
            else rightXor^=a[i];
        }

        return new int[]{leftXor,rightXor};
    }
}
