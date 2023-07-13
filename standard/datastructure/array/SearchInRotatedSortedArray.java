package datastructure.array;

import static algorithm.searching.BinarySearch.binarySearchRecursive;
/*
 * pivot here is index of largest element in sorted array
 * input array : {5, 6, 7, 8, 9, 10, 1, 2, 3} then pivot=5(index of element 10)
 */

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {1,2,4};
        int key =2;
        int pivot = findPivot(a,0, a.length-1);
        System.out.println("pivot: "+pivot);
        int index = binSearchWithPivot(a,pivot,key);
        System.out.println("ans: "+index);

    }

    private static int binSearchWithPivot(int[] a, int pivot, int key){
        if(pivot == -1) return binarySearchRecursive(a,0, a.length-1, key);
        if(a[pivot]==key) return pivot;
        if(key>=a[0]) return binarySearchRecursive(a,0,pivot-1,key);
        else return binarySearchRecursive(a,pivot+1,a.length-1,key);
    }


    private static int findPivot(int[] a, int start, int end) {

        if(start>end) return -1;
        if(start==end) return start;
        int mid = (start+end)/2;

        if(mid>start && a[mid-1]>a[mid]) return mid-1;
        if(mid<end && a[mid]>a[mid+1]) return mid;
        if(a[start]>=a[mid]) return findPivot(a, start,mid-1);
        else return findPivot(a, mid+1,end);
    }
}