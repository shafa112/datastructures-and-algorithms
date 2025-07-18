package meta2;

public class InsertIntoSortedCircularList {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        Node curr = head;
        Node node = new Node(insertVal);
        while(curr.next != head) {
            if(curr.val <= insertVal && insertVal <= curr.next.val) {
                node.next = curr.next;
                curr.next = node;
                return head;
            } else if(curr.val > curr.next.val) {
                if(insertVal >= curr.val || insertVal <= curr.next.val)
                {
                    node.next = curr.next;
                    curr.next = node;
                    return head;
                }
            }
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        return head;

    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
