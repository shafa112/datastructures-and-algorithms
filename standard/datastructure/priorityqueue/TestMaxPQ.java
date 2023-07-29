package datastructure.priorityqueue;

public class TestMaxPQ {
    public static void main(String[] args) {
        int[] array = {4, 5, 1, 7, 8, 2, 3};
        MaxPQ<Integer> maxPQ = new MaxPQ<>(array.length);
        for(int i =0; i < array.length ; i++) maxPQ.insert(array[i]);
        maxPQ.printHeap();
    }
}
