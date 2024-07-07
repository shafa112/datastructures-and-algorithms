package datastructure.trie;

// Trie data structure of lower case alphabets(26)
public class Trie {

    public TrieNode root;

    Trie() {
        root = new TrieNode();
        root.data = "";
    }

    public void insert(String word) {
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

    public boolean search(String key) {
        TrieNode temp = root;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if(temp.children[index]==null) return false;
            temp = temp.children[index];
        }
        if (temp.data != null && temp.data.equals(key)) return true;
        return false;
    }

    public void delete(String key) {
        TrieNode temp = root;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if(temp.children[index]==null) return;
            temp = temp.children[index];
        }
        temp.data=null;
    }

    static class TrieNode {
        String data;
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }


    public static void main(String[] args) {
        testForDelete();
    }

    private static void testForDelete() {
        Trie t = new Trie();
        t.insert("abc");
        t.insert("def");
        System.out.println(t.search("def") == true);

        t.delete("def");

        System.out.println(t.search("def") == false);
    }
}


