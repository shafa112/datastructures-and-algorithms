package datastructure.priorityqueue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class MergeKSortedPrac {

    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> c = (n1,n2) -> n1.val - n2.val;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(c);
        fillPQ(lists,pq);

        ListNode head=null;
        ListNode tail=null;
        while(!pq.isEmpty()) {
            ListNode n = pq.remove();
            if(head==null) {
                head = n;
                tail = n;
            } else {
                tail.next=n;
                tail=tail.next;
            }
            if(n.next!=null) pq.add(n.next);
        }

        return head;
    }

    private void fillPQ(ListNode[] lists, PriorityQueue<ListNode> pq) {
        for (ListNode l:lists) {
            pq.add(l);
        }
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
