package meta2;


import java.util.Stack;

/**
 * Time and Space : O(n) of calculate
 * Time: O(n) and Space: O(1) of calculate2
 */
public class BasicCalculator2 {
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        int i = 0;
        int currNumber = 0;
        int prevNumber = 0;
        int result = 0;
        char operation = '+';

        while( i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                while( i < s.length() && Character.isDigit(s.charAt(i))) {
                    currNumber = currNumber*10 + (s.charAt(i) - '0');
                    ++i;
                }
                i -= 1;
                if(operation == '+') {
                    result += currNumber;
                    prevNumber = currNumber;
                }
                if(operation == '-') {
                    result -= currNumber;
                    prevNumber = -currNumber;
                }
                if(operation == '*') {
                    result -= prevNumber;
                    result += prevNumber*currNumber;
                    prevNumber = prevNumber*currNumber;
                }
                if(operation == '/') {
                    result -= prevNumber;
                    result += prevNumber/currNumber;
                    prevNumber = prevNumber/currNumber;
                }
                currNumber = 0;
            } else if(!Character.isWhitespace(s.charAt(i))) {
                operation = s.charAt(i);
            }
            ++i;
        }
        return result;
    }

    public static int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int i = 0;
        char operation = '+';
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currentNumber = (10 * currentNumber) + (ch - '0');
            }
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length()-1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = ch;
                currentNumber = 0;
            }
            ++i;
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
