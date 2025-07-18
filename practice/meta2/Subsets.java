package meta2;

import java.util.*;

public class Subsets {

    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        backtrack(0,curr,nums);
        return output;
    }

    private void backtrack(int index, List<Integer> curr, int[] nums) {
        output.add(new ArrayList(curr));
        for(int i = index; i < nums.length; ++i) {
            curr.add(nums[i]);
            backtrack(i+1, curr, nums);
            curr.remove(curr.size()-1);
        }
    }
}
