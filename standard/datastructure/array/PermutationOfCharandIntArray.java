package datastructure.array;

import java.util.LinkedList;
import java.util.List;

public class PermutationOfCharandIntArray {

    static List<List<String>> charPermutations = new LinkedList<>();
    static List<List<Integer>> intPermutations = new LinkedList<>();
    public static void main(String[] args) {
        List<String> l = new LinkedList<>();
        String s = "abc";
        boolean[] visited = new boolean[s.length()];
        getPermutations(s,l,visited);
        System.out.println(charPermutations);


        int[] a = {1,2,3};
        List<Integer> l1 = new LinkedList<>();
        getPermutationsIntArray(a,l1,visited);
        System.out.println(intPermutations);
    }


    public static void getPermutations(String s, List<String> l, boolean[] visited)  {
        if(l.size()==s.length()) {
            List<String> temp = new LinkedList<>();
            temp.addAll(l);
            charPermutations.add(temp);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                l.add(s.charAt(i)+"");
                getPermutations(s,l,visited);
                visited[i] = false;
                l.remove(l.size()-1);
            }
        }
    }

    public static void getPermutationsIntArray(int[] a, List<Integer> l, boolean[] visited)  {
        if(l.size()==a.length) {
            List<Integer> temp = new LinkedList<>();
            temp.addAll(l);
            intPermutations.add(temp);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                l.add(a[i]);
                getPermutationsIntArray(a,l,visited);
                visited[i] = false;
                l.remove(l.size()-1);
            }
        }
    }
}
