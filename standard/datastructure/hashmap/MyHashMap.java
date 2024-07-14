package datastructure.hashmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<Key,Value> {

    int Capacity;
    int size;
    List<Node>[] hashTable;

    public MyHashMap(int n) {
        Capacity = n;
        size = 0;
        hashTable = (ArrayList<Node>[]) new ArrayList[n];
    }

    public void put(Key key, Value value) {
        int index = hashFunction(key);
        if(hashTable[index]!=null) {
            Node node = find(hashTable[index], key);
            if(node != null) {
                node.value = value;
                return;
            }
        }

        if(size >= Capacity) {
            System.out.println("Map capacity reached, can't insert anymore");
            return;
        }

        if(hashTable[index]!=null) {
            hashTable[index].add(new Node<>(key,value));
        } else {
            hashTable[index] = new ArrayList<>();
            hashTable[index].add(new Node<>(key,value));
        }
        ++size;
    }

    public Value get(Key key) {
        int index = hashFunction(key);
        if(hashTable[index]!=null) {
            Node node = find(hashTable[index], key);
            if(node != null) return (Value) node.value;
        }
        return null;
    }

    private Node find(List<Node> nodes, Key key) {
        for(Node node: nodes) {
            if(node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    // can just return 0, but it will be bad hash function because it will lead to collision.
    // we should try for the hash function that will lead to minimum collision (uniform distribution in hash table)
    private int hashFunction(Key key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % hashTable.length;
    }

    static class Node<Key,Value> {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
