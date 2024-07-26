package datastructure.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoCharacterRepeat {

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < s.length()) {
            if(map.containsKey(s.charAt(right))) {
                if(map.get(s.charAt(right)) >= left) {
                    left = map.get(s.charAt(right)) + 1;
                }
            }
            maxLength = Math.max(maxLength,right-left+1);
            map.put(s.charAt(right),right);
            ++right;
        }
        return maxLength;
    }
}
