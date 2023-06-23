package array;

import java.util.Arrays;

public class PythagorasTripletsIndices {

    public static void pythagorasTripletsIndices(int[] a) {

        int[] dummy = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            dummy[i] = a[i] * a[i];
        }

        for (int i = 0; i < dummy.length; i++) {
            int sum = dummy[i];
            int[] ans=SumPair.sumPairIndices(dummy,sum);
            if(ans[0]!=0 || ans[1]!=0) System.out.println(Arrays.toString(ans));
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 6, 5};
        pythagorasTripletsIndices(arr);
    }
}
