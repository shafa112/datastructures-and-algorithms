package meta2;

import java.util.*;

public class CustomSortStr {
    public String customSortString(String order, String s) {
        if(order == s) return s;
        Comparator<Character> byOrder = (c1, c2) -> order.indexOf(c1) - order.indexOf(c2);
        Character[] output = new Character[s.length()];
        for(int i = 0; i < s.length(); ++i) {
            output[i] = s.charAt(i);
        }
        Arrays.sort(output,byOrder);
        String ans = "";
        for(int i = 0; i < output.length; ++i) {
            ans += output[i]+"";
        }
        return ans;
    }
}
