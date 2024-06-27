package datastructure.array;

import java.util.Arrays;

public class MissingAndDuplicate {

    public static void main(String[] args) {
        int[] a = {3, 1, 3};
        missingAndDuplicate(a);
    }

    /**
     * range:a[i]-> 1 to n
     * 1. count array method: t:O(n) and S:O(n)
     * 2. Two equation: sum and product: tO(n) and S:(1)
     * 3. Implemented: Mark visited, negative will me duplicate and positive ka index+1 will be missing
     */
    public static void missingAndDuplicate(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int abs = Math.abs(a[i]);
            if(a[abs-1]>0) {
                a[abs-1]*=-1;
            }
            else System.out.println("duplicate: "+Math.abs(a[i]));
        }

        for (int i = 0; i < a.length; i++) {
            if(a[i]>0) System.out.println("missing: "+ (i+1));
        }
    }

    //without modifying the array
    public int findDuplicate(int[] a) {
        int count[] = new int[a.length-1];
        for(int i =0;i<count.length;++i) {
            count[i]=(i+1);
        }

        for(int i =0;i<a.length;++i) {
            if(count[a[i]-1]>0) {
                count[a[i]-1]*=-1;
            } else return a[i];
        }
        return -1;
    }

    public int missingNumber(int[] nums) {
        int missNum = nums[0];
        int i =1;
        for ( i = 1; i < nums.length; i++) {
            missNum ^= nums[i]^i;
        }
        return missNum^0^i;
    }
}
