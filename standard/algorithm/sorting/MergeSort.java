package algorithm.sorting;

import java.util.Arrays;

/*
 * Complexity
 * T(n) = 2T(n/2) + n, n is for merging, therefore T(n) = nlogn-1.15n
 *
 * Worst Case Time Complexity : O(n log n)
 * Best Case Time Complexity : O(n log n)
 * Average Time Complexity : O(n log n)
 */
public class MergeSort {

    public void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, end, mid);
        }
    }

    public void merge(int[] a, int start, int end, int mid) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] c = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                c[k] = a[i];
                ++i;
            } else {
                c[k] = a[j];
                ++j;
            }
            ++k;
        }

        while (i <= mid) {
            c[k] = a[i];
            ++i;
            ++k;
        }

        while (j <= end) {
            c[k] = a[j];
            ++j;
            ++k;
        }

        k = 0;
        for (i = start; i <= end; ++i) a[i] = c[k++];
    }
}
