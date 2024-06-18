package datastructure.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

    int limit;
    NodeDll head;
    NodeDll tail;
    Map<Integer, NodeDll> map;
    int size;

    public LRUCache(int limit) {
        this.limit = limit;
        map = new HashMap<>();
    }

    int get(int key) {
        if (!map.containsKey(key)) return -1;
        NodeDll n = map.get(key);
        updateTailWithRecentlyAccessedKey(n);
        return n.value;
    }

    void put(int key, int value) {
        if (map.containsKey(key)) {
            NodeDll temp = map.get(key);
            temp.value = value;
            deleteNode(temp);
            insertNodeAtEnd(temp);
        } else {
            if (size == limit) {
                evictFromCache();
            }
            NodeDll node = new NodeDll(key, value);
            insertNodeAtEnd(node);
            map.put(key, node);
        }
    }

    private void evictFromCache() {
        NodeDll temp = head;
        deleteNode(head); // this updates head to head.next
        map.remove(temp.key);
    }

    private void updateTailWithRecentlyAccessedKey(NodeDll n) {
        deleteNode(n);
        insertNodeAtEnd(n);
    }

    private void deleteNode(NodeDll n) {
        if (n == head) head = head.next;
        if (n == tail) tail = tail.prev;
        NodeDll prevNode = n.prev;
        if (n.next != null) n.next.prev = prevNode;
        if (prevNode != null) prevNode.next = n.next;
        n.next = null;
        size--;
    }

    private void insertNodeAtEnd(NodeDll n) {
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            n.next = null;
            tail = tail.next;
        }
        ++size;
    }

    private List<List<Integer>> cacheValues() {
        List<List<Integer>> values = new ArrayList<>();
        NodeDll current = head;
        while (current != null) {
            values.add(List.of(current.key, current.value));
            current = current.next;
        }
        return values;
    }

    public static void main(String[] args) {
        test();
    }

    static void test() {
        LRUCache l = new LRUCache(3);
        l.put(1, 20);
        l.put(1, 40);
        l.get(1);
        System.out.println(l.cacheValues());
    }

}

class NodeDll {
    NodeDll prev;
    int key;
    int value;
    NodeDll next;

    public NodeDll(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
