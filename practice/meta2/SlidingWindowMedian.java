package meta2;

import util.Util;

import java.util.*;

public class SlidingWindowMedian {


    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n-k+1];
        int p = 0;
        Map<Integer,Integer> map = new HashMap<>();

        if(k >= nums.length) {
            Arrays.sort(nums);
            if(k%2!=0) {
                nums[0] = nums[nums.length]/2;
            }
        }

        Comparator<Integer> minPQComparator = (i,j) -> i - j;
        Comparator<Integer> maxPQComparator = (i,j) -> j - i;
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(minPQComparator);
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(maxPQComparator);

        int i = 0;
        int j = 0;

        while(j < nums.length) {
            if(maxPQ.isEmpty()) {
                maxPQ.add(nums[j]);
            } else {
                if(nums[j] >= maxPQ.peek()) {
                    minPQ.add(nums[j]);
                } else maxPQ.add(nums[j]);
            }


            if(maxPQ.size() == minPQ.size() + 2) {
                minPQ.add(maxPQ.remove());
            } else if(maxPQ.size() + 1 == minPQ.size()) {
                maxPQ.add(minPQ.remove());
            }

            if(maxPQ.size() + minPQ.size() == k) {
                if(maxPQ.size() == minPQ.size()) {
                    int median = (maxPQ.peek() + minPQ.peek())/2;
                    ans[p++] = median;
                } else {
                    ans[p++] = maxPQ.peek();
                }
            }

            if(j-i+1 == k) {
                ++i;
            }
            ++j;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,1,4,2};
        int k = 3;
        double[] ans = medianSlidingWindow(nums,k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
