package datastructure.tree;

public class PopulatingNextRightPointer {
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        Node prevRowStartNode = null;
        Node current = root;
        while (current != null) {
            connectCurrentRow(prevRowStartNode, current);
            prevRowStartNode = current;
            current = getNextRowStart(current);
        }
        return root;
    }

    private Node getNextRowStart(Node current) {
        Node temp = current;
        while (temp != null) {
            if (temp.left == null && temp.right == null) temp = temp.next;
            else return temp.left != null ? temp.left : temp.right;
        }
        return null;
    }

    private void connectCurrentRow(Node prevRowStartNode, Node current) {
        Node prev = prevRowStartNode;
        while (current != null) {
            prev = getParentOfCurrentRight(prev, current);
            if(prev == null) return;
            if(prev.left!= null && prev.left != current)  current.next = prev.left;
            else if(prev.right != null && prev.right != current) current.next = prev.right;
            current = current.next;
        }
    }

    private Node getParentOfCurrentRight(Node prev, Node current) {
        prev = getCurrentParent(prev, current);
        while(prev != null) {
            if(prev.left == current) {
                if(prev.right != null) return prev;
                prev = prev.next;
            } else if(prev.right == current) {
                prev = prev.next;
            } else if(prev.left != null || prev.right != null) return prev;
            else prev = prev.next;
        }
        return null;
    }

    private Node getCurrentParent(Node prev, Node current) {
        while (prev != null) {
            if(prev.left == current || prev.right == current) return prev;
            prev = prev.next;
        }
        return null;
    }
}
