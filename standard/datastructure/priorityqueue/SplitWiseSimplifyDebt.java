package datastructure.priorityqueue;

import java.util.*;

public class SplitWiseSimplifyDebt {

    public static List<String> simplifyTransaction(List<String> slitWiseRecord) {
        List<String> ans = new ArrayList<>();
        Map<String,Integer> simplifiedStates = new HashMap<>();
        //buildMap
        for (String trans: slitWiseRecord) {
            String[] str = trans.split(":");
            simplifiedStates.put(str[0],simplifiedStates.getOrDefault(str[0],0)-Integer.parseInt(str[2]));
            simplifiedStates.put(str[1],simplifiedStates.getOrDefault(str[1],0)+Integer.parseInt(str[2]));
        }

        Comparator<Map.Entry<String,Integer>> comparatorForGiving = (e1,e2) -> e1.getValue()- e2.getValue();
        PriorityQueue<Map.Entry<String,Integer>> givingPQ = new PriorityQueue<>(comparatorForGiving);

        Comparator<Map.Entry<String,Integer>> comparatorForReceiving = (e1,e2) -> e2.getValue()- e1.getValue();
        PriorityQueue<Map.Entry<String,Integer>> receivingPQ = new PriorityQueue<>(comparatorForReceiving);

        for(Map.Entry<String,Integer> entry: simplifiedStates.entrySet()){
            if(entry.getValue()<0) givingPQ.add(entry);
            else if(entry.getValue()>0) receivingPQ.add(entry);
        }

        while(!givingPQ.isEmpty() || !receivingPQ.isEmpty()) {
            Map.Entry<String,Integer> giver = givingPQ.remove();
            Map.Entry<String,Integer> receiver = receivingPQ.remove();
            String simpleTxn = buildSimplifiedTransaction(giver, receiver);
            ans.add(simpleTxn);
            int net = giver.getValue()+receiver.getValue();
            if(net>0){
                receivingPQ.add(buildPQEntry(receiver.getKey(), net));
            } else if(net<0) {
                givingPQ.add(buildPQEntry(giver.getKey(), net));
            }
        }
        return ans;
    }

    private static String buildSimplifiedTransaction(Map.Entry<String,Integer> giver, Map.Entry<String,Integer> receiver) {
        return giver.getKey()+":"+receiver.getKey()+":"+ Math.min(-1*giver.getValue(), receiver.getValue());
    }

    private static Map.Entry<String, Integer> buildPQEntry(String key, int val) {
        return  new AbstractMap.SimpleEntry<>(key, val);
    }

    public static void main(String[] args) {
        List<String> l = Arrays.asList("a:b:100", "b:c:50", "b:d:60", "d:e:20", "d:a:20");
        List<String> ans = simplifyTransaction(l);
        System.out.println("simplified transactions");
        System.out.println(ans);
    }
}
