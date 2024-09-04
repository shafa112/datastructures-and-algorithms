package leet75;

import java.util.ArrayList;
import java.util.Arrays;

public class StringCompression {

        public static int compress(char[] chars) {

            StringBuilder str = new StringBuilder("");
            char ch = chars[0];
            int count = 1;
            for(int i = 1; i < chars.length; ++i) {
                if(chars[i]==ch) {
                    ++count;
                } else {
                    str.append(ch);
                    if(count != 1) {
                        str.append(Integer.toString(count));
                    }
                    ch = chars[i];
                    count = 1;
                }
            }
            str.append(ch);
            if(count != 1) {
                str.append(Integer.toString(count));
            }

            int k = 0;
            for (int i = 0; i < str.length(); i++) {
                chars[k++] = str.charAt(i);
            }
            //chars = str.toString().toCharArray(); -- can't do this because chars is not passed with reference but by value
            return str.toString().length();
        }


    public static void main(String[] args) {
        //char[] chars = {'a','a','b','b','b','c','c','c'};
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
        System.out.println(Arrays.toString(chars));
    }
}
