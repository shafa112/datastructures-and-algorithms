package meta;

public class MaximumConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int len = 0;
        while(right < nums.length) {
            if(nums[right] == 0) k = k - 1;
            while(k < 0 ) {
                if(nums[left] == 0) k = k + 1;
                ++left;
            }
            len = Math.max(len, right - left + 1);
            ++right;
        }
        return len;
    }
}
