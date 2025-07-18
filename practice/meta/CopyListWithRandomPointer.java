package meta;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    //TC: O(n), SC: O(n)
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();

        map.put(head, new Node(head.val));
        Node temp = head;
        while(temp != null) {
            if(temp.next != null && !map.containsKey(temp.next)) {
                map.put(temp.next,new Node(temp.next.val));
            }
            if(temp.next != null) map.get(temp).next = map.get(temp.next);

            if(temp.random != null && !map.containsKey(temp.random)) {
                map.put(temp.random,new Node(temp.random.val));
            }
            if(temp.random != null) map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        Map<Node,Node> map = new HashMap<>();
        copyList2(head,map);
        Node tempHead = head;
        while(tempHead!=null) {
            Node copyNode = map.get(tempHead);
            copyNode.random = map.get(tempHead.random);
            tempHead = tempHead.next;
        }
        return map.get(head);
    }

    private Node copyList2(Node node, Map<Node, Node> map) {
        if(node == null) return null;
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        newNode.next = copyList2(node.next,map);
        return newNode;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
