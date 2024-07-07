package datastructure.trie;


// https://leetcode.com/problems/prefix-and-suffix-search/
//lets say you inserted words, eg. apple ==> "apple{apple", "pple{apple",
// "ple{apple", "le{apple", "e{apple", "{apple"
public class TriePrefixSuffixSearch {

    Trie trie;
    public TriePrefixSuffixSearch(String[] words) {
        trie = new Trie();
        // j: word index in words array
        int j = 0;
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                String str = word.substring(i);
                trie.insert(str+"{"+word, j);
            }
            trie.insert("{"+word, j);
            j++;
        }
    }

    public int f(String pref, String suff) {
        String word = suff+"{"+pref;
        return search(word);
    }
    public int search(String key) {
        if(trie==null) return -1;
        TrieNode temp = trie.root;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if(temp.children[index]==null) return -1;
            temp = temp.children[index];
        }
        return temp.index;
    }

    static class TrieNode {
        String data;
        int index;
        public TrieNode[] children = new TrieNode[27];
    }

    static class Trie {
        public TrieNode root;
        Trie() {
            root = new TrieNode();
            root.data = "";
        }
        // word array index is j
        public void insert(String word, int j) {
            TrieNode temp = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (temp.children[index] == null) {
                    temp.children[index] = new TrieNode();
                }
                temp = temp.children[index];
                temp.index = j;
            }
            temp.data = word;
            temp.index = j;
        }
    }

    public static void main(String[] args) {
        TriePrefixSuffixSearch p = new TriePrefixSuffixSearch(new String[]{"apple"});
        System.out.println(p.f("a","e"));
    }
}
