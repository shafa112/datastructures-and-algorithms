package datastructure.stack;

import java.util.Stack;

// (()
// )()())
// ()(()(

/**
 * Here for every closing brace ')', we calculate length of possible
 * valid parenthesis onto its immediate length
 * max = Math.max(max, length of valid parenthesis on left of closing brace)
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String str) {
        int length=0;
        int max=0;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; ++i) {
            if(a[i]=='(') s.push(i);
            else {
                s.pop();
                if(s.isEmpty()) s.push(i);
                else length = i - s.peek();
                max = Math.max(length,max);
            }
        }
        return max;
    }
}
