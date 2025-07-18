package meta;

import java.util.*;

public class LongestSubstringNoRepeatChar {

    public static void main(String[] args) {
        String str = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int len = 0;
        while(j < s.length()) {
            if(set.contains(s.charAt(j))) {
                while(s.charAt(i) != s.charAt(j)) ++i;
                set.remove(s.charAt(i));
                ++i;
            }
            len = Math.max(len, j - i + 1);
            set.add(s.charAt(j));
            ++j;
        }
        return len;
    }
}
