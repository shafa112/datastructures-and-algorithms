package datastructure.tree;

public class TreeToDll {

    public Node inDll(Node root) {
        Node tail = inCircularDll(root);
        if(tail == null) return null;
        Node head = tail.right;
        head.left = null;
        tail.right = null;
        return head;
    }

    // tail of circular double linked list
    Node inCircularDll(Node root) {
        if(root == null) return null;
        Node leftTail = inCircularDll(root.left);
        Node rightTail = inCircularDll(root.right);
        Node currentDllTail = joinLeftRightCurrent(leftTail, rightTail, root);
        return currentDllTail;
    }

    private Node joinLeftRightCurrent(Node leftTail, Node rightTail, Node root) {
        if(leftTail == null && rightTail == null) {
            root.right = root;
            root.left = root;
            return root;
        }
        // rightTail is not null
        if(leftTail == null) {
            Node rightTailHead = rightTail.right;
            rightTailHead.left = null;
            rightTail.right = null;

            root.right = rightTailHead;
            rightTailHead.left = root;
            root.left = rightTail;
            rightTail.right = root;
            return rightTail;
        }
        // left tail is not null
        if(rightTail == null) {
            Node leftTailHead = leftTail.right;
            leftTailHead.left = null;
            leftTail.right = null;

            leftTail.right = root;
            root.left = leftTail;
            leftTailHead.left = root;
            root.right = leftTailHead;
            return root;
        }
        // left and right tail both not null
        Node leftTailHead = leftTail.right;
        leftTailHead.left = null;
        leftTail.right = null;

        Node rightTailHead = rightTail.right;
        rightTailHead.left = null;
        rightTail.right = null;

        leftTail.right = root;
        root.left = leftTail;
        root.right = rightTailHead;
        rightTailHead.left = root;
        rightTail.right = leftTailHead;
        leftTailHead.left = rightTail;
        return rightTail;
    }
}
