package datastructure.tree;

import java.time.temporal.ChronoUnit;
/*
* Better solution at bottom
* */
public class InorderSuccessorBST {

    public static Node inorderSuccessorBST(Node root, Node keyNode) {
        Node current = root;
        Node prev = root;
        int min = Integer.MAX_VALUE;
        Node possibleSuccessor=null;
        while(current!=null && current.data!=keyNode.data) {
            if(current.data>keyNode.data && current.data<min) {
                min = current.data;
                possibleSuccessor=current;
            }
            prev = current;
            if(current.data>keyNode.data) current= current.left;
            else current=current.right;
        }

        if(current==null) return null;
        if(prev != current) {
            if(current.right==null) return possibleSuccessor;
            else return getMinFromRight(current.right);
        } else {
            if(current.right==null) return null;
            else return getMinFromRight(current.right);
        }

    }

    public static Node getMinFromRight(Node rightRoot) {
        Node current = rightRoot;
        Node prev = rightRoot;
        while(current.left != null) {
            prev = current;
            current=current.left;
        }
        return current;

    }

    public static void main(String[] args) {
        Node rooty = new Node(50);
        Node root = new Node(20);
        rooty.left = root;
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left= new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);

        System.out.println(inorderSuccessorBST(rooty,root.right));

    }

    /*
    * More intuitive solution - InOrder Traversal
    * */

    Node answer = null;
    boolean found = false;

    public Node inorderSuccessor(Node root, Node target) {
        inOrder(root, target);
        return answer;
    }

    private void inOrder(Node root, Node target) {
        if(root == null) return;
        inOrder(root.left, target);
        if(found && answer == null) {
            answer = root;
            found = false;
        }
        if(root == target) {
            found = true;
        }
        inOrder(root.right, target);
    }

}
