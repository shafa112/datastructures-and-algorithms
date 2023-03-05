package algorithm.searching;

public class BinarySearch {

    public int binarySearchIterative(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (a[mid] == key) return mid;
            else if (key < a[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] a, int start, int end, int key) {
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(a[mid]==key) return mid;
        else if (key<a[mid]) return binarySearchRecursive(a, start, mid-1, key) ;
        else return binarySearchRecursive(a, mid+1, end, key) ;
    }
}
