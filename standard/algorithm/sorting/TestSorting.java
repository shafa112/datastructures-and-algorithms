package algorithm.sorting;

import java.util.Arrays;

public class TestSorting {
    public static void main(String[] args) {
        int a[] = {24, 18, 38, 43, 14, 40, 1};

        /*BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(a);
        System.out.println(Arrays.toString(a));*/

        /*SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(a);
        System.out.println(Arrays.toString(a));*/

        /*InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(a);
        System.out.println(Arrays.toString(a));*/

        /*MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSortRecursive(a,0,a.length-1);
        System.out.println(Arrays.toString(a));*/

        /*QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));*/

        MergeSort m = new MergeSort();
        m.mergeSortIterative(a);
        System.out.println(Arrays.toString(a));
    }
}
