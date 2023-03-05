package algorithm.searching;

public class TestSearching {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        LinearSearch linearSearch = new LinearSearch();
        System.out.println("At index: " + linearSearch.linearSearch(a,4));

        BinarySearch binarySearch = new BinarySearch();
        System.out.println("At index: " + binarySearch.binarySearchIterative(a,4));
        System.out.println("At index: " + BinarySearch.binarySearchRecursive(a,0,a.length-1,4));
    }

}
