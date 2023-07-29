package datastructure.stack;

import java.util.Arrays;
import java.util.Stack;

// https://www.geeksforgeeks.org/the-stock-span-problem/
public class StockSpan {

    public static int[] calculateSpan(int price[]) {
        int span[] = new int[price.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = price.length-1;i >= 0; i--) {
            span[i]=1;
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                if(price[i]<price[stack.peek()]) stack.push(i);
                else {
                    while(!stack.isEmpty() && price[i]>price[stack.peek()]) {
                        int index = stack.pop();
                        if(!stack.isEmpty()) span[stack.peek()]+=span[index];
                    }
                    stack.push(i);
                }
            }
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            if(!stack.isEmpty()) span[stack.peek()]+=span[index];
        }
        return span;
    }

    //Better solution
    // span is greater than or equal to
    // remove stack elements until all lesser elements are removed
    // for any element at index i , span = i - (stack.peek..which will be just greater element than element at i)
    public static int[] getSpan(int price[]) {
        int span[] = new int[price.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < price.length; i++) {
            span[i] = 1;
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) span[i] = i - stack.peek();
            else {
                span[i] = i + 1;
            }
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int price[] = {74,665,742,512};
        int span[] = getSpan(price);
        System.out.println(Arrays.toString(span));
//        System.out.println(Arrays.toString(price));
//        for(int i = 0; i < price.length; i++) {
//            System.out.println(span[i] + ", " + price[i]);
//        }

    }
}
