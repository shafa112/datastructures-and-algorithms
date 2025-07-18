package meta;

public class NextPermutation {
    /**
     * Question: find next larger lexicographically
     * Eg: 2154300
     * step 1: find the index where there is dip, index i such that is nums[i] < nums[i+1]
     *  step 2: find the number greater but smallest to its right to swap with index i
     *  sort in asc order/ reverse to make the nums from i+1 smaller
     *
     *
     */

    // 2154300
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1) {
            reverse(nums,0,nums.length-1);
            return;
        }

        for(int i = nums.length - 1; i > index; --i) {
            if(nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        //2354100
        reverse(nums,index+1,nums.length-1);
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

}
