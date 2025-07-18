package meta2;

public class MinAddValidParenthesis {
    public int minAddToMakeValid(String s) {
        if(s.length() == 0) return 0;
        int additions = 0;
        int l = 0;
        int r = 0;

        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') ++l;
            else if(s.charAt(i) == ')') ++r;
            if(l==r) l = r = 0;
            if(r > l) {
                ++additions;
                --r;
            }
        }
        l = r = 0;
        for(int i = s.length() - 1; i >=0; --i) {
            if(s.charAt(i) == '(') ++l;
            else if(s.charAt(i) == ')') ++r;
            if(l==r) l = r = 0;
            if(l>r) {
                ++additions;
                --l;
            }
        }
        return additions;
    }
}
