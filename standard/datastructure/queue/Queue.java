package datastructure.queue;

// FIFO - First in first out
// Implement as linked list with insertion at tail and removal from head
public class Queue {
    Node head;
    Node tail;
    int size;

    public Queue() {
    }

    public int enqueue(int data) {
        if(head == null) {
            head = tail = new Node(data);
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        size++;
        return tail.data;
    }

    public int dequeue() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
        return temp.data;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        return head.data;
    }

    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

}
