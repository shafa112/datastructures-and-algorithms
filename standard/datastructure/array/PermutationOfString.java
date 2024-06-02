package datastructure.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationOfString {

    public static void main(String[] args) {
        String input = "abc";
        List<String> l = new ArrayList<>();
        permute(input, "", l);
        System.out.println("permutations without backtrack: " + l);
        l = new ArrayList<>();
        permuteWithBacktracking(input, 0, l);
        System.out.println("permutations with backtrack: " + l);

    }

    /*
     * Backtracking solution
     * TC = number of operations in each call * no.of calls // no. of calls = no. of nodes in the recursive tree
     * TC = n * n!
     *
     * */
    public static void permuteWithBacktracking(String input, int start, List<String> l) {
        if (start == input.length() - 1) {
            l.add(input);
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = start; i < input.length(); ++i) {
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), i);
                input = swap(input, start, i);
                permuteWithBacktracking(input, start + 1, l);
                input = swap(input, start, i);
            }
        }

    }

    private static String swap(String input, int i, int j) {
        char[] charArray = input.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    /*
     * Recursive solution without backtracking
     * TC = number of operations in each call * no.of calls // no. of calls = no. of nodes in the recursive tree
     * TC = n^2 * n!
     *
     * */
    public static void permute(String input, String output, List<String> l) {
        if (input.length() == 0) {
            l.add(output);
            return;
        }
        //if we have repeated character in input, for eg: aab, then we shouldn't be considering a1a2b and a2a1b as different.
        //So we use map to check if we have already selected that character.
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), i);
                String newInput = input.substring(0, i) + input.substring(i + 1);
                String newOutput = output + input.charAt(i);
                permute(newInput, newOutput, l);
            }
        }

    }
}
