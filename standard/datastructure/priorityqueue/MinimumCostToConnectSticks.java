package datastructure.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    public static void main(String[] args) {
        long[] a = {4, 3, 2, 6};
        System.out.println(minCost(a));
    }

    static long minCost(long a[]) {
        Comparator<Long> comparator = Comparator.comparingLong(i -> i);
        PriorityQueue<Long> pq = new PriorityQueue<>(comparator);
        for (long key : a) {
            pq.add(key);
        }
        long minCost = 0;
        while (pq.size() > 1) {
            long rope1 = pq.remove();
            long rope2 = pq.remove();
            long joinRope1Rope2 = rope1 + rope2;
            minCost += joinRope1Rope2;
            pq.add(joinRope1Rope2);
        }
        return minCost;
    }
}
