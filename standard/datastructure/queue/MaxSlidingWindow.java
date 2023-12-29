package datastructure.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(MaxSlidingWindow.maxSlidingwindow(nums,3)));
    }

    public static int[] maxSlidingwindow(int[] a, int k) {

        int n = a.length;
        if(k>n || n == 0 || k ==0) return new int[] {};
        int windowCount = n - k + 1;
        int ans[] = new int[windowCount];
        Deque<Integer> dq = new ArrayDeque<>(k);
        int i = 0;
        while (i < k) {
            while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.add(i);
            i++;
        }

        int j = 0;
        ans[j] = a[dq.peekFirst()];
        j++;
        while (i < n) {
            while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.add(i);
            while(!dq.isEmpty() && i-k+1>dq.peekFirst()) dq.removeFirst(); // Revisit this condition
            ans[j] = a[dq.peekFirst()];
            j++;
            i++;
        }

        return ans;

    }
}
