package meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumRemoveValidParentheses {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s) {
        char[] str = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while( i < str.length && str[i] == ')')  {
            str[i] ='\0';
            ++i;
        }
        while( j >= 0 && str[j]=='(')  {
            str[j] ='\0';
            --j;
        }

        Stack<Integer> stack = new Stack<>();

        while( i <= j) {
            if(str[i] == '(') stack.push(i);
            if(str[i] == ')') {
                if(!stack.isEmpty() && str[stack.peek()] =='(') stack.pop();
                else str[i]='\0';
            }
            ++i;
        }

        while(!stack.isEmpty()) {
            str[stack.pop()]='\0';
        }
        String ans = new String(str).replace("\0","");

        return ans;
    }
}
