import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class misc {

    public static void main(String[] args) {
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
