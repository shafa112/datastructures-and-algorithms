package meta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FindFirstLastPositionOfElementSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int first = searchTarget(nums, 0 , nums.length-1, target, true);
        if(first == -1) return new int[]{-1, -1};

        int last = searchTarget(nums, 0 , nums.length-1, target, false);


        return new int[]{first, last};
    }

    private int searchTarget(int[] nums, int start, int end, int target, boolean canProcessFirst) {
        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] == target) {
                if(canProcessFirst) {
                    if(mid == start || nums[mid-1] != target) return mid;
                    end = mid - 1;
                } else {
                    if(mid == end || nums[mid+1] != target) return mid;
                    start = mid + 1;
                }
            } else if(nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }



}
