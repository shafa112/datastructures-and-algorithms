package meta2;

public class MissingInSorted {
    public int missingElement(int[] nums, int k) {
        int missing = 0;
        for(int i = 1; i < nums.length && k > 0; ++i) {
            missing = nums[i] - nums[i-1] - 1;
            if(k <= missing) return nums[i-1] + k;
            k = k - missing;
        }
        return nums[nums.length-1] + k;
    }
}
