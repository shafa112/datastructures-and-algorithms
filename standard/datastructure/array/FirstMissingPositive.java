package datastructure.array;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        //check if 1 is present
        boolean one_present = false;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i]==1) {
                one_present = true;
                break;
            }
        }

        if(!one_present) return 1;

        //replace data <= 0 to 1 and num > nums.length
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] <= 0 || nums[i] > nums.length) nums[i] = 1;
        }

        // visit the indices denoted by data and mark them mengative
        for(int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) nums[index] *= -1;
        }

        // index with positive data is the missing positive integer
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] > 0) return i + 1;
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(firstMissingPositive(nums));
    }

}
