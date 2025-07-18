package meta;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        int i = 0;
        int result = 0;
        int curr = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        while( i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                while( i < s.length() && Character.isDigit(s.charAt(i))) {
                    curr = curr*10 +(s.charAt(i)-'0');
                    ++i;
                }
                --i;
                result += sign*curr;
                curr = 0;
            } else if(s.charAt(i) == '+') sign = 1;
            else if(s.charAt(i) == '-') sign = -1;
            else if(s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            } else if(s.charAt(i) == ')') {
                result += sign*curr;
                result *= stack.pop();
                result += stack.pop();
            }
            ++i;
        }
        return result;
    }
}
