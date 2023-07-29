package datastructure.stack;

import java.util.*;

public class MinStack {

    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    public int push(int data) {
        stack1.push(data);
        if(stack2.isEmpty()) {
            stack2.push(data);
        }
        if(data<stack2.peek()) stack2.push(data);
        return stack1.peek();
    }

    public int pop() {
        if(isEmpty()) throw new RuntimeException("MinStack is Empty");
        if(stack1.peek()==stack2.peek()) stack2.pop();
        return stack1.pop();
    }

    public int top() {
        if(isEmpty()) throw new RuntimeException("MinStack is Empty");
        return stack1.peek();
    }

    public int getMin() {
        if(isEmpty()) throw new RuntimeException("MinStack is Empty");
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack2.isEmpty();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        //System.out.println(stack.pop());
        stack.push(10);
        stack.push(7);
        stack.push(8);
        System.out.println(stack.getMin()==7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.getMin()==4);
        System.out.println(stack.pop()==5);
        stack.push(3);
        System.out.println(stack.pop()==3);
        System.out.println(stack.pop()==4);
        System.out.println(stack.pop()==8);
        System.out.println(stack.getMin()==7);
    }
}
