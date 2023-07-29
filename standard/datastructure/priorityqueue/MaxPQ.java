package datastructure.priorityqueue;


// https://www.coursera.org/learn/algorithms-part1/lecture/Uzwy6/binary-heaps
public class MaxPQ<Key extends Comparable<Key>> {

    Key array[];
    int size;

    public MaxPQ(int n) {
        array = (Key[]) new Comparable[n];
        size = 0;
    }

    public void insert(Key key) {
        if (size == array.length) throw new RuntimeException("Priority Queue has reached its capacity");
        array[size] = key;
        swim(size);
        ++size;
    }

    public Key delMax() {
        if (size == 0) throw new RuntimeException("Priority Queue is Empty");
        Key max = array[0];
        array[0] = array[size - 1];
        --size;
        sink(0);
        array[size] = null;
        return max;
    }

    private void swim(int k) {
        int parentIndex = getParentIndex(k);
        while (parentIndex >= 0 && less(parentIndex, k)) {
            swap(k, parentIndex);
            k = parentIndex;
            parentIndex = getParentIndex(k);
        }
    }

    private int getParentIndex(int childIndex) {
        return childIndex % 2 == 0 ? childIndex / 2 - 1 : childIndex / 2;
    }

    private void sink(int k) {
        //get 1st Child index
        int firstChildIndex = getFirstChildIndex(k);
        while (firstChildIndex != -1) {
            int childIndex = -1;
            //check if 2nd child index exists
            if (firstChildIndex + 1 > size || less(firstChildIndex + 1, firstChildIndex)) childIndex = firstChildIndex;
            else childIndex = firstChildIndex + 1;
            if (less(k, childIndex)) {
                swap(k, childIndex);
                k = childIndex;
                firstChildIndex = getFirstChildIndex(k);
            } else break;
        }
    }

    private int getFirstChildIndex(int parentIndex) {
        int childIndex = 2 * parentIndex + 1;
        //if parent is leaf Node
        if (childIndex >= size) return -1;
        return childIndex;
    }

    private boolean less(int i, int j) {
        return array[i].compareTo(array[j]) < 0;
    }


    private void swap(int i, int j) {
        Key temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Key peek() {
        if (size == 0) throw new RuntimeException("Priority Queue is Empty");
        return array[0];
    }

    public void printHeap() {
        for (int levelSize = 1; levelSize <= size; levelSize = levelSize * 2) {
            int count = levelSize;
            int i = levelSize - 1;
            while (i < size && count > 0) {
                System.out.print(array[i++] + " ");
                --count;
            }
            System.out.println();
        }
    }
}
