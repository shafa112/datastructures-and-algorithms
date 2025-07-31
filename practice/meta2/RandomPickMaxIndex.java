package meta2;

import java.util.Random;

public class RandomPickMaxIndex {
    public int pick(int[] nums) {
        int picked_index = -1;
        int max = Integer.MIN_VALUE;
        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                picked_index = i;
                max = nums[i];
                n = 1;
            }
            else if(nums[i] == max) {
                n++;
                int r = (new Random()).nextInt(n);
                if(r==0) {
                    picked_index = i;
                }
            }
        }
        return picked_index;
    }
}
