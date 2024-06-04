package datastructure.array;

import java.util.ArrayList;
import java.util.List;

public class MissingElementSortedArray {

    public static void main(String[] args) {
        int nums[] = {4,7,9,10};
        int k = 1;
        System.out.println(missingElement(nums,k));
    }

    public static int missingElement(int[] nums, int k) {
        int missing = 0;
        for(int i = 1; i < nums.length; ++i) {
            missing = nums[i] - nums[i-1] - 1;
            if(k<=missing) {
                return nums[i-1] + k;
            } else k = k - missing;
        }

        return nums[nums.length-1] + k;
    }
}
