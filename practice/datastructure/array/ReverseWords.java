package array;

import java.util.Arrays;
import java.util.SortedMap;

public class ReverseWords {
    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder("");


        String[] rev = s.split("\\s+");
        for(int i = rev.length-1; i>=0; --i) {
            ans.append(rev[i]).append(" ");
        }

        return ans.toString().trim();
    }

    public static void main(String[] args) {
        System.out.print(reverseWords("the sky is blue"));
        //String s = "a good   example";
        //String[] test1 = s.split("\\s+");




    }
}
