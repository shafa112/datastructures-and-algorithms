package datastructure.array;

import java.util.LinkedList;
import java.util.List;

/*
* find a[i],a[j] such that i<j and a[i]>a[j]
* think of 2 sorted arrays and how will the inversion count work for them.
*
* Solved with merge sort logic
* TC: NlogN
* SC: O(N)
*
* */
public class CountInversionPairs {

    int count = 0;
    List<List<Integer>> l= new LinkedList<>();
    public int countInversions(int[] a, int start, int end) {
        int cnt = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            int leftCount = countInversions(a, start, mid);
            int rightCount = countInversions(a, mid + 1, end);
            cnt = leftCount+rightCount+countInversions(a, start, mid, end);
        }
        return cnt;
    }

    private int countInversions(int[] a, int start, int mid, int end) {
        //array 1 from start to mid
        //array 2 from mid+1 to end
        int tempCount =0;

        int i = start;
        int j = mid+1;
        int k = 0;
        int[] c = new int[end-start+1];
        while(i<=mid && j<=end) {
            if(a[i] > a[j]) {
                c[k] = a[j];
                tempCount += mid-i+1;
                ++j;
            }
            else {
                c[k] =a[i];
                ++i;
            }
            ++k;
        }

        while (i <= mid) {
            c[k] = a[i];
            ++i;
            ++k;
        }

        while (j <= end) {
            c[k] = a[j];
            ++j;
            ++k;
        }

        k = 0;
        for (i = start; i <= end; ++i) a[i] = c[k++];
        return tempCount;
    }

    public static void main(String[] args) {
        CountInversionPairs c = new CountInversionPairs();
        int array[] = {2,4,1,3,5};
        System.out.println(c.countInversions(array,0,array.length-1));
        //System.out.println("count: "+c.count);
    }
}
