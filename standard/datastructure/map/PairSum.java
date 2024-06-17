package datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class PairSum {

    /*
    * We could have also solved this by sorting(nlogn) and then using 2 pointers
    *
    * Below Solution using map:
    * Time: O(n)
    * Space: O(n)
    * */
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                ans[0]= map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            } else {
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}
