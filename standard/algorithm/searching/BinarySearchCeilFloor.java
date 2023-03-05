package algorithm.searching;

/* Note: Numbers in array should be distinct and sorted
 *
 * Floor: floor(x)= Largest integer less than or equal to x.  y = [x]. ex : [4.3] = 4
 * Ceil : ceil(x) = Least integer greater than or equal to x .  y = ⌈x⌉ . ex : ⌈4.3⌉ = 5
 */
public class BinarySearchCeilFloor {

    //Number of integer strictly less than key
    public static int rank(int a[], int key) {
        int start = 0;
        int end = a.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (key == a[mid]) return mid;
            else if (key < a[mid]) end = mid - 1;
            else if (key > a[mid]) start = mid + 1;
        }
        return start;
    }

    public static int floorIndex(int a[], int key) {
        int rank = rank(a,key);
        if(rank<a.length && a[rank]==key) return rank;
        return rank-1;
    }

    public static int ceilIndex(int a[], int key) {
        int rank = rank(a,key);
        if(rank==a.length) return -1;
        return rank;
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 9, 10, 12, 13};
        int key = 14;
        int b[] = {1, 2, 3, 4, 5};
        System.out.println(rank(a, key));
        System.out.println(floorIndex(a, 15));
        System.out.println(ceilIndex(a, 10));
    }
}
