package datastructure.array;

import java.util.*;

public class PermutationOfIntArray2 {

    public static void main(String[] args) {
        int[] nums = {1, 2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permu(nums, 0, ans);
        return ans;
    }

    public static void permu(int[] nums, int n, List<List<Integer>> ans) {
        if(n>=nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                l.add(nums[i]);
            }
            ans.add(new ArrayList<>(l));
            return;
        }
        for (int i = n; i < nums.length; i++) {
            swap(nums,i,n);
            permu(nums, n+1, ans);
            swap(nums, i, n);
        }

    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
