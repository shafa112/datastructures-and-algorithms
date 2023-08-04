package algorithm.dynamicprogramming;


// https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartitioning {
    public static int minCut(String s) {
        return minCut(s, 0, s.length()-1);
    }

    // Note: Solved but time limit exceeded. So dp-fy
    static int minCut(String s, int i,  int j) {
        if(isPalindrome(s, i, j)) return 0;
        int ans = j-i;
        for(int m = i; m < j ; m++) {
            ans = Math.min(ans, 1 + minCut(s, i,m) + minCut(s, m+1, j));
        }
        return ans;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i<j) if(s.charAt(i++)!=s.charAt(j--))return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCut("aa"));
    }
}
