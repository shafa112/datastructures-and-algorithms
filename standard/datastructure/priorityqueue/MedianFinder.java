package datastructure.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Our logic is to maintain two queues one max and one min pq
 * value of elements of max pq are smaller than the value of elements of min pq.
 * So we will add into these queue in such a way that either their size is equal or max pq has one
 * extra element
 * Insert operation
 *  - decide based on the input which queue it should go in
 *  - Insert the input in the decided queue.
 *  - And then check whether it needs balancing and balance if needed.
 */
public class MedianFinder {

    private PriorityQueue<Integer> maxPQ;
    private PriorityQueue<Integer> minPQ;

    public MedianFinder() {
        Comparator<Integer> maxPQComparator = (i,j) -> j-i;
        Comparator<Integer> minPQComparator = Comparator.comparingInt(i -> i);
        // Comparator<Integer> minPQComparator = (i,j) -> i-j;
        maxPQ = new PriorityQueue<>(maxPQComparator);
        minPQ = new PriorityQueue<>(minPQComparator);
    }

    // Step 1: Decide and insert into the decided queue
    // Step 2: Balance
    public void addNum(int num) {
        // Decide and insert into the decided queue
        if(maxPQ.isEmpty()) maxPQ.add(num);
        else {
            // num should go in second queue i.e. min Queue
            if(num >= maxPQ.peek()) {
                minPQ.add(num);
            } else {
                //num should go in first queue i.e max pq
                maxPQ.add(num);
            }
        }
        // Balancing i.e. either max pq size should be same or one greater
        if(maxPQ.size() == minPQ.size() || maxPQ.size() == minPQ.size()+1) return;
        if(maxPQ.size() == minPQ.size() + 2) {
            minPQ.add(maxPQ.remove());
        }
        if(maxPQ.size() + 1 == minPQ.size()) {
            maxPQ.add(minPQ.remove());
        }
    }

    public double findMedian() {
        if(maxPQ.size()==minPQ.size()) {
            double data1 = maxPQ.peek();
            double data2 = minPQ.peek();
            return (data1+data2)/2;
        } else {
            return maxPQ.peek();
        }

    }
}
