package meta;

import java.util.Arrays;

/**
 * Time: O(n)
 * Space: O(1)
 */

public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
    }

    public static int maximumSwap(int num) {

        String s = Integer.toString(num);
        int max = Integer.MIN_VALUE;
        int max_i = -1;
        int swap_i = -1;
        int swap_j = -1;
        for( int i = s.length() - 1; i >= 0; --i) {
            if(s.charAt(i) > max) {
                max = s.charAt(i);
                max_i = i;
            }
            if(s.charAt(i) < max) {
                swap_i = i;
                swap_j = max_i;
            }
        }

        if(swap_i == -1) return num;
        StringBuilder str = new StringBuilder(s);
        char temp = str.charAt(swap_i);
        str.setCharAt(swap_i,s.charAt(swap_j));
        str.setCharAt(swap_j,temp);

        return Integer.parseInt(str.toString());
    }

    /* TC, SC : O(n)
    * */
    public static int maximumSwap2(int num) {
        String str = Integer.toString(num);
        int[] maxRight = new int[str.length()];
        maxRight[str.length()-1] = str.length()-1;
        for (int i = str.length()-2; i >= 0 ; i--) {
            if(str.charAt(i) < str.charAt(maxRight[i+1])) {
                maxRight[i]  = maxRight[i+1];
            } else maxRight[i] = i;
        }

        System.out.println(Arrays.toString(maxRight));

        char[] number = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if(number[i] <= number[maxRight[i]]) {
                //swap
                System.out.println("swapping");
                char k = number[i];
                System.out.println("swapping "+k+" with "+number[maxRight[i]]);
                number[i] = number[maxRight[i]];
                number[maxRight[i]] = k;
                break;
            }
        }
        return Integer.parseInt(new String(number));
    }
}
