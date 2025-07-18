package meta2;

public class BSTToArray {
    Node head = null;
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        inOrder(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void inOrder(Node root) {
        if(root == null) return ;
        inOrder(root.left);
        if(prev == null) head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        inOrder(root.right);
    }

    class Node {
        int val;
        Node left;
        Node right;
    }
}
