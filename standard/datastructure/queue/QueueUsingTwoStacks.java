package datastructure.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingTwoStacks {

    Deque<Integer> stackToPush = new ArrayDeque<>();
    Deque<Integer> stackToPop = new ArrayDeque<>();


    public int enqueue(int data) {
        stackToPush.push(data);
        return stackToPush.peek();
    }

    public int dequeue() {
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        if(stackToPop.isEmpty()) {
            while(!stackToPush.isEmpty()) stackToPop.push(stackToPush.pop());
        }
        return stackToPop.pop();
    }

    public boolean isEmpty() {
        return stackToPush.isEmpty() && stackToPop.isEmpty();
    }

    public int size() {
        return stackToPush.size()+stackToPop.size();
    }

    public int peek() {
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        if(stackToPop.isEmpty()) {
            while(!stackToPush.isEmpty()) stackToPop.push(stackToPush.pop());
        }
        return stackToPop.peek();
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue()==1);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.dequeue()==2);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
    }
}
