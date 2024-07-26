package datastructure.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.*;
import java.util.Deque;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {-7,-8,7,25,7,1,6,0};
        System.out.println(Arrays.toString(maxSlidingWindow4(nums,4)));
    }


    // int[] nums = {-7,-8,7,5,7,1,6,0};
    // k+i-1
    public static int[] maxSlidingWindow4(int[] a, int k) {
        if(k >= a.length) {
            return new int[]{Arrays.stream(a).max().getAsInt()};
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[a.length-k+1];
        int r=0;
        // i represents current element we are processing
        for (int i = 0; i < a.length; i++) {
            if(!dq.isEmpty() && dq.peekFirst() == i-k) dq.removeFirst();
            while(!dq.isEmpty() && a[i]>=a[dq.peekLast()] ) dq.removeLast();
            dq.addLast(i);
            if(i >= k-1) {
                ans[r++] = a[dq.peekFirst()];
            }
        }
        return ans;
    }
}
