package array;

import java.util.*;

public class SumPair {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        sumPair(a, 9);
    }

    //using hashmap
    public static int[] sumPairIndices(int[] a, int sum) {
        int[] ans = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (m.containsKey(sum - a[i])) {
                int index2 = m.get(sum - a[i]);
                ans[0] = index2;
                ans[1] = i;
                break;
            } else m.put(a[i], i);
        }
        return ans;
    }

    public static boolean sumPair(int [] a, int sum) {
        Arrays.sort(a);

        int i =0,j=a.length-1;
        while(i<j) {
            if(a[i]+a[j]==sum) {
                System.out.println(i+"------"+j);
                return true;
            }
            else if(a[i]+a[j]>sum)--j;
            else ++i;
        }
        return false;
    }
}
