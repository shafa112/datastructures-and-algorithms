package datastructure.stack;

import java.util.ArrayDeque;
import java.util.Queue;


// O(1) push, O(n) pop
public class StackUsingTwoQueues {

    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    public int push(int data) {
        q1.add(data);
        return data;
    }

    public int pop() {
        if(isEmpty()) throw new RuntimeException("Stack is Empty");
        fillQ2FromQ1ExceptLastElement(q1, q2);
        swap();
        return q2.remove();
    }

    private void swap() {
        Queue<Integer> qtemp = q1;
        q1 = q2;
        q2 = qtemp;
    }

    private void fillQ2FromQ1ExceptLastElement(Queue<Integer> q1, Queue<Integer> q2) {
        if(q1.size()==1) return;
        while(q1.size() > 1) {
            q2.add(q1.remove());
        }
    }

    public int size() {
        return q1.size()+q2.size();
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public int peek() {
        if(isEmpty()) throw new RuntimeException("Stack is Empty");
        fillQ2FromQ1ExceptLastElement(q1, q2);
        swap();
        return q2.peek();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();
        //System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()==3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop()==5);
    }
}
