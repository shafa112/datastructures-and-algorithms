package datastructure.array;

/**
 * You are given an array of N integers, A1, A2 ,..., AN.
 * Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|
 */
public class MaximumAbsDifference {

    public int getMaxAbsDifference(int[] a) {
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            max1 = Math.max(max1, a[i]+i);
            min1 = Math.min(min1, a[i]+i);

            max2 = Math.max(max2, a[i]-i);
            min2 = Math.min(min2, a[i]-i);
        }
        return Math.max(max1 - min1, max2 - min2);
    }
}
