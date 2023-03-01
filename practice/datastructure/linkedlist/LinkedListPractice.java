package linkedlist;

import datastructure.linkedlist.LinkedList;
import datastructure.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LinkedListPractice {

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        LinkedListPractice lp = new LinkedListPractice();
        l.insertAtEnd(1);
        l.insertAtEnd(2);
        l.insertAtEnd(3);
        l.insertAtEnd(4);
        l.insertAtEnd(5);
        //l.insertAtEnd(6);
        //lp.reorder(l);
        //lp.rotateList(l,1);//201
        //lp.rotateTest(l.head, 2);

        System.out.println();
        //System.out.println(lp.nthNodeFromEnd(6,l.head).data);
        Node p = l.head.next;
        lp.pairwiseSwap2(l.head);
        l.head = p;
        l.traverse();

        /*LinkedListPractice lp = new LinkedListPractice();

        LinkedList l1 = new LinkedList();
        l1.insertAtEnd(3);
        l1.insertAtEnd(4);
        l1.insertAtEnd(2);
        l1.traverse();

        System.out.println();

        LinkedList l2 = new LinkedList();
        l2.insertAtEnd(4);
        l2.insertAtEnd(6);
        l2.insertAtEnd(5);
        l2.traverse();

        System.out.println();

        lp.addLinkedListIterative(l1,l2);
        l1.reverseIterative();
        l2.reverse(l2.head);
        lp.addLLRecursive(l1.head,l2.head,0,null);*/

    }

    public Node nthNodeFromEnd(int n, Node head) {
        Node t1 = head;
        Node t2 = head;
        for (int i = 1; t2 != null && i < n; ++i) {
            t2 = t2.next;
        }
        while (t2.next != null) {
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1;
    }

    // todo
    void addLinkedListIterative(LinkedList l1, LinkedList l2) {
        l1.reverseIterative();
        l2.reverseIterative();
        Node t1 = l1.head;
        Node t2 = l2.head;
        int carry = 0;
        LinkedList l = new LinkedList();
        while (t1 != null && t2 != null) {
            int data = (t1.data + t2.data) + carry;
            System.out.println("put at start of ll: " + data % 10);
            carry = data / 10;
            t1 = t1.next;
            t2 = t2.next;
        }

        while (t1 != null) {
            int data = t1.data + carry;
            System.out.println("put at start of ll: " + data % 10);
            carry = data / 10;
            t1 = t1.next;
        }

        while (t2 != null) {
            int data = t2.data + carry;
            System.out.println("put at start of ll: " + data % 10);
            carry = data / 10;
            t2 = t2.next;
        }

        if (carry != 0) System.out.println("put at start of ll: " + carry);
    }

    //reverse:think and ask doubt to chotean
    Node pairwiseSwap(Node t1, Node t2) {
        if (t1 == null || t1.next == null) return t1;
        Node p = null;
        if (t2 != null) {
            p = t2.next;
            t2.next = t1;
        }
        if (p != null) {
            t1.next = pairwiseSwap(p, p.next);
        } else {
            t1.next = null;
        }
        return t2;
    }

    Node pairwiseSwap2(Node t1) {
        if (t1 == null || t1.next == null) return t1;
        Node t2 = t1.next;
        Node p = t2.next;
        t2.next = t1;
        t1.next = pairwiseSwap2(p);
        return t2;
    }

    Node pairwiseSwapIterative(Node head) {
        if(head == null || head.next == null) return head;
        Node newHead = head.next;
        Node first = head;
        while (first.next != null)  {
            Node second = first.next;
            Node third = second.next;
            second.next = first;
            first.next = third;
            first = third;
        }
        return newHead;
    }

    //can also reverse nodes next to mid, compare from start
    //below is using stack: space 0(n), time 0(n)
    boolean isPalindrome(Node head) {
        Stack<Integer> s = new Stack<>();
        Node t = head;
        while (t != null) {
            s.push(t.data);
            t = t.next;
        }
        t = head;
        while (t != null) {
            if (t.data != s.pop()) return false;
            t = t.next;
        }
        return true;
    }

    public int size(Node head) {
        int size = 0;
        Node t = head;
        while (t != null) {
            ++size;
            t = t.next;
        }
        return size;
    }

    void rotateToRight(Node head, int k) {
        if (head == null || head.next == null) return;
        Node start = head;
        Node t = head;
        while (t.next != null) t = t.next;
        Node tail = t;
        t = head;
        int steps = k % size(head);
        if (steps == 0) return;
        Node newHead = nthNodeFromEnd(steps, head);
        Node prevHead = null;
        while (t != newHead) {
            prevHead = t;
            t = t.next;
        }
        tail.next = start;
        head = newHead;
        prevHead.next = null;

    }

    int yShapedLinkedListCommonNode(Node head1, Node head2) {
        int size1 = size(head1);
        int size2 = size(head2);
        Node t = null;
        if (size1 > size2) {
            t = head1;
            int steps = size1 - size2;
            while (steps > 0) {
                t = t.next;
                --steps;
            }
        } else {
            t = head2;
            int steps = size2 - size1;
            while (steps > 0) {
                t = t.next;
                --steps;
            }
        }
        Node t2 =null;
        if(size1>size2) {
             t2 = head2;
        } else {
            t2 = head1;
        }
        while(t!=null && t2!=null)  {
            if(t==t2) return t.data;
            t=t.next;
            t2=t2.next;
        }
        return -1;
    }

    //Using hashmap
    boolean detectLoopHashmap(Node head) {
        Node t = head;
        Map<Node, Integer> map = new HashMap<>();
        while( t != null ) {
            if(map.containsKey(t)) return true;
            else map.put(t,t.data);
            t=t.next;
        }
        return false;
    }

    //Using slow(1 jump) and fast(2 jumps) pointers
    boolean detectLoop(Node head) {
        if(head==null) return false;
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && slow.next!=null) {
            if(fast == slow) return true;
            slow=slow.next;
            if(fast.next!=null)fast=fast.next.next;
            else fast = null;
        }
        return false;
    }

    //Delete node without info of head of LL, data is unique and node to be deleted can't be last node
    public void deleteNode(Node node) {
        if(node == null) return;
        Node t = node;
        Node p = null;
        while(t.next != null) {
            t.data = t.next.data;
            p = t;
            t = t.next;
        }
        if(p!=null) p.next = null;

    }

    public void reorder(LinkedList l) {
        System.out.println();
        l.traverse();
        if(l.head==null) return;
        int size = size(l.head);
        if (size == 1 ) return;
        int steps = (size/2)+1;
        System.out.println();
        System.out.println("steps: "+steps);
        Node p = l.head;
        Node n = null;
        while(p.next!=null &&  steps>1) {
            p=p.next;
            --steps;
        }
        System.out.println("p data: "+p.data);
        if(p.next!=null) {
            n = p.next;
            System.out.println("n data: "+n.data);
        }
        p.next=null;
        LinkedList l2 = new LinkedList();
        while(n.next!=null) {
            l2.insertAtEnd(n.data);
            n=n.next;
        }
        l2.insertAtEnd(n.data);
        //System.out.println("head of l2: "+l2.head.data);
        l2.traverse();
        System.out.println();
        l2.head = l2.reverseIterative();
        l2.traverse();
        System.out.println();
        Node t1 = l.head;
        Node t2 = l2.head;

        while(t2!=null && t1!=null) {
            Node k1 = t1.next;
            t1.next=t2;
            Node k2 = t2.next;
            t2.next = k1;
            t1=k1;
            t2=k2;

        }
        l.traverse();
    }
}
