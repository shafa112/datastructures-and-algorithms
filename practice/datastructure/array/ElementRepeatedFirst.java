package array;

import java.util.HashMap;
import java.util.Map;

public class ElementRepeatedFirst {

    static int elementRepeatedFirst(int[] a) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])){
                if(map.get(a[i])>0) {
                    int val = map.get(a[i])*-1;
                    map.put(a[i],val);
                }
            } else map.put(a[i],i+1);
        }

        int max = -1000; //todo:check this
        int element = -1;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(max < entry.getValue() && entry.getValue()<0) {
                max = entry.getValue();
                element = entry.getKey();
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 2, 2, 3};
        System.out.println(elementRepeatedFirst(a));
    }

}
