package array;

public class IndexIncreasingDecreasing {

    public static void main(String[] args) {
        int[] a = {8, 12, 14, 15 ,16,2,1};
        int i = indexIncreasingDecreasing(a);
        if(i!=-1)  System.out.println(a[i]);
        else System.out.println("not found");
    }

    private static int indexIncreasingDecreasing(int[] a) {
        int index = -1;
        int start = 0;
        int end = a.length-1;
        int mid = 0;
        while(start<end) {
            mid=(start+end)/2;
            if(a[mid]>a[mid+1] && a[mid]>a[mid-1]) {
                return mid;
            } else if(a[mid]<a[mid-1] && a[mid]>a[mid+1]) end = mid;
            else start = mid+1;
        }
        return index;
    }
}
