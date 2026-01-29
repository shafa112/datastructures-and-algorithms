package gg;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder str = null;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == ']') {
                str = new StringBuilder();
                while(!stack.isEmpty() && !(stack.peek()).equals("[")){
                    str.append(stack.pop());
                }
                //str.reverse();
                System.out.println("str: "+str);
                if(!stack.isEmpty() && stack.peek().equals("[")) stack.pop();
                int n = 1;
                int k = 0;
                while(!stack.isEmpty() && isNumeric(stack.peek())) {
                    k = k + n * Integer.parseInt(stack.pop());
                    n = n * 10;
                }
                System.out.println("k: "+k);
                StringBuilder repeated = new StringBuilder();
                while(k != 0) {
                    repeated.append(str);
                    --k;
                }
                System.out.println("repeated: "+repeated);
                stack.push(repeated.toString());
            } else stack.push(s.charAt(i)+"");
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static boolean isNumeric(String s) {
        if (s == null) return false;
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
