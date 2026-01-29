package gg;

import java.util.*;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[][] prefixSum = new int[matrix.length][matrix[0].length];
        for(int j = 0; j < matrix[0].length; ++j) {
            int sum = 0;
            for(int i = 0; i < matrix.length; ++i) {
                sum += matrix[i][j] - '0';
                if(matrix[i][j] == '0') sum = 0;
                prefixSum[i][j] = sum;
            }
        }

        int maxArea = 0;
        for(int i = 0; i < matrix.length; ++i) {
            maxArea = Math.max(maxArea, largestRectangleArea(prefixSum[i]));
        }
        return maxArea;
    }

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
