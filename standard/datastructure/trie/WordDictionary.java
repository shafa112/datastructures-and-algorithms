package datastructure.trie;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {

    public TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
        root.data = "";
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.data = word;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String key, TrieNode root) {
        System.out.println("root = " + root + " and searching for key = " + key);
//        System.out.println("Searching for key = " + key);
        TrieNode temp = root;
        for (char ch : key.toCharArray()) {
            if(ch == '.') {
                for(int j = 0; j < 26; j++) {
                    if(temp.children[j] != null) {
//                        String newKey = key.replaceFirst("\\.", (char)(j+'a')+"");
//                        if(search2(newKey, root)) {
//                            return true;
//                        }
                        // Works with this as well
                        String sub = key.substring(key.indexOf('.')+1);
                        if(search(sub, temp.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int index = ch - 'a';
                if(temp.children[index]==null) return false;
                temp = temp.children[index];
            }
        }
        if (temp.data != null) return true;
        return false;
    }

    static class TrieNode {
        String data;
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }

        @Override
        public String toString() {
            List<Character> characters = new ArrayList<>();
            for(int i =0; i<children.length;i++) {
                if(children[i]!=null) {
                    char c = (char) (i+'a');
                    characters.add(c);
                }
            }
            return "{" +
                    "data='" + data + '\'' +
                    ", children=" + characters +
                    '}';
        }
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
//        w.addWord("bad");
//        w.addWord("dad");
//        w.addWord("mad");
        w.addWord("a");
//        w.addWord("a");
        System.out.println(w.search("a."));
    }
}
