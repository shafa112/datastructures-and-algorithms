package meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;

        List<List<Integer>> ans = new ArrayList<>();
        while( i < nums.length - 2) {
            while( i > 0 && i < nums.length - 1 && nums[i]==nums[i-1]) ++i;

            int j = i + 1;
            int k = nums.length - 1;
            while( j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    ans.add(l);

                    j += 1;
                    while( j < k && nums[j]==nums[j-1]) ++j;

                    k -= 1;
                    while( k >= j && nums[k]==nums[k+1]) --k;
                }
                else if(sum > 0) {
                    k -= 1;
                    while( k >= j && nums[k]==nums[k+1]) --k;
                }
                else {
                    j += 1;
                    while( j < k && nums[j]==nums[j-1]) ++j;
                }
            }
            ++i;
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i]==nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                if(nums[i]+nums[left]+nums[right] > 0) {
                    --right;
                } else if (nums[i]+nums[left]+nums[right] < 0) {
                    ++left;
                } else {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    result.add(l);
                    ++left;
                    while(left < right && nums[left]==nums[left-1]) ++left;
                }
            }
        }
        return result;
    }
}
