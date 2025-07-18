package meta;

import util.Util;

import java.util.Arrays;

public class DiagonalTraverse {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}};
        Util.printArray(findDiagonalOrder2(mat));
    }
    public static int[] findDiagonalOrder2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, k = 0;
        boolean goUp = true;

        while (k < result.length) {
            result[k++] = mat[row][col];

            if (goUp) {
                if (col == n - 1) { // Hit the right boundary
                    row++;
                    goUp = false;
                } else if (row == 0) { // Hit the top boundary
                    col++;
                    goUp = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) { // Hit the bottom boundary
                    col++;
                    goUp = true;
                } else if (col == 0) { // Hit the left boundary
                    row++;
                    goUp = true;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int i = 0;
        int j = 0;
        int row = 0;
        int col = 0;
        int k = 0;
        boolean goUp = true;
        while (k < result.length) {
            if (goUp) {
                for (i = row, j = col; i >= 0 && j < n; i--, j++) {
                    result[k++] = mat[i][j];
                }
                if (j == n) {
                    row = i + 2;
                    col = j - 1;
                } else {
                    row = i + 1;
                }
                goUp = false;
            } else {
                for (i = row, j = col; i < m && j >= 0; i++, j--) {
                    result[k++] = mat[i][j];
                }
                if (i == m) {
                    col = j + 2;
                    row = i - 1;
                } else {
                    col = j + 1;
                }
                goUp = true;
            }
        }
        return result;
    }
}
