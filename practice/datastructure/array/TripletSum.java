package array;

import java.util.Arrays;

public class TripletSum {

    public static void main(String[] args) {
        int[] a = {12, 3, 4, 1, 6, 9};//1,3,4,6,,9,12
        int[] b = {1, 4, 45, 6, 10, 8};//1,4,6,8,10,45
        tripleSum(a,24);
    }

    public static boolean tripleSum(int[] a, int sum) {
        Arrays.sort(a);
        for (int i = 1; i < a.length-1; i++) {
            int tempSum = sum-a[i-1];
            if(sumPair(a,i,tempSum)) return true;
        }
        return false;
    }

    public static boolean sumPair(int [] a, int i, int sum) {
        int j=a.length-1;
        while(i<j) {
            if(a[i]+a[j]==sum) {
                //System.out.println(i+"------"+j);
                return true;
            }
            else if(a[i]+a[j]>sum)--j;
            else ++i;
        }
        return false;
    }


}
