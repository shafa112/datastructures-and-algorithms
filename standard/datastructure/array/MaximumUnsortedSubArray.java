package datastructure.array;

import java.util.ArrayList;

public class MaximumUnsortedSubArray {

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4, 5};
        int[] t1 = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}; //3 and 8
        int[] test = {10,2,12,19,100,18,99};
        int[] test2 = {1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14, 19, 18};
        ArrayList<Integer> test3 = new ArrayList<>();
        for (int num : test2) {
            test3.add(num); // Auto-boxing from int to Integer
        }
        System.out.println(findUnsortedSubarray(test2));
    }

    /* TC: O(n), SC: O(1)
    * */

    public static int findUnsortedSubarray(int[] nums) {
        boolean sorted = true;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                sorted = false;
            }
            if(!sorted) {
                min = Math.min(min,nums[i]);
            }
        }

        sorted = true;
        int max = Integer.MIN_VALUE;
        for(int i = nums.length-2; i >= 0; i--) {
            if(nums[i] > nums[i+1]) {
                sorted = false;
            }
            if(!sorted) {
                max = Math.max(max,nums[i]);
            }
        }

        int start = -1;
        for(int i = 0; i < nums.length; i++) {
            if(min < nums[i]) {
                start = i;
                break;
            }
        }

        int end = - 1 ;
        for( int i = nums.length - 1; i >=0; --i) {
            if(max > nums[i]) {
                end = i;
                break;
            }
        }

        if(start > end || start == -1) return 0;
        return end - start + 1 ;
    }

    /* TC: O(n)
        SC : O(n)
    * */

    public static ArrayList<Integer> findUnsortedSubarray2(ArrayList<Integer> A) {
            int n = A.size();
            int[] mins = new int[n];
            int[] maxs = new int[n];
            maxs[0] = A.get(0);
            for(int i = 1; i < n; i++) {
                maxs[i] = Math.max(A.get(i), maxs[i-1]);
            }
            mins[n-1] = A.get(n-1);
            for(int i = n - 2; i >= 0; i--) {
                mins[i] = Math.min(A.get(i), mins[i+1]);
            }
            ArrayList<Integer> result = new ArrayList<Integer>();
            int start = 0;
            while (start < n && mins[start] == A.get(start)) start++;
            int end = n - 1;
            while (end >= 0 && maxs[end] == A.get(end)) end--;
            if(start == n) result.add(new Integer(-1));
            else {
                result.add(new Integer(start));
                result.add(new Integer(end));
            }
            return result;
        }

}
