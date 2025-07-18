package meta;

import java.util.ArrayList;
import java.util.List;

public class SubsetsORPowerSet {
    /**
     * https://leetcode.com/problems/subsets/
     *
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = (int) Math.pow(2,nums.length);
        List<Integer> l = null;
        for(int i = 0; i < n; i++) {
            l = new ArrayList<>();
            for(int j = 0; j < nums.length; ++j) {
                if(((1 << j) & i) != 0) {
                    l.add(nums[j]);
                }
            }
            ans.add(l);
        }

        return ans;
    }
}
