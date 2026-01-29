package gg;

import java.util.HashSet;
import java.util.Set;

public class ArrayConcatenation {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        int n = nums.length;
        for(int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i];
            ans[n+i] = nums[i];
        }
        return ans;
    }
}
