package meta2;

import java.util.*;

/**
 * Learnt:
 * Java compares(==, ...) values directly for primitive types,
 * for non-primitive types like Integer, or any Object
 * Java will do reference comparison and not value comparison
 *
 * So, when comparing Objects, it's safe to use the equals() or intValue() type of functions.
 */
public class minWindow {
    public static void main(String[] args) {
        String s= "adobecodebanc";
        String t = "abc";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        if(s.isEmpty()) return "";
        Map<Character, Integer> windowmap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        for(char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c,0) + 1);
        }

        int have = 0;
        int need = tmap.size();

        int resLen = Integer.MAX_VALUE;
        int sIndex = -1;

        int l = 0;
        int r = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            if(tmap.containsKey(c)) {
                windowmap.put(c, windowmap.getOrDefault(c,0) + 1);

                // intValue was imp here. Without it 2 Test cases were failing in leet
                if(windowmap.get(c).intValue() == tmap.get(c).intValue()) {
                    have += 1;
                }
            }
            while(have == need) {
                if(resLen > (r-l+1)) {
                    resLen = r - l + 1;
                    sIndex = l;
                }
                char leftChar = s.charAt(l);
                if(windowmap.containsKey(leftChar)) {
                    int count = windowmap.get(leftChar);
                    windowmap.put(leftChar,count-1);
                    if(windowmap.get(s.charAt(l)) < tmap.get(s.charAt(l))) have -= 1;
                }
                l = l + 1;
            }
            r = r + 1;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + resLen);
    }
}
