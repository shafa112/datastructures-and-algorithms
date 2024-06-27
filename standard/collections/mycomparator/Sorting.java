package collections.mycomparator;

import java.util.Comparator;

public interface Sorting {
    public void sort(int[] a, Comparator<Integer> c);
    public void sortAscending(int[] a);
    public void sortDescending(int[] a);
}
