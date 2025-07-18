package random;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastInterval {

    public static void main(String[] args) {

    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if(map.containsKey(tasks[i])) {
                int prevCount = map.get(tasks[i]);
                map.put(tasks[i],prevCount+1);
            } else {
                map.put(tasks[i],1);
            }
        }
        Comparator<Integer> c = (task1,task2)->map.get(task2)-map.get(task1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(c);

        for (Map.Entry<Character,Integer> entry:map.entrySet()) {
        }

        return -1;
    }

    class Pair{
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
