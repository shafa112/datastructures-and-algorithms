package meta2;

public class MoveZeros {

    // works approx better than O(n) because we don't do anything
    public void moveZeroesBetter(int[] nums) {
        for(int k = 0, i = 0; i < nums.length; ++i) {
            if(nums[i]!=0) {
                swap(nums,k,i);
                ++k;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int i = 0;
        int j = i + 1;
        while( i <= j && j < nums.length) {
            if(nums[i] != 0) {
                ++i;
                ++j;
            }
            else if(nums[i] == 0 && nums[j] != 0) {
                swap(nums,i,j);
                ++i;
                ++j;
            }
            else ++j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
