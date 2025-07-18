package meta;

/**
 * Time: O(m+n)
 * Space: 0(1)
 * https://leetcode.com/problems/merge-sorted-array/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 * */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
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
}
