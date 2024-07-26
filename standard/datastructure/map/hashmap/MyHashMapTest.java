package datastructure.map.hashmap;

import java.util.HashMap;

public class MyHashMapTest {

    public static void main(String[] args) {
        MyHashMap<String,Integer> myHashMap = new MyHashMap<>(5);
        System.out.println(myHashMap.get("Mumbai"));
        myHashMap.put("Delhi",2);
        myHashMap.put("Mumbai",1111);
        myHashMap.put("Delhi",2);
        System.out.println(myHashMap.get("Mumbai"));
        System.out.println(myHashMap.get("Delhi"));

        HashMap map = new HashMap();
        map.put("d", "ew");
//        map.equals()

    }
}
