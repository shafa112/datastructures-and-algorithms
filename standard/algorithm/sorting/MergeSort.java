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

    public void mergeSortRecursive(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortRecursive(a, start, mid);
            mergeSortRecursive(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    public void mergeSortIterative(int[] a) {

        for (int size = 1 ;size<a.length ;size = size*2) {

            for (int i = 0 ;i < a.length ;i+=size*2) {
                int start = i;
                int mid = i+size-1;
                int end = Math.min(i+2*size-1,a.length-1);
                merge2(a,start,mid,end);
            }
        }

    }

    public void merge(int[] a, int start, int mid, int end) {
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

    public void merge2(int ar[], int start, int mid, int end){
        // given start, end index of an array
        // length = end - start + 1
        int la[] = new int[mid-start+1];
        int ra[] = new int[end-(mid +1) + 1];//changed from mid-1 to mid+1

        //filling left array
        for(int i = 0 ; i < la.length ; i++)
        {
            la[i] = ar[start + i];
        }
        //filling right array
        for(int j = 0 ; j < ra.length ; j++)
        {
            ra[j] = ar[(mid+1) + j];
        }

        //
        int i = 0 ;
        int j = 0;
        int k = start;
        while(i < la.length && j < ra.length){
            if(la[i] <= ra[j] )
            {
                ar[k++] = la[i++];
            }
            else
            {
                ar[k++] = ra[j++];
            }
        }

        // fill remaining
        while(i < la.length)
        {
            ar[k++] = la[i++];
        }


        while(j < ra.length)
        {
            ar[k++] = ra[j++];
        }


    }
}
