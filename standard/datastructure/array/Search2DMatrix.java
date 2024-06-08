package datastructure.array;

public class Search2DMatrix {

    /*
    * Integers in each row are sorted in ascending from left to right.
    * Integers in each column are sorted in ascending from top to bottom.
    *
    * Here we start from 0th row and last col
    * If this element is == target -> true
    * If this element is > target, we discard that col because elements below this element are bigger than the element itself (col=col-1)
    * If this element is < target, we discard that row because elements to left of this element are smaller than the element itself (row = row+1)
    * */
    public static boolean searchMatrix(int[][] a, int target) {
        int row = 0;
        int col = a[0].length-1;
        while(row<a.length && col>=0) {
            if(a[row][col] == target) {
                return true;
            } else if (a[row][col] > target) --col;
            else ++row;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(searchMatrix(a,15));
    }

}
