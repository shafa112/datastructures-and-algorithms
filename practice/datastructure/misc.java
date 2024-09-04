import java.util.*;

public class misc {

    public static void main(String[] args) {
        int count = 15;
        char c = (char)(count+'0');
        System.out.println(c);




        String str1 = "cat";
        String str2 = "tca";
        Map<Integer,Student> map = new HashMap<>();
        map.put(1,new Student("shafa",1));
        map.put(2, new Student("shebi",2));
        System.out.println(map.toString());

        for(Map.Entry<Integer,Student> m : map.entrySet()) {
            System.out.println(m.getValue().id+", "+m.getValue().name);
        }

        List<String> l = new ArrayList<>();
        l.add("shireen");
        l.add("shadab");
        System.out.println(l);

        char[] test = {'a','b','c'};
        String str = new String(test);
        System.out.println("thisssssss :::: "+ str);
    }
}

class Student {

    String name;
    int id;

    static Map<Integer,Student> map;

    public Student() {

    }

    public Student(String name, int id) {
        this.id = id;
        this.name = name;

    }
}
