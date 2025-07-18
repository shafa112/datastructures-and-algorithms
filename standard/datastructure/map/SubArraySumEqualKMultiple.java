package datastructure.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Check if sum of any sub-array exists where sub-array:
 * length is at least two, and
 * the sum of the elements of the sub-array is a multiple of k.
 *
 * Mod property being used below:
 * (a-b)%y = ((a%y)-(b%y))%y
 */
public class SubArraySumEqualKMultiple {

    public boolean checkSubArraySum(int[] a, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < a.length; ++i) {
            sum += a[i];
            if(sum%k==0 && i>=1) return true;
            if(map.containsKey(sum%k)) {
                int m = map.get(sum%k);
                if(i-m >= 2) return true; //here since Si - Sm len with include sum of ele from m+1 to i index
            } else {
                map.put(sum%k,i);
            }
        }
        return false;
    }
}
