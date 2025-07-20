package meta2;

import java.util.*;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strings.length; ++i) {
            String hash = getHash(strings[i]);
            if(map.containsKey(hash)) {
                map.get(hash).add(strings[i]);
            } else {
                List<String> l = new ArrayList<>();
                l.add(strings[i]);
                map.put(hash,l);
            }
        }

        List<List<String>> output = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            output.add(entry.getValue());
        }
        return output;
    }

    private String getHash(String str) {
        StringBuilder hash = new StringBuilder();
        for(int i = 1; i < str.length(); ++i) {
            char ASCIDiff = (char)((str.charAt(i) - str.charAt(i-1) + 26) % 26 + 'a');
            hash.append(ASCIDiff);
        }
        return hash.toString();
    }
}
