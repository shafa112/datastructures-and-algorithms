package meta;

public class RandomPickWithWeight {

    int[] prefixSum;

    public RandomPickWithWeight(int[] w) {
        prefixSum = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
    }

    public int pickIndex() {
        int key = (int) (Math.random() * prefixSum[prefixSum.length - 1] + 1);
        int start = 0;
        int end = prefixSum.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (key > prefixSum[mid]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
