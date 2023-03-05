package array;

/*
 * If no constraint, store count in hashmap for each a[i] then traverse hashmap to return max freq element
 *
 * Below implemented method has constraint
 * Constraint: 0<=a[i]<n
 * */
public class MaximumFrequencyElement {

    static int maximumFrequencyElement(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            a[a[i]%n] += n;
        }
        int max = 0;
        int maxFreq = 0;
        for (int i = 0; i < n; ++i) {
            if (maxFreq < a[i] / n) {
                maxFreq = a[i] / n;
                max = i;

            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 1, 2, 1};
        System.out.println(maximumFrequencyElement(a));
    }

}
