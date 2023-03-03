package algorithm.sorting;

import java.util.Arrays;

public class CountingSort {

    public void countingSort(int[] a) {
        int countArraySize=max(a)+1;
        int[] count = new int[countArraySize];
        for(int i = 0; i < a.length; ++i) {
            ++count[a[i]];
        }
        System.out.println("Count array: "+Arrays.toString(count));

        for(int i = 1; i < count.length; ++i) {
            count[i] += count[i-1];
        }
        System.out.println("count cumulative sum: "+Arrays.toString(count));

        int[] output = new int[a.length];
        for(int i = 0; i < a.length; ++i) {
            int index = count[a[i]]-1;
            count[a[i]]--;
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

    public static void main(String[] args) {
        int [] a = {8,4,2,2,8,3,3,1};
        System.out.println("Unsorted array: "+Arrays.toString(a));
        CountingSort countingSort= new CountingSort();
        countingSort.countingSort(a);

    }
}
