package algorithm.sorting;

import java.util.Arrays;

// Sort in ascending order
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {5,1,1,2,0,0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int array[]) {
        buildHeap(array);
        int size = array.length;
        while(size>0) {
            int max = array[0];
            array[0] = array[size-1];
            --size;
            sink(array,size,0);
            array[size] = max;
        }
    }

    private static void sink(int[] array,int size, int k) {
        //get 1st Child index
        int firstChildIndex = getFirstChildIndex(k,size);
        while (firstChildIndex != -1) {
            int childIndex = -1;
            //check if 2nd child index exists
            if (firstChildIndex + 1 > size || less(array,firstChildIndex + 1, firstChildIndex)) childIndex = firstChildIndex;
            else childIndex = firstChildIndex + 1;
            if (less(array,k, childIndex)) {
                swap(array,k, childIndex);
                k = childIndex;
                firstChildIndex = getFirstChildIndex(k,size);
            } else break;
        }
    }

    private static int getFirstChildIndex(int parentIndex,int size) {
        int childIndex = 2 * parentIndex + 1;
        //if parent is leaf Node
        if (childIndex >= size) return -1;
        return childIndex;
    }


    private static void buildHeap(int[] array) {
        for (int i = 1; i < array.length; i++) {
            swim(array, i);
        }
    }

    private static void swim(int[] array, int k) {
        int parentIndex = getParentIndex(k);
        while (parentIndex >= 0 && less(array, parentIndex, k)) {
            swap(array, k, parentIndex);
            k = parentIndex;
            parentIndex = getParentIndex(k);
        }
    }

    private static int getParentIndex(int childIndex) {
        return childIndex % 2 == 0 ? childIndex / 2 - 1 : childIndex / 2;
    }

    private static boolean less(int[] array, int i, int j) {
        return array[i] < array[j];
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
