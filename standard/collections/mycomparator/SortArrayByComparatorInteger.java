package collections.mycomparator;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayByComparatorInteger implements Sorting {

    // MAIN IS CLIENT CODE.............................
    public static void main(String[] args) {
        SortArrayByComparatorInteger sortArrayByComparatorInteger = new SortArrayByComparatorInteger();
        //**************************Normal Ascending sort********************************
        int[] arr1 = {6,4,9,10,1,12,76,11};
        System.out.println("original: " + Arrays.toString(arr1));
        sortArrayByComparatorInteger.sortAscending(arr1);
        System.out.println("sorted asc using direct method: " + Arrays.toString(arr1));

        //**************************Normal Descending sort********************************
        int[] arr2 = {6,4,9,10,1,12,76,11};
        System.out.println("original: " + Arrays.toString(arr2));
        sortArrayByComparatorInteger.sortDescending(arr2);
        System.out.println("sorted dsc using direct method: " + Arrays.toString(arr2));

        //**************************MyComparator Ascending sort********************************
        int[] arr3 = {6,4,9,10,1,12,76,11};
        System.out.println("original: " + Arrays.toString(arr3));
        sortArrayByComparatorInteger.sort(arr3, new MyAscComparator());
        System.out.println("sorted asc using MyAscComparator: " + Arrays.toString(arr3));

        //**************************MyComparator Descending sort********************************
        int[] arr4 = {6,4,9,10,1,12,76,11};
        System.out.println("original: " + Arrays.toString(arr4));
        sortArrayByComparatorInteger.sort(arr4, new MyDscComparator());
        System.out.println("sorted desc using MyDscComparator: " + Arrays.toString(arr4));

        //**************************Comparator Ascending sort********************************
        int[] arr5 = {6,4,9,10,1,12,76,11};
        System.out.println("original: " + Arrays.toString(arr5));
        //sortByComparatorInteger.sort(arr5, new Comparator(){
        //                                                     @override
        //                                                     int compare(Integer a, Integer b)
        //                                                     {
        //                                                      return a-b;
        //                                                     }});
        //sortByComparatorInteger.sort(arr5, (a,b) -> {return (a - b);});
        // (a, b) -> { sout("hello i am lambda first statement);}   ===>>>  void func(int a , int b);
        // (a, b) -> {
        //             sout("hello i am lambda first statement);
        //             a-b ;
        //             };   ===>>>  int func(int a , int b);
        // single statement don't need curly braces...
        // last statement is automatically inferred by compiler as return statement...
        sortArrayByComparatorInteger.sort(arr5, (a, b) -> (a - b));
        System.out.println("sorted asc using Lambda Comparator: " + Arrays.toString(arr5));

        //**************************Comparator Descending sort********************************
        int[] arr6 = {6,4,9,10,1,12,76,11};
        System.out.println("original: " + Arrays.toString(arr6));
        sortArrayByComparatorInteger.sort(arr6, (a, b) -> b-a);
        System.out.println("sorted desc using Lambda Comparator: " + Arrays.toString(arr6));

        //**************************Arrays inbuilt sort method********************************
        Integer[] arr7 = {6,4,9,10,1,12,76,11};
        System.out.println("original: " + Arrays.toString(arr7));
        Arrays.sort(arr7, (a,b)-> a-b);
        System.out.println("sorted asc using inbuilt sort method and Lambda Comparator: " + Arrays.toString(arr7));
    }

    public void sort(int[] a, Comparator<Integer> c) {
        for (int i = a.length-1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                // this condition in if, can vary based on type whether integer or object array
                // we moved the comparing logic out of this method
                // And we are passing the comparing logic as a function in this sort method
                if(c.compare(a[j], a[j+1]) > 0) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public void sortAscending(int[] a) {
        for (int i = a.length-1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                // this condition in if, can vary based on type whether integer or object array
                // below is the comparing logic
                if(a[j]>a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public void sortDescending(int[] a) {
        for (int i = a.length-1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                // this condition in if, can vary based on type whether integer or object array
                // below is the comparing logic
                if(a[j]<a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
