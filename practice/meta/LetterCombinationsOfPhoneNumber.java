package meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;

        Map<Character,String> digitToChar = new HashMap<>();
        buildMap(digitToChar,digits);

        makeCombinations(digits,0,"",digitToChar,result);
        return result;

    }

    private void makeCombinations(String digits, int i,String curr ,Map<Character,String> map, List<String> result) {
        if(digits.length() == curr.length()) {
            result.add(curr);
            return;
        }

        String s = map.get(digits.charAt(i));
        for(int j = 0; j < s.length(); ++j) {
            makeCombinations(digits, i + 1, curr + s.charAt(j) + "",map,result);
        }
    }

    private void buildMap(Map<Character,String> map, String digits) {
        for(int i = 0; i < digits.length(); ++i) {
            if(digits.charAt(i) == '2') {
                map.put(digits.charAt(i),"abc");
            }
            if(digits.charAt(i) == '3') {
                map.put(digits.charAt(i),"def");
            }
            if(digits.charAt(i) == '4') {
                map.put(digits.charAt(i),"ghi");
            }
            if(digits.charAt(i) == '5') {
                map.put(digits.charAt(i),"jkl");
            }
            if(digits.charAt(i) == '6') {
                map.put(digits.charAt(i),"mno");
            }
            if(digits.charAt(i) == '7') {
                map.put(digits.charAt(i),"pqrs");
            }
            if(digits.charAt(i) == '8') {
                map.put(digits.charAt(i),"tuv");
            }
            if(digits.charAt(i) == '9') {
                map.put(digits.charAt(i),"wxyz");
            }
        }
    }
}
