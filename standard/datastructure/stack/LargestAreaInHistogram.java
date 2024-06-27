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
        for(int i=0; i < h.length; i++) {
            while (!s.isEmpty() && h[i] <= h[s.peek()]) {
                int j = s.pop();
                expansion[j]+=(i-j-1);
                max = Math.max(max, expansion[j]*h[j]);
            }
            if(s.isEmpty()) {
                expansion[i] = (i+1);
                max = Math.max(max, (i+1)*h[i]);
            } else {
                expansion[i] = i - s.peek();
                max = Math.max(max, expansion[i]*h[i]);
            }
            s.push(i);
        }

        System.out.println("eeee");
        System.out.println(Arrays.toString(expansion));

        while (!s.isEmpty()) {
          int j = s.pop();
            expansion[j]+=(h.length-j-1);
            max = Math.max(max, expansion[j]*h[j]);
        }
        System.out.println(Arrays.toString(expansion));
        return max;
    }

    public static void main(String[] args) {
        int h[] = {2,1,5,6,2,3};
        //System.out.println(maxArea(h));
        System.out.println(maxHistogramArea(h));
    }

    public static int maxHistogramArea(int[] heights) {
        int leftSmaller[] = new int[heights.length];
        int rightSmaller[] = new int[heights.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while(!s.isEmpty() && heights[i]<=heights[s.peek()]) s.pop();
            if(s.isEmpty()) leftSmaller[i] = 0;
            else leftSmaller[i] = s.peek()+1;
            s.push(i);
        }
        System.out.println(Arrays.toString(leftSmaller));

        while(!s.isEmpty()) s.pop();
        for (int i = heights.length-1; i >=0 ; i--) {
            while(!s.isEmpty() && heights[i]<=heights[s.peek()]) s.pop();
            if(s.isEmpty()) rightSmaller[i] = heights.length-1;
            else rightSmaller[i] = s.peek()-1;
            s.push(i);
        }

        System.out.println(Arrays.toString(rightSmaller));

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea,heights[i]*(rightSmaller[i]-leftSmaller[i]+1));
        }
        return maxArea;
    }
}
