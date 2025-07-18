package datastructure.map;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams() {
        List<List<String>> ans = new ArrayList<>();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String sorted = s.chars()
                    .sorted()
                    .mapToObj(c -> String.valueOf((char)c))
                    .collect(Collectors.joining());

            if(map.containsKey(sorted)) {
                List<String> l = map.get(sorted);
                l.add(strs[i]);
            } else {
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                map.put(sorted,l);
            }
        }

        for (Map.Entry<String,List<String>> entry : map.entrySet()) {
            //List<String> subAns = new ArrayList<>();
            //subAns.addAll(entry.getValue());
            ans.add(entry.getValue());
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        g.groupAnagrams();
    }
}
