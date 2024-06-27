    package datastructure.linkedlist;

    /*
    Insertion At End
    Deletion with Key
    Traversal
    Reverse - recursive & iterative
    Middle Node
     */
    public class LinkedList {

        public Node head;

        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node t = head;
                while (t.next != null) t = t.next;
                t.next = newNode;
            }
        }

        public void delete(int data) {
            {
                if (head.data == data) {
                    head = head.next;
                } else {
                    Node t = head;
                    while (t.next != null && t.next.data != data) t = t.next;
                    if (t.next != null) {
                        Node d = t.next;
                        t.next = t.next.next;
                        d.next = null;
                    }
                }
            }
        }

        public void traverse() {
            Node t = head;
            while (t != null) {
                System.out.print(t.data + "-> ");
                t = t.next;
            }
        }


        public Node reverse(Node node) {
            if(node.next == null) return node;
            Node n = node;
            Node t = reverse(n.next);
            if (t.next == null) head = t;
            t.next=node;
            return node;
        }

        public Node reverseIterative() {
            if(head==null) return null;
            Node t1 = head, t2 = head.next;
            Node temp = null;
            while(t2 != null) {
                temp = t1;
                t1 = t2.next;
                t2.next = temp;

                Node temp1 = t1;
                t1 = t2;
                t2 = temp1;
            }
            head.next = null;
            head = t1;
            return head;
        }

        public Node getMid() {
            Node slow = head, fast = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            if(fast.next != null && fast.next.next == null) slow=slow.next;
            return slow;
        }

        Node reverseList(Node head)
        {
            if(head == null) return null;
            Node prev = null;

            Node temphead = head;
            Node t1 = null;
            while(temphead!=null) {
                t1 = temphead;
                temphead = temphead.next;
                t1.next = prev;
                prev = t1;
            }

            return t1;
        }

        public boolean hasCycle(Node head) {
            if(head==null || head.next==null) return false;
            Node slow = head;
            Node fast = head.next;
            while(slow!=null && fast!=null) {
                if(fast==slow) return true;
                slow = slow.next;
                if(fast.next==null) return false;
                fast = fast.next.next;
            }
            return false;
        }


        public static void main(String[] args) {
            System.out.println("Hello from linked list");
            LinkedList l = new LinkedList();
            l.insertAtEnd(1);
            l.insertAtEnd(3);
            //l.delete(1);
            //l.insertAtEnd(5);
            //l.insertAtEnd(6);
            //l.delete(3);
            l.traverse();

            Node n = l.reverse(l.head);
            n.next=null;
            System.out.println();
            l.traverse();
            /*System.out.println();
            System.out.println(l.getMid().data);
            l.reverseIterative();
            System.out.println();
            l.traverse();*/
        }
    }
