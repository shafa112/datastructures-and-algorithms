package meta2;

import java.util.*;

public class LetterCombinationsPhoneNumber {
    List<String> output = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return output;
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuilder str = new StringBuilder();
        helper(0,digits,map,str);
        return output;
    }

    public void helper(int index, String digits, Map<Character,String> map, StringBuilder str) {
        if(index > digits.length()) return;
        if(str.length() == digits.length()) {
            output.add(str.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for(int i = 0; i < letters.length(); ++i) {
            str.append(letters.charAt(i));
            helper(index+1,digits,map,str);
            str.deleteCharAt(str.length()-1);
        }
    }
}
