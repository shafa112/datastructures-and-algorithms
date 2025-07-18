package meta2;

public class FindPeakElement {
    public static void main(String[] args) {
        int nums[] = {1,2,9,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]) end = mid - 1;
            else if(mid < nums.length - 1 && nums[mid] < nums[mid+1]) start = mid+1;
            else return mid;
        }
        return -1;
    }


}
