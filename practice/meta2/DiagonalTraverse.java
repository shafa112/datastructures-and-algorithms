package meta2;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean up = true;
        int row = 0;
        int col = 0;
        int[] result = new int[rows * cols];
        int p = 0;
        while(row < rows && col < cols) {
            result[p++] = mat[row][col];
            if(up) {
                if(col == cols - 1) {
                    row = row + 1;
                    up = false;
                }
                else if(row == 0) {
                    col = col + 1;
                    up = false;
                } else {
                    row = row - 1;
                    col = col + 1;
                }
            } else {
                if(row == rows - 1) {
                    col += 1;
                    up = true;
                } else if(col == 0) {
                    row += 1;
                    up = true;
                } else {
                    row = row + 1;
                    col = col - 1;
                }
            }
        }
        return result;
    }
}
