package datastructure.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class LargestAreaInHistogram {

    /*
     * Idea is how much we can expand at any bar. We can expand the rectangle at the current bar
     * if the adjacent is greater than or equal to current bar. And so on.
     */
    static public int maxArea(int[] h) {
        Stack<Integer> s = new Stack<>();
        int expansion[] = new int[h.length];
        int max = 0;
        for(int i=0; i< h.length; i++) {
            while (!s.isEmpty() && h[i] <= h[s.peek()]) {
                int j = s.pop();
                // Side Note to try when free: we don't actually need to calculate right expansion
                // So we can remove that array and max update in this if block
                expansion[j]+=(i-j-1);
                max = Math.max(max, expansion[j]*h[j]);
            }
            if(s.isEmpty()) {
                expansion[i] = (i+1);
                max = Math.max(max, (i+1)*h[i]);
            } else {
                expansion[i] = i - s.peek();
                max = Math.max(max, (i - s.peek())*h[i]);
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
          int j = s.pop();
            expansion[j]+=(h.length-j-1);
            max = Math.max(max, expansion[j]*h[j]);
        }
//        System.out.println(Arrays.toString(expansion));
        return max;
    }

    public static void main(String[] args) {
        int h[] = {2,1,5,6,2,3};
        System.out.println(maxArea(h));
    }
}
