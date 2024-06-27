package datastructure.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DistinctNumbersInWindow {

    public int[] distinctNumbers(int[] a, int k) {
        if (k >= a.length) {
            return new int[]{countDistinctElements(a, 0, a.length - 1)};
        }
        int[] ans = new int[a.length - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        ans[0] = map.size();

        int m = 1;
        for (int i = k; i < a.length && m < ans.length; i++, m++) {
            if (map.get(a[i - k]) == 1) map.remove(a[i - k]);
            else map.put(a[i - k], map.get(a[i - k]) - 1);
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            ans[m] = map.size();
        }
        return ans;
    }

    private int countDistinctElements(int[] a, int start, int end) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            map.put(a[i], i);
        }
        return map.size();
    }

    public static void main(String[] args) {
        DistinctNumbersInWindow d = new DistinctNumbersInWindow();
        int[] a = {1, 2, 3, 2, 2, 1, 3};
        int k = 3;
        System.out.println(Arrays.toString(d.distinctNumbers(a, k)));
    }
}
