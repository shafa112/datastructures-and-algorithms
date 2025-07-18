package meta;

public class InsertIntoSortedCircularLL {

    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node curr = head;
        while(curr.next!=head) {
            if(curr.val <= insertVal && insertVal <= curr.next.val) {
                Node node = new Node(insertVal);
                node.next = curr.next;
                curr.next = node;
                return head;
            } else if(curr.val > curr.next.val) {
                if(curr.val <= insertVal || insertVal <= curr.next.val) {
                    Node node = new Node(insertVal);
                    node.next = curr.next;
                    curr.next = node;
                    return head;
                }
            }
            curr = curr.next;
        }

        Node node = new Node(insertVal,curr.next);
        curr.next = node;
        return head;
    }

    static class Node {
        int val;
        Node next;
        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
