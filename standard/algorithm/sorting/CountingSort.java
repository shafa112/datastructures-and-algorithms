package algorithm.sorting;

import java.util.Arrays;

public class CountingSort {

    /*
     * Counting sort is a sorting technique based on keys between a specific range.
     * It works by counting the number of objects having distinct key values (kind of hashing).
     *
     * Complexity : O(n)
     */
    //todo: check for negative integers

    public void countingSort(int[] a) {
        int min=min(a);
        int countArraySize=max(a)-min+1;
        int[] count = new int[countArraySize];
        for(int i = 0; i < a.length; ++i) {
            ++count[a[i]-min];
        }
        System.out.println("Count array: "+Arrays.toString(count));
        System.out.println("Count array size: "+count.length);

        for(int i = 1; i < count.length; ++i) {
            count[i] += count[i-1];
        }
        System.out.println("count cumulative sum: "+Arrays.toString(count));

        int[] output = new int[a.length];
        for(int i = 0; i < a.length; ++i) {
            int index = count[a[i]-min]-1;
            System.out.println("index: "+index);
            count[a[i]-min]--;
            output[index] = a[i];
        }
        System.out.println("output array: "+Arrays.toString(output));

    }

    public int max(int[] a) {
        int max=a[0];
        for(int i = 1; i < a.length; ++i) {
            if(max<a[i])max=a[i];
        }
        return max;
    }

    public int min(int[] a) {
        int min=a[0];
        for(int i = 1; i < a.length; ++i) {
            if(min>a[i])min=a[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int [] b = {2,5,3,5,4};
        int [] a = {8,4,2,2,8,3,3,1};
        System.out.println("Unsorted array: "+Arrays.toString(b));
        CountingSort countingSort= new CountingSort();
        countingSort.countingSort(b);
    }
}
