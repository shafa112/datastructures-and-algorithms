package datastructure.priorityqueue;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};
        System.out.println(topKFrequent2(a,2));
    }

    public static List<Integer> topKFrequent(int[] a, int k) {
        //create map of data and Node(data,frequency)
        Map<Integer,Node> map = new HashMap<>();
        fillMap(map,a);
        Comparator<Node> byFrequency = (n1,n2) -> n2.frequency-n1.frequency;
        PriorityQueue<Node> pq = new PriorityQueue<>(byFrequency);

        fillPQ(map,pq);

        List<Integer> list = new ArrayList<>();
        while(k-->0) {
            list.add(pq.remove().key);
        }
        return list;
    }

    private static void fillPQ(Map<Integer, Node> map, PriorityQueue<Node> pq) {
        for (Node n: map.values()) {
            pq.add(n);
        }
    }

    private static void fillMap(Map<Integer, Node> map, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])) {
                Node n = map.get(a[i]);
                n.frequency++;
                map.put(a[i],n);
            } else map.put(a[i],new Node(a[i],1));
        }
    }

    static class Node {
        int key;
        int frequency;
        public Node(int key, int frequency) {
            this.key = key;
            this.frequency = frequency;
        }
    }


    public static int[] topKFrequent2(int[] a, int k) {
        Map<Integer,Integer> keyCountMap = new HashMap<>();
        for(int i = 0; i <a .length; i++) {
            int count = keyCountMap.getOrDefault(a[i], 0);
            keyCountMap.put(a[i], count+1);
        }
        Comparator<Integer> byFrequency = (a1,a2) -> keyCountMap.get(a2) - keyCountMap.get(a1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(byFrequency);

        for(int key: keyCountMap.keySet()) {
            pq.add(key);
        }
        List<Integer> list = new ArrayList<>();
        while(k-->0) {
            list.add(pq.remove());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
