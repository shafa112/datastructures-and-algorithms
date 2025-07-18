package meta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

    public static void main(String[] args) {
        String order = "bcafg";
        String s = "abcd";

        System.out.println(customSortString2(order,s));
    }

    public static String customSortString2(String order, String s) {
        Comparator<Character> c = (c1,c2) -> order.indexOf(c1) - order.indexOf(c2);
        Character[] result = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
        }

        Arrays.sort(result,c);
        String ans = "";
        for (Character ch:result) {
            ans += ch;
        }
        return ans;
    }

    public static String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        char[] result = new char[s.length()];
        int k = 0;
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                while(count-- > 0) {
                    result[k++] = ch;
                }
                map.remove(ch);
            }
        }

        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            while(count-- > 0) {
                result[k++] = ch;
            }
        }

        return new String(result);
    }
}
