package datastructure.array;

import util.Util;

public class RotateImageBy90 {

    public static void rotate(int[][] a) {
        transposeSquareMatrix(a);
        for (int k = 0; k < a.length; k++) {
            int i = 0;
            int j = a[0].length-1;
            while(i<j) {
                int temp = a[k][i];
                a[k][i] = a[k][j];
                a[k][j] = temp;
                i++;
                j--;
            }
        }
    }

    private static void transposeSquareMatrix(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i<j) {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(a);
        Util.printArray(a);

    }
}
