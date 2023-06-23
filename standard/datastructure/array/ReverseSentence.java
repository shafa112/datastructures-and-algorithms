package datastructure.array;

import java.util.Arrays;
import java.util.Stack;

public class ReverseSentence {

    public static void main(String[] args) {
        String sentence = " hello world  ";
        char[] s = sentence.toCharArray();
        //reverseSentence(s);
        System.out.println(reverseWords(sentence));
    }

    //beautiful!!!!
    public static String reverseWords(String s) {

        StringBuilder ans=new StringBuilder();
        for(int start = s.length()-1; start >=0 ; start--) {
            if(s.charAt(start)==' ') {
                continue;
            }
            int end=start;
            while(start>=0 && s.charAt(start)!=' '){
                start--;
            }
            ans.append(s.substring(start+1,end+1)).append(" ");
        }
        return ans.toString().strip();
    }
}
