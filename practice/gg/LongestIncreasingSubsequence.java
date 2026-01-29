package gg;

import java.util.*;

public class LongestIncreasingSubsequence {

    // Approach1:Recursion TC:2^n & SC:n, Approach2:Memoization TC:n^2 & SC:n^2[Solution in Standard->DP]
    //Approach3: Binary Search, TC: nlogn, SC: n
    // TC: nlogn, SC: n
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int len = 1;
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] > list.get(list.size()-1)) {
                list.add(nums[i]);
                ++len;
            } else {
                int lowBIndex = lowerBound(list,0, list.size(),nums[i]);
                list.set(lowBIndex,nums[i]);
            }
        }
        return len;
    }

    // TC: log(n)
    private int lowerBound(List<Integer> list, int start, int end, int n) {
        int low = start;
        int high = end;
        int lowerBound = end - start + 1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(list.get(mid) >= n) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }
}
