package algorithm.searching;

public class LinearSearch {

    //return the index at which element is found
    public int linearSearch(int[] a, int key) {
        for(int i = 0; i < a.length; ++i) {
            if(a[i]==key) return i;
        }
        return -1;
    }

}
