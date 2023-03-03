package algorithm.sorting;

public class BubbleSort {

    /*
     * In bubble sort largest element in pushed to bottom in each iteration
     * Best-case performance	O(n)
     * Average performance	 O(n2) // compares O(n2) and swaps O(n2)
     * Worst-case performance	 O(n2)
     *
     * In best case both bubble and insertion has same big-O
     * but go with insertion due to less overheads.(No extra comparison of !sorted)
     */
    public void bubbleSort(int[] a) {
        int swapFlag = -1;
        for (int i = a.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapFlag = 1;
                }
            }
            if (swapFlag == -1) {
                break;
            }
        }
    }
}
