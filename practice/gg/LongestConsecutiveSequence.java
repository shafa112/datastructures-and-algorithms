package gg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // TC,SC: O(n)
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < nums.length; ++i) s.add(nums[i]);

        int longest = 1;
        int count = 0;
        for(int x : s) {
            if(!s.contains(x-1)) {
                count  = 0;
                while(s.contains(x)){
                    ++count;
                    x = x + 1;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }

    // TC: O(nlogn), SC :O(n) or O(logn)
    public int longestConsecutive2(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int currentStreak = 0;
        int longestStreak = 1;
        int lastSmallest = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] - 1 == lastSmallest) {
                ++currentStreak;
                lastSmallest = nums[i];
            } else if(nums[i] != lastSmallest) {
                currentStreak = 1;
                lastSmallest = nums[i];
            }
            longestStreak = Math.max(longestStreak,currentStreak);
        }
        return longestStreak;
    }
}
