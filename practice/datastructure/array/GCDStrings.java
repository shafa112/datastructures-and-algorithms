package array;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t
 * (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2,
 * return the largest string x such that x divides both str1 and str2.
 */
public class GCDStrings {
    //abcabc, abc -> abc
    //abababab, abab -> ab
    public static String gcdOfStrings(String str1, String str2) {

        if (!(str1.concat(str2).equals(str2.concat(str1)))) return "";
        int gcdLength = gcd(str1.length(), str2.length());
        System.out.println("gcd: " + str1.substring(0, gcdLength));
        return null;
    }

    private static int gcd(int n1, int n2) {
        if (n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }

    public static void main(String[] args) {
        String str1 = "ababab";
        String str2 = "abab";
        gcdOfStrings(str1, str2);
    }

}


