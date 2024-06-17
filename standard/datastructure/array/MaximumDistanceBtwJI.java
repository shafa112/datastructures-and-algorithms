package datastructure.array;

import java.util.List;

public class MaximumDistanceBtwJI {

    public int maximumGap(final List<Integer> a) {
        int n = a.size();
        if (n == 0) return -1;

        // Create and fill leftMin array
        int[] leftMin = new int[n];
        leftMin[0] = a.get(0);
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(a.get(i), leftMin[i - 1]);
        }

        // Create and fill rightMax array
        int[] rightMax = new int[n];
        rightMax[n - 1] = a.get(n - 1);
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(a.get(j), rightMax[j + 1]);
        }

        // Traverse both arrays to find the maximum j - i
        int i = 0, j = 0, maxDiff = -1;
        while (i < n && j < n) {
            if (leftMin[i] <= rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }

}
