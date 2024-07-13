package uber;

import datastructure.trie.WordDictionary;

import java.util.ArrayList;

/*
* Given two arrays of numbers, firstArray and secondArray.
* Return the length of the longest common prefix (LCP)
* between any pair of numbers from different arrays or o if no common prefix exists.
*
*/
public class LongestCommonPrefix {
    TrieNode root;

    public LongestCommonPrefix() {
        root = new TrieNode();
        root.data = -1;
    }

    public void insert(int num) {
        TrieNode temp = root;
        String numberString = String.valueOf(num);
        char[] ch = numberString.toCharArray();
        int i = 0;
        while(i < ch.length) {
            int index = ch[i]-'0';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
            ++i;
        }
        temp.data=num;
    }

    public int longestCommonPrefix(int[] firstArray, int[] secondArray) {
        //inserting secondArray in Trie - O(n*l) n = length of secondArray, l = max length of each word
        for (int num:secondArray) {
            insert(num);
        }
        //comparing each word(for all lengths) of first array to trie -> O(n*l)
        int max = 0;
        for (int d:firstArray) {
            max = Math.max(max,commonPrefixLength(d));
        }
        return max;
    }

    private int commonPrefixLength(int num) {
        TrieNode temp = root;
        String numberString = String.valueOf(num);
        char[] ch = numberString.toCharArray();
        int i = 0;
        int len = 0;
        while(i < ch.length) {
            int index = ch[i]-'0';
            if(temp.children[index]==null) return len;
            len=len+1;
            temp = temp.children[index];
            ++i;
        }
        return len;
    }

    static class TrieNode {
        public int data;
        public TrieNode[] children = new TrieNode[10];
    }




    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        int[] firstArray = {25,288,2655,54546,54,555};
        int[] secondArray = {2,255,266,244,26,5,54,54547};
        System.out.println(l.longestCommonPrefix(firstArray,secondArray));
    }
}
