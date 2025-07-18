package meta;

public class MinimumAddValidParenthesis {

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))(("));
    }

    public static int minAddToMakeValid(String s) {
        int ans = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(') ++left;
            else if(s.charAt(i)==')') ++right;
            if(left == right) {
                left = right = 0;
            } else if( right > left) {
                ans += right;
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i)=='(') ++left;
            else if(s.charAt(i)==')') ++right;
            if(left == right) {
                left = right = 0;
            } else if( right < left) {
                ans += left;
                left = right = 0;
            }
        }
        return ans;
    }
}
