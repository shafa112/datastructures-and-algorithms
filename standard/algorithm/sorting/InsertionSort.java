package algorithm.sorting;

import java.util.Arrays;

public class InsertionSort {

    /*
     * In insertion sort first size 1 array is sorted aad then we sort size 2 and then 3 and so on
     *
     * works well for smaller number of elements but a lot of movement is involved
     * which is costly when the size of list grows. Efficient for data sets that are already substantially sorted
     * Best case: O(n) when the array is already sorted
     * Avg case : O (n^2) // compares O(n2) and swaps O(n2)
     * Worst case : O(n^2)
     *
     */
    public void insertionSort(int[] a) {
        for(int i=0;i<a.length-1; ++i) {
            int key=a[i+1];
            int j=i+1;
            while(j>0 && key<a[j-1]) {
                   a[j]=a[j-1];
                    --j;
            }
            a[j]=key;
        }
    }
}
