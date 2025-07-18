package meta2;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; ++i) {

            if(i>0 && nums[i]==nums[i-1]) continue;

            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) --k;
                else if( sum < 0) ++j;
                else {
                    List<Integer> intermediateResult = new ArrayList<>();
                    intermediateResult.add(nums[i]);
                    intermediateResult.add(nums[j]);
                    intermediateResult.add(nums[k]);
                    output.add(intermediateResult);
                    j += 1;
                    while(j < k && nums[j]==nums[j-1]) ++j;
                }
            }
        }
        return output;
    }
}
