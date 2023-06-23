package array;

import static algorithm.searching.BinarySearch.binarySearchRecursive;

public class FindElementSortedArrayWithDuplicate {

    public static void main(String[] args) {
        int[] a = {17,17,17,17,17,17,17,17};
        findElementSortedArrayWithDuplicate(a,17);
    }

    private static void findElementSortedArrayWithDuplicate(int[] a, int key) {
        int index=binarySearchRecursive(a,0,a.length-1,key);
        System.out.println("index::"+index);
        if(index==-1) {
            System.out.println("not found");
            return;
        }
        int firstOccurence = index, lastOccurence = index;
        while(firstOccurence>0) {
            int tempIndex = binarySearchRecursive(a,0,firstOccurence-1, key);
            if(tempIndex!=-1) {
                int tmp = firstOccurence;
                firstOccurence=tempIndex;
            } else break;
        }
        while(lastOccurence<a.length-1) {
            int tempIndex = binarySearchRecursive(a,lastOccurence+1,a.length-1, key);
            if(tempIndex!=-1) {
                int tmp = lastOccurence;
                lastOccurence=tempIndex;
            } else break;
        }
        System.out.println("firt occ: "+ firstOccurence);
        System.out.println("last occ: "+ lastOccurence);
    }
}
