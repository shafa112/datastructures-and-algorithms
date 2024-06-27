package collections.mycomparator;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayByComparatorString {

    public static void main(String[] args) {
        Person p1 = new Person("shafa", 1);
        Person p2 = new Person("shahzad", 1);
        Person p3 = new Person("shadab", 1);
        Person p4 = new Person("richie", 1);
        Person p5 = new Person("shireen", 1);

        Person[] p = {p1, p2, p3, p4, p5};
        Arrays.sort(p, (pA,pB) -> pA.name.compareTo(pB.name));
        System.out.println(Arrays.toString(p));
    }
}

class Person {
    String name;
    int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
