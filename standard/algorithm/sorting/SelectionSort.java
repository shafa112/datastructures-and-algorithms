package algorithm.sorting;

import java.util.Arrays;

public class SelectionSort {

    /*
     * In selection sort in each iteration minimum is found and then inserted at ith position (starting from i=0)
     * Best Case Time Complexity : O(n2)
     * Average Time Complexity : O(n2) // compares O(n2) and swaps O(n)
     * Worst Case Time Complexity : O(n2)
     */
    public void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; ++j) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
            System.out.println(Arrays.toString(a));
        }
    }
}
