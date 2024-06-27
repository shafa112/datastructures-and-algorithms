package collections.mycomparator;

import java.util.Arrays;
import java.util.Comparator;

public class SortTwoDArrayByComparatorInteger {
    public static void main(String[] args) {
        int a1[][] = { {8,12,76},{5,3,2}, {90,1,45}};
        Arrays.sort(a1, (a,b) -> a[0]-b[0]);
        for (int[] arr: a1) {
            System.out.print(Arrays.toString(arr)+" ");
        }
    }
}
