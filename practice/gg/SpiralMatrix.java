package gg;

import java.util.*;

public class SpiralMatrix {
    /**
     * We can move the boundaries towards the center of the matrix after we have traversed a row or a column,
     * then when we meet a boundary, we know it's time to change the direction and update the boundary.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        int upBoundary = 0;
        int downBoundary = m - 1;
        int leftBoundary = 0;
        int rightBoundary = n-1;
        while(upBoundary <= downBoundary && leftBoundary <= rightBoundary) {
            //loop 1: consuming the upBoundary
            i = upBoundary;
            j = leftBoundary;
            while(j <= rightBoundary) {
                result.add(matrix[i][j]);
                ++j;
            } upBoundary++;

            //loop 2: consuming the rightBoundary
            j = rightBoundary;
            i = upBoundary;
            while( i <= downBoundary) {
                result.add(matrix[i][j]);
                ++i;
            } rightBoundary--;

            //loop 3: consuming the downBoundary
            i = downBoundary; //0
            j = rightBoundary; //3
            if (upBoundary <= downBoundary) {
                while(j >= leftBoundary) {
                    result.add(matrix[i][j]);
                    --j;
                } downBoundary--;
            }

            //loop 4: consuming the leftBoundary
            if(leftBoundary <= rightBoundary) {
                j = leftBoundary;
                i = downBoundary;
                while( i >= upBoundary) {
                    result.add(matrix[i][j]);
                    --i;
                } leftBoundary++;
            }

        }
        return result;
    }
}
