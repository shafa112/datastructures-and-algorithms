package datastructure.stack;

import java.util.Stack;

// (()
// )()())
// ()(()(

public class LongestValidParentheses {



    /**
     * Here for every closing brace ')', we calculate length of possible
     * valid parenthesis onto its immediate length
     * max = Math.max(max, length of valid parenthesis on left of closing brace)
     * time : O(n), space : O(n)
     */
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


    /*
    * Video link:
    * Valid parenthesis will consist of equal number of open and closed brackets
    * When we travel from left to right, we keep a count of left and right bracket
    * when they are equal we calculate length
    * If closing bracket is more than open then we set open and left bracket count to 0
    *
    * Then we travel right to left and do same
    *
    *
    * Time : O(n), space: O(1)
    * */
    public static int longestValidParenthesis(String str) {
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(') ++left;
            else {
                ++right;
            }
            if(right==left) max = Math.max(left+right,max);
            if(right>left) {
                left=right=0;
            }
        }

        left = right = 0;
        for (int i = str.length()-1; i >=0 ; i--) {
            if(str.charAt(i)=='(') ++left;
            else {
                ++right;
            }

            if(right==left) max = Math.max(left+right,max);
            if(left>right) {
                left=right=0;
            }
        }
        return max;
    }
}
