package datastructure.array;

import java.util.ArrayList;
import java.util.List;

public class PrintPowerSet {

    static void printPowerSet(char[] set, int set_size)
    {

        /*set_size of power set of a set
        with set_size n is (2**n -1)*/
        long pow_set_size =
                (long)Math.pow(2, set_size);
        int counter, j;

        /*Run from counter 000..0 to
        111..1*/
        for(counter = 0; counter < pow_set_size; counter++)
        {
            for(j = 0; j < set_size; j++)
            {
                /* Check if jth bit in the
                counter is set If set then
                print jth element from set */
                if((counter & (1 << j)) > 0)
                    System.out.print(set[j]);
            }
            System.out.println();
        }
    }

    public static void main (String[] args)
    {
        char[] set = {'a', 'b', 'c'};
        printPowerSet(set, 3);
        //System.out.println(AllPossibleStrings("AA"));
    }



    public static List<String> AllPossibleStrings(String s)
    {
        char[] input = s.toCharArray();
        List<String> ans = new ArrayList<>();
        int powSetSize = (int)Math.pow(2,input.length);
        for(int i = 0; i< powSetSize; ++i) {
            String str = "";
            for(int j = 0; j < input.length; ++j) {
                if((i & (1 << j)) > 0) {
                    str+=input[j];
                }
            }
            ans.add(str);
        }
        return ans;
    }
}
