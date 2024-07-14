public class MedianFrom2SortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = nums1.length + nums2.length;
        int half = total/2;
        if(A.length < B.length) {
            int[] C = A;
            A = B;
            B = C;
        }
        int l = 0;
        int r = A.length-1;
        while(true) {
            int i = (l+r)/2;
            int j = half - (i+1) - 1;
            int Aleft = i >= 0 ? A[i] : Integer.MIN_VALUE;
            int Aright = i+1 < A.length ? A[i+1] : Integer.MAX_VALUE;
            int Bleft = j >= 0 ? B[j] : Integer.MIN_VALUE;
            int Bright = j+1 < B.length ? B[j+1] : Integer.MAX_VALUE;

            //partition is correct
            if(Aleft<=Bright && Bleft<=Aright) return (Math.max(Aleft,Bleft)+Math.min(Aright,Bright))/2;
            else if (Aleft<Bright) r = i - 1;
            else l = i + 1;
        }
    }
}
