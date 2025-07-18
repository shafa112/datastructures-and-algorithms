package meta2;

public class RandomPickWeight {

    int[] cumSum;
    int sum = 0;

    public RandomPickWeight(int[] w) {
        cumSum = new int[w.length];
        cumSum[0] = w[0];
        for(int i = 1; i < w.length; ++i) {
            cumSum[i] = cumSum[i-1] + w[i];
        }
        sum = cumSum[w.length-1];
    }

    public int pickIndex() {
        int n = (int) (Math.random()*sum+1);

        int l = 0;
        int r = cumSum.length - 1;
        while(l < r) {
            int mid = l + (r-l)/2;
            if(n <= cumSum[mid]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
