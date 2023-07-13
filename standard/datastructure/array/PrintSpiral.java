package datastructure.array;

public class PrintSpiral {

    public static void main(String[] args) {
        int[][] a = {{1,6,8},{10,7,20},{3,5,13},{18,9,21}};
        int[][] b = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        PrintSpiral printSpiral = new PrintSpiral();
        printSpiral.spiral(b);
    }

    private void spiral(int[][] a) {
        int rowSize = a.length;
        int columnSize = a[0].length;
        int startR = 0;
        int startC = 0;
        while(startR < rowSize && startC<columnSize) {
            //print left to right
            int i = startR;
            int j = startC;
            for (j = startC; j < columnSize; j++) {
                System.out.print(a[startR][j]+"->");
            }
            ++startR;

            //print up down
            for (i = startR; i < rowSize; i++) {
                System.out.print(a[i][columnSize-1]+"->");
            }
            --columnSize;

            //print right to left
            if(startR<rowSize)
            {
                for ( j = columnSize-1; j >= startC ; j--) {
                    System.out.print(a[rowSize-1][j]+"->");
                }
                --rowSize;
            }

            //print bottom up
            if(startC<columnSize) {
                for (i = rowSize-1; i >= startR; i--) {
                    System.out.print(a[i][startC] + "->");
                }
            }
            ++startC;

        }

    }
}
