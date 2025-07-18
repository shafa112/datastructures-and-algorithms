package datastructure.priorityqueue;

public class HeapSortPrac {

    public void heapSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            swim(i,a);
        }

        int k = a.length;
        while(k>1) {
            int max = a[0];
            a[0]=a[k-1];
            sink(a,0,k-1);
            a[k-1]=max;
            --k;
        }
    }

    private void sink(int[] a,int k, int size) {
        //get 1st Child index
        int firstChildIndex = getFirstChildIndex(k,size);
        while (firstChildIndex != -1) {
            int childIndex = -1;
            //check if 2nd child index exists
            if (firstChildIndex + 1 > size || less(a,firstChildIndex + 1, firstChildIndex)) childIndex = firstChildIndex;
            else childIndex = firstChildIndex + 1;
            if (less(a,k, childIndex)) {
                swap(a,k, childIndex);
                k = childIndex;
                firstChildIndex = getFirstChildIndex(k,size);
            } else break;
        }
    }

    private int getFirstChildIndex(int parentIndex, int size) {
        int childIndex = 2 * parentIndex + 1;
        //if parent is leaf Node
        if (childIndex >= size) return -1;
        return childIndex;
    }

    private void swim(int k, int[] a) {
        int parentIndex = getParentIndex(a, k);
        while (parentIndex >= 0 && less(a, parentIndex, k)) {
            swap(a, k, parentIndex);
            k = parentIndex;
            parentIndex = getParentIndex(a,k);
        }
    }

    private int getParentIndex(int[] a,int childIndex) {
        return childIndex % 2 == 0 ? childIndex / 2 - 1 : childIndex / 2;
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less(int[] a, int i, int j) {
        return a[i]-a[j] < 0;
    }
}
