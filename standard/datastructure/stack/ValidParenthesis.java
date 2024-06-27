package datastructure.stack;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValidParenthesis(String str) {

        char[] a = str.toCharArray();
        Stack<Character> s = new Stack<>();
        int i = 0;
        while(i<a.length) {
            if(a[i]=='(' || a[i]=='{' || a[i]=='[') {
                s.push(a[i]);
            } else {
                if(s.isEmpty()) return false;
                if(a[i]==')') {
                    if(s.peek()!='(') return false;
                    else s.pop();
                } else if (a[i]=='}') {
                    if(s.peek()!='{') return false;
                    else s.pop();
                } else {
                    if(s.peek()!='[') return false;
                    else s.pop();
                }
            }
            ++i;
        }
        if(!s.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        String str = "{([])}";
        System.out.println(isValidParenthesis(str));
    }
}
