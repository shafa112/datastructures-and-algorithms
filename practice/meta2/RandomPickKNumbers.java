package meta2;

import java.util.Random;

public class RandomPickKNumbers {

    public int[] pick(int[] nums, int k) {
        int[] result = new int[k];
        for(int i = 0; i < k; ++i) {
            result[i] = nums[i];
        }

        for(int i = k; i < nums.length; ++i) {
            int n = i + 1;
            int r = (new Random()).nextInt(n);
            if(r < k) {
                result[r] = nums[i];
            }
        }
        return result;
    }
}
