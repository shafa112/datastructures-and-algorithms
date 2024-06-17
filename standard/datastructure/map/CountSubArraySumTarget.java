package datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumTarget {

    public static int countSubArraySumTarget(int[] a, int target) {
        //map stores sum from 0 to ith index and its count
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if(sum==target) ++count;
            int countRemainingSum = map.getOrDefault(sum - target, 0);
            count += countRemainingSum;

            int x = map.getOrDefault(sum, 0);
            map.put(sum, x + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1};
        int k = 2;
        System.out.println(2==countSubArraySumTarget(a,k));
    }
}
