package meta;

public class ValidNumber {

    public static void main(String[] args) {
        String s = "4e+";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        boolean decimal_seen = false;
        boolean number_seen = false;

        int i = 0;
        if(s.charAt(i)=='+' || s.charAt(i)=='-') ++i;
        while( i < s.length()) {
            if(Character.isLetter(s.charAt(i))) {
                if(s.charAt(i) != 'e' && s.charAt(i) != 'E') return false;
                else {
                    System.out.println(number_seen);
                    return number_seen && is_valid_integer(s.substring(i+1));
                }
            } else if (s.charAt(i) == '.') {
                if(decimal_seen) return false;
                decimal_seen = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') return false;
            else {
                System.out.println("here");
                number_seen = true;
            }
            ++i;
        }
        return number_seen;
    }



    private static boolean is_valid_integer(String str_to_test) {
        if(str_to_test.isEmpty()) return false;
        int i = 0;
        boolean number_seen = false;
        if(str_to_test.charAt(i) == '+' || str_to_test.charAt(i) == '-') ++i;
        while(i < str_to_test.length()) {
            if(Character.isDigit(str_to_test.charAt(i))) number_seen = true;
            else return false;
            ++i;
        }
        return number_seen;
    }
}
