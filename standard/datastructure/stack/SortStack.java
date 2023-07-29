package datastructure.stack;

import java.util.Stack;

public class SortStack {
    public Stack<Integer> sort(Stack<Integer> mainStack) {
        Stack<Integer> tmpStack = new Stack<>();
        while(!mainStack.isEmpty()) {
            int top = mainStack.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() > top) {
                mainStack.push(tmpStack.pop());
            }
            tmpStack.push(top);
        }
        return tmpStack;
    }
}
