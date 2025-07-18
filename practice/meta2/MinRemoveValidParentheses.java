package meta2;

public class MinRemoveValidParentheses {
    public String minRemoveToMakeValid(String s) {
        char[] ch = s.toCharArray();
        int count = 0;

        for(int i = 0; i < ch.length; ++i) {
            if(ch[i] == '(') ++count;
            else if(ch[i] == ')') --count;

            if(count < 0 && ch[i] == ')') {
                ch[i] = ' ';
                ++count;
            }
        }

        for(int i = ch.length - 1; i >= 0 && count > 0; --i) {
            if(ch[i] =='(') {
                ch[i] = ' ';
                --count;
            }
        }

        return new String(ch).replace(" ","");
    }
}
