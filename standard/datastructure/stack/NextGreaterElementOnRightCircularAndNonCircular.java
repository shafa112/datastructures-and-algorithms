package datastructure.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementOnRightCircularAndNonCircular {

    public static void main(String[] args) {
        int[] a = {3,10,4,2,1,2,6,1,7,2,9};
        nextGreaterElementOnRightNonCircular(a);
        nextGreaterElementsCircularArray(a);
    }

    /*
    * Start from end of array and keep removing elements from stack if smaller,
    * then top element will be the next greater
    * */
    public static void nextGreaterElementOnRightNonCircular(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> s = new Stack<>();
        ans[a.length-1] = -1;
        s.push(a[a.length-1]);
        for (int i = a.length-2; i >=0 ; i--) {
            while(!s.isEmpty() && a[i] >= s.peek()) {
                s.pop();
            }
            if(s.isEmpty()) ans[i]= -1;
            else ans[i] = s.peek();
            s.push(a[i]);
        }
        System.out.println(Arrays.toString(ans));
    }

    /*

    * TC: O(2n+2n)
    * SC: O(n)
    * Imagine you entire array next to original array
    * This increase you array from n to 2n length and indexes go from 0 to 2n-1
    * You can apply same logic as non-circular array just by modifying index
    * For indexes, i >=n --> do i%n
    *
    * Example: 2,10,12,1,11
    * */
    public static void nextGreaterElementsCircularArray(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2*n-1; i >=0 ; i--) {
            while(!s.isEmpty() && s.peek() <= a[i%n] ) {
                s.pop();
            }
            if(i<n) {
                if(s.isEmpty()) ans[i]= -1;
                else ans[i] = s.peek();
            }
            s.push(a[i%n]);
        }
        System.out.println(Arrays.toString(ans));
    }



}
