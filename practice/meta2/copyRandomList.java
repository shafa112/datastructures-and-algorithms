package meta2;

public class copyRandomList {


    public Node copyRandomList(Node head) {
        if(head==null) return null;
        //create interleaved list
        Node temp = head;
        while(temp!=null) {
            Node copynode = new Node(temp.val);
            copynode.next = temp.next;
            temp.next = copynode;
            temp = copynode.next;
        }

        //connect the random pointers
        temp = head;
        while(temp!=null) {
            temp.next.random = (temp.random != null) ? temp.random.next : null;
            temp = temp.next.next;
        }

        Node newhead = head.next;
        //separate the copied list from original
        temp = head;
        Node temp2 = newhead;
        while(temp != null) {
            temp.next = temp.next.next;
            temp2.next = (temp2.next !=null) ? temp2.next.next : null;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return newhead;
    }

    class Node {
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
