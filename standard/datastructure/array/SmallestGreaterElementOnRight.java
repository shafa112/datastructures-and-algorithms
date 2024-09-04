package datastructure.array;

import java.util.Set;
import java.util.TreeSet;

/*
* Using TreeSet class of Java
* Set<Integer> s = new TreeSet<> //On doing this 'higher' method was not accessible through s
* TreeSet<Integer> s = new TreeSet<> //On doing this 'higher' method is accessible.
*
*
* Higher method of TreeSet returns upperbound for the element in the TreeSet, or it returns null
*
* Time Complexity: O(N*logN)
* we are using a loop to traverse N times and
* in each traversal we are inserting to the set which will take logN time.
*
* Space: O(N)
*
* */
public class SmallestGreaterElementOnRight {

    public static void main(String[] args) {
        int a[] = {4, 5, 2, 25};
        smallestGreaterElementOnRight(a);
    }

    public static void smallestGreaterElementOnRight(int[] a) {
        TreeSet<Integer> t = new TreeSet<>();
        for (int ele: a ) {
            t.add(ele);
        }
        for (int i = 0; i < a.length; i++) {
            if( t.higher((a[i])) == null) {
                System.out.println(a[i] +" --> "+-1);
            } else {
                System.out.println(a[i] +" --> "+t.higher(a[i]));
                t.remove(a[i]);
            }
        }
    }
}