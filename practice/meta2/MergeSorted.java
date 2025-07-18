package meta2;

import util.Util;

public class MergeSorted {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        int i = m-1, j = n-1;
        while( i >=0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i];
                --i;
            } else {
                nums1[k--] = nums2[j];
                --j;
            }
        }

        while ( i >= 0) {
            nums1[k--] = nums1[i];
            --i;
        }

        while ( j >= 0) {
            nums1[k--] = nums2[j];
            --j;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};
        int m = 1;
        int n = 5;
        merge(nums1,m,nums2,n);
    }

}
