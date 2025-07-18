package meta2;

public class MaximumConsecutiveOne {
    //k is number of 0s you can flip back to 1s
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0;
        int l = 0;
        int r = 0;
        int zeros = 0;
        while(r < nums.length) {
            if(nums[r] == 0) zeros++;
            if(zeros > k) {
                if(nums[l] == 0) --zeros;
                ++l;
            }
            if(zeros <= k) maxlen = Math.max(maxlen,r-l+1);
            ++r;
        }
        return maxlen;
    }
}
