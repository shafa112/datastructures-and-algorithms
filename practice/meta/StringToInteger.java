package meta;

import java.util.ArrayList;
import java.util.Iterator;

/* https://leetcode.com/problems/string-to-integer-atoi/ */
public class StringToInteger {

    public static void main(String[] args) {
        String s = "   -042";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        int i = 0;
        int sign = 1; // 1 indicates +

        while(i < s.length() && s.charAt(i)==' ') ++i;
        if(i == s.length()) return 0;

        if(s.charAt(i) == '+') ++i;
        else if(s.charAt(i) == '-') {
            ++i;
            sign = -1;
        }

        int result = 0;
        while( i < s.length()) {

            if(Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i)-'0';
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result = result*10 + digit;
            } else break;
            ++i;
        }
        result = result*sign;
        return result;
    }
}
