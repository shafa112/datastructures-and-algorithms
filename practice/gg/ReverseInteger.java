package gg;

public class ReverseInteger {
    public int reverse(int x) {
        String s = Integer.toString(x);
        int sign = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }
        int result = 0;
        for (int i = s.length() - 1; i >= start; i--) {
            int digit = s.charAt(i) - '0';
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > (Integer.MAX_VALUE%10))) {
                return 0;
            }
            result = result * 10 + digit;
        }
        return sign * result;
    }
}
