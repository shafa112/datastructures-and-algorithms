import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        System.out.println(Integer.MIN_VALUE);
        String t = "2e0";
        System.out.println(t.substring(2));
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        System.out.println("list: "+l);
        String num = "123";
        System.out.println("num: " + Integer.parseInt(num.substring(1,1)));

        StringBuilder sb = new StringBuilder("Example");
        sb.insert(0, "Prepended ");  // Adds "Prepended " at the start
        System.out.println(sb);
    }

    // pre req: sorted array
    // duplicates: allowed
    static int binarySearchCeilIndex(int a[], int key) {
        int start = 0;
        int end = a.length - 1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(a[mid] < key) start = mid + 1;
            else end = mid;
        }
        if(a[end] < key ) return -1;
        return end;
    }
}
