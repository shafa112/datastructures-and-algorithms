package gg;

import java.util.Stack;

public class LargestRectangleHist {
    // First think brute force, which leads to O(n^2).
    // Second, with PSE+NSE we can solve, but it takes many N passes in regard to time and space.
    // Final and optimised, calculate pse on traversal and when popping from stack calculate the nse and
    // hence area.

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < heights.length; ++i) {
            while(!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                int h = heights[s.pop()];
                int nse = i;
                int pse = -1;
                if(!s.isEmpty()) {
                    pse = s.peek();
                } else pse = -1;
                max = Math.max(max, h*(nse-pse-1));
            }
            s.push(i);
        }

        while(!s.isEmpty()) {
            int h = heights[s.pop()];
            int nse = heights.length;
            int pse = -1;
            if(!s.isEmpty()) {
                pse = s.peek();
            } else pse = -1;
            max = Math.max(max, h*(nse-pse-1));
        }
        return max;
    }
}
