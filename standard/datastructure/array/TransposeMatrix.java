package datastructure.array;

import java.util.Arrays;

public class TransposeMatrix {

    public static void main(String[] args) {
        int original[][]={{1,3},{2,4},{3,4}};
        System.out.println(original.length);
        System.out.println(original[0].length);
        transpose(original);
    }

    private static void transpose(int[][] original) {
        int trans[][] = new int[original[0].length][original.length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                trans[j][i]=original[i][j];
            }
        }
        print(trans);
    }

    private static void print(int[][] trans) {
        for (int i = 0; i < trans.length; i++) {
            for (int j = 0; j < trans[0].length; j++) {
                System.out.print(trans[i][j]+" ");
            }
            System.out.println();
        }
    }


}
