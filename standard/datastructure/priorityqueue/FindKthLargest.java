package datastructure.priorityqueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] a = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(a,4));
    }
    public static int findKthLargest(int[] a, int k ) {
        //check comparator in bhaijaan notes or net
        Comparator<Integer> byElement = (a1, a2) -> a1 - a2;
        PriorityQueue<Integer> pq = new PriorityQueue<>(byElement);
        for (int i = 0; i < a.length; i++) {
            if(i<k) pq.add(a[i]);
            else {
                if(a[i]>pq.peek()) {
                    pq.remove();
                    pq.add(a[i]);
                }
            }
        }
        return pq.remove();
    }
}
