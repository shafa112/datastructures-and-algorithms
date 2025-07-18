package meta;

public class CompareStringsLinkedList {

    public static boolean isSimilar(Node l1, Node l2) {
        int i = 0, j = 0;
        while (l1 != null && l2 != null) {
            while (l1 != null && l1.s.isEmpty()) {
                l1 = l1.next;
            }
            while (l2 != null && l2.s.isEmpty()) {
                l2 = l2.next;
            }

            if (l1.s.charAt(i++) != l2.s.charAt(j++)) {
                return false;
            }

            if (i == l1.s.length()) {
                i = 0;
                l1 = l1.next;
            }

            if (j == l2.s.length()) {
                j = 0;
                l2 = l2.next;
            }
        }

        while (l1 != null && l1.s.isEmpty()) {
            l1 = l1.next;
        }
        while (l2 != null && l2.s.isEmpty()) {
            l2 = l2.next;
        }

        return l1 == null && l2 == null;
    }

    public static void main(String[] args) {
        Node l1 = new Node("he");
        l1.next = new Node("");
        l1.next.next = new Node("ll");
        l1.next.next.next = new Node("o");
        l1.next.next.next.next = new Node("");

        Node l2 = new Node("hell");
        l2.next = new Node("o");

        System.out.println(isSimilar(l1, l2));
    }

    static class Node {
        String s;
        Node next;
        Node(String s) {
            this.s = s;
        }
}


}
