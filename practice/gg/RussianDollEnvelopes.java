package gg;

import java.util.*;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Comparator<int[]> byWidth = (a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        };

        Arrays.sort(envelopes,byWidth);
        int[] heights = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; ++i) {
            heights[i] = envelopes[i][1];
        }

        return lengthOfLIS(heights);
    }

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
