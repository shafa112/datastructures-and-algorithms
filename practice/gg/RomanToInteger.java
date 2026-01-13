package gg;

import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int val = map.get(s.charAt(0));
        int result = 0;
        int i = 0;
        for(i = 0; i < s.length() - 1; ++i) {
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
                result += val;
            } else {
                result += (val*-1);
            }
            val = map.get(s.charAt(i+1));
        }
        result += val;
        return result;
    }
}
