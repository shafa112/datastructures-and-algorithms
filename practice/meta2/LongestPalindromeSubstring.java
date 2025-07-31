package meta2;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        int len = 0;

        int l = -1;
        int r = -1;
        for(int i = 0; i < s.length(); ++i) {
            l = i;
            r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(len < (r - l + 1)) {
                    res = s.substring(l,r+1);
                    len = r - l + 1;
                }
                l -= 1;
                r += 1;
            }

            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(len < (r - l + 1)) {
                    res = s.substring(l,r+1);
                    len = r - l + 1;
                }
                l -= 1;
                r += 1;
            }

        }
        return res;
    }
}
