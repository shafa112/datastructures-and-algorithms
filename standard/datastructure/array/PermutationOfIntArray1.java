package datastructure.array;


import java.util.ArrayList;
import java.util.List;

public class PermutationOfIntArray1 {

    public static void main(String[] args) {
        int[] nums = {1, 2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permu(nums,ans,ds,visited);
        return ans;
    }

    public static void permu(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] visited) {
        if(ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                ds.add(nums[i]);
                visited[i] = true;
                permu(nums, ans, ds, visited);
                ds.remove(ds.size()-1);
                visited[i] = false;
            }
        }
    }
}
