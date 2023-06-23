package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//a.length = n+2
public class FindRepeatedElements {

    static void printRepeatedElements(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            a[Math.abs(a[i])] *= -1;
        }
        for (int i = 1; i <= a.length - 2; ++i) {
            if (a[i] > 0) System.out.println(i);
        }
    }

    static void printRepeatedElements2(int[] a) {
        int n = a.length - 1;
        for (int i = 0; i < a.length - 2; ++i) {
            //check until current position is correct position
            while ((a[i] - 1) != i) {
                //check if a[i] is at its correct position
                if (a[i] == a[a[i] - 1]) {
                    swap(a, i, n);
                    --n;
                } else {
                    swap(a, i, a[i] - 1);
                }
            }
        }
        System.out.println(a[a.length - 1]);
        System.out.println(a[a.length - 2]);
    }

    public static List<Integer> findDuplicates(int[] a) {
        List<Integer> l = new ArrayList<>();
        //{4,3,2,7,8,2,3,1}
        for (int i = 0; i < a.length; ++i) {
            //check until current position is correct position
            while ((a[i] - 1) != i) {
                //check if a[i] is at its correct position
                if (a[i] == a[a[i] - 1] ) {
                    if(!l.contains(a[i])) {
                        l.add(a[i]);
                    }
                    break;
                } else {
                    swap(a, i, a[i] - 1);
                }
            }
            System.out.println("a:::"+Arrays.toString(a));

        }
        return l;
    }

    public static void swap(int[] a, int i, int j) {
        // System.out.println("swapping i: " + i + " and j: " + j);
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 4, 2, 5, 6, 6};
        // int[] a = {1, 2, 3, 4, 5, 6, 6, 4};
        int[] c ={4,3,2,7,8,2,3,1};
        //printRepeatedElements2(a);
        System.out.println(findDuplicates(c));
    }
}
