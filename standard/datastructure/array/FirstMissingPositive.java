package datastructure.array;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        for(int i = 0; i<nums.length;++i) {
            if(nums[i]==0 || nums[i]<0) nums[i] = nums.length+1;
        }

        for(int i = 0; i<nums.length; ++i) {
            if(1<=Math.abs(nums[i]) && Math.abs(nums[i]) <= nums.length) {
                if(nums[Math.abs(nums[i])-1]>0)
                {
                    nums[Math.abs(nums[i])-1]*=-1;
                }
            }
        }

        for(int i = 0; i<nums.length;++i) {
            if(nums[i]>0) return i+1;
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(firstMissingPositive(nums));
    }

}
