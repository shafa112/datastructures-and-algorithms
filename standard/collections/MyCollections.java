package collections;

import java.util.*;
import java.util.function.Consumer;

public class MyCollections {

    public static void main(String[] args) {

        MyCollections mycollections = new MyCollections();

        Student s1 = new Student("shafa",5);
        Student s2 = new Student("shadab",2);
        Student s3 = new Student("shireen",3);
        Student s4 = new Student("shebi",4);
        Student s5 = new Student("richi",6);
        Student s6 = new Student("sandip",1);

        Student[] ar = {s1, s2 , s3, s4, s5, s6};
        //mycollections.traverseArray(ar);

        System.out.println();

        ArrayList<Student> l = new ArrayList<>();
        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(s4);
        l.add(s5);
        l.add(s6);


        //mycollections.traverseArrayList(l);

        //sort arraylist
        l.sort((a, b) -> a.id - b.id );
        System.out.println(l);
        //reverse order
        l.sort((a, b) -> - (a.id - b.id) );
       // l.sort((stu1, stu2) -> stu1.id - stu2.id );
        System.out.println(l);

    }

    private void traverseArray(Student[] a) {

        System.out.println("traversing array using simple for loop");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].id+", "+a[i].name);
        }

        System.out.println("traversing array using for each loop");
        for (Student s : a) {
            System.out.println(s.id+", "+s.name);
        }
        System.out.println();

        System.out.println("Using Arrays.toString");
        System.out.println(Arrays.toString(a));

    }


    private void traverseArrayList(ArrayList<Student> l) {

        System.out.println();
        System.out.println("traversing ArrayList using simple for loop");
        for (int i = 0; i < l.size(); i++) {
            Student s = l.get(0);
            System.out.println(s.id+", "+s.name);
        }

        System.out.println();
        System.out.println("traversing ArrayList using for each loop");
        for(Student s : l) {
            System.out.println(s.id+", "+s.name);
        }

        System.out.println();
        System.out.println("using toString implicit through sout");
        System.out.println(l);

        System.out.println();
        System.out.println("Using while loop");
        int counter = 0;
        while(l.size()!= counter) {
            Student s = l.get(counter);
            System.out.println(s.id+", "+s.name);
            ++counter;
        }

        System.out.println();
        System.out.println("Using Iterator");
        Iterator<Student> it = l.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(s.id+", "+s.name);
        }

        System.out.println();
        System.out.println("Using lambda expression");
        l.forEach( x -> System.out.println(x.id+", "+x.name));

        System.out.println();
        System.out.println("Using enumeration interface");
        Enumeration<Student> e = Collections.enumeration(l);
        while(e.hasMoreElements()) {
            Student s = e.nextElement();
            System.out.println(s.id+", "+s.name);
        }
    }
}

class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{ " +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class StudentPrinter{
    void printing(List<Student> students, Consumer<Student> c)
    {
        for(Student student : students)
        {
            c.accept(student);
        }
    }

    void printCaller()
    {
        List<Student> students = new ArrayList<>();
        String suffix = "Q";
        printing(students , (s) -> {System.out.println(s.name + suffix);});
    }
}
