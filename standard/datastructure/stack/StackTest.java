package datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackTest {

    public static void main(String[] args) {
//        testEmptyStackPop();
        Deque<String> stack = new ArrayDeque<>();
    }

    static void emptyStack() {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty() == true);
    }

    static void stackWithNonEmptyTest() {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(-1);
        stack.push(3);
        System.out.println(stack.peek() == 3);
        System.out.println(stack.pop() == 3);
        System.out.println(stack.pop() == -1);
        System.out.println(stack.pop() == 5);
        System.out.println(stack.isEmpty() == true);
    }

    static void testEmptyStackPop() {
        Stack stack = new Stack();
        try {
            stack.pop();
            System.out.println("Test failed");
        } catch (RuntimeException r) {
            System.out.println("Test passed");
        }
    }
}
