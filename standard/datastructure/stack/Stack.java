package datastructure.stack;

// LIFO - Last in first out
// Implement it as singly linked list
// Add element at start

/**
 * Java has Stack class of its own java.util.Stack
 * But issue with java stack is it is thread safe so normal push pop is slow
 * In java we usually use this
 * Deque<String> stack = new ArrayDeque<>();
 */
public class Stack {

    Node head;
    int size;

    public Stack() {}

    public int push(int data) {
        if(head==null) head = new Node(data);
        else {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }
        size++;
        return head.data;
    }

    public int pop() {
        if(isEmpty()) throw new RuntimeException("Stack is empty.");
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
        return temp.data;
    }

    public int peek() {
        if(isEmpty()) throw new RuntimeException("Stack is empty.");
        return head.data;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

}
