package meta2;

public class KthMissingPositive {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        if(k < arr[0]) return k;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            int missing = arr[mid] - mid - 1;
            if(missing < k) start = mid+1;
            else end = mid - 1;
        }
        return end + 1 + k;
    }
}
