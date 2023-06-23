package algorithm.sorting;

import java.util.Arrays;

/*
 * Complexity:
 *
 * Worst Case Time Complexity : O(n^2)
 * Best Case Time Complexity : O(n log n)
 * Average Time Complexity : O(n log n)
 *
 * In worst case therefore quicksort is worse than insertion sort and is therefore a disaster
 *
 * Comparison with mergesort:
 * Quicksort in average case does 39% comparisons more than mergesort
 */
public class QuickSort {

    public void quickSort(int[] a, int start, int end) {
        if(start<end) {
            int pivotIndex = partition2(a,start,end);
            System.out.println("Pivot: "+ a[pivotIndex]);
            System.out.println(Arrays.toString(a));
            quickSort(a,start,pivotIndex-1);
            quickSort(a,pivotIndex+1,end);
        }
    }

    //pivot=mid element, passes only 4/67 test cases of gfg
    int partition(int[] a, int start, int end) {

        int pIndex=(start+end)/2;
        int pivot=a[pIndex];
        int i = start;
        int j = end;

        while(i<j) {
            while(i<j && a[i]<pivot) ++i;
            while(j>i && a[j]>pivot) --j;
            if(i<j) {
                if(a[i]==pivot) pIndex=j;
                if(a[j]==pivot)pIndex=i;
                swap(a,i,j);

            }
        }
        return pIndex;
    }

    // Copied from net
    // pivot=last element, passes all test cases of gfg
    int partition2(int[] array, int low, int high) {

        // choose the rightmost element as pivot
        int pivot = array[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        // swap the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;

    }
}
