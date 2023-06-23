package datastructure.array;

import java.util.*;

public class SortByFrequencyAndMaintainOrder {

    public static void main(String[] args) {
        Integer[]  a = {2,5,2,8,5,6,8,8};
        SortByFrequencyAndMaintainOrder s = new SortByFrequencyAndMaintainOrder();
        s.sortByFrequencyAndMaintainOrder1(a);
    }

    class Pair{
        int firstIndex;
        int count;

        public Pair(int firstIndex, int count) {
            this.firstIndex=firstIndex;
            this.count=count;
        }
    }

    private void sortByFrequencyAndMaintainOrder1(Integer[] a) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])) {
                map.get(a[i]).count++;
            } else {
                Pair p = new Pair(i,1);
                map.put(a[i],p);
            }
        }

        Arrays.sort(a,new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                Pair p1 = map.get(n1);
                Pair p2 = map.get(n2);

                if (p1.count != p2.count) {
                    return p2.count - p1.count;
                } else {
                    return p2.firstIndex - p1.firstIndex;
                }
            }
        });
        System.out.println(Arrays.toString(a));
    }

    private static void sortByFrequencyAndMaintainOrder(int[] a) {

        int[] dummy = new int[a.length];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])) {
                ArrayList<Integer> posCount = map.get(a[i]);
                posCount.set(1,posCount.get(1)+1);
            } else {
                ArrayList<Integer> posCount = new ArrayList<>();
                posCount.add(i);
                posCount.add(1);
                map.put(a[i],posCount);
            }
        }

        for ( Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()) {
            System.out.print("key: "+entry.getKey()+" | value: "+entry.getValue().toString());
            System.out.println();
        }

        int max =0;
        int maxKey = -1;
        int maxKeyIndex=-1;
        int k =0;
        while(!map.isEmpty()) {
             max =0;
             maxKeyIndex=-1;
            maxKey = -1;
            for ( Map.Entry<Integer,ArrayList <Integer> > entry : map.entrySet()){
                if (max < entry.getValue().get(1)){
                    maxKey = entry.getKey();
                    maxKeyIndex = entry.getValue().get(0);
                    max = entry.getValue().get(1);
                }
            }
            map.remove(maxKey);
            while(k<dummy.length && max!=0) {
                dummy[k++]=a[maxKeyIndex];
                --max;
            }
        }
        System.out.println(Arrays.toString(dummy));
    }
}