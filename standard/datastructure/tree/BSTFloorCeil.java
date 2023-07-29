package datastructure.tree;

public class BSTFloorCeil {

    public static int floor(Node root, double key) {
        if(root==null) return -1;
        int possibleFloor = Integer.MIN_VALUE;
        Node temp = root;
        while(temp!=null) {
            if(temp.data == key) return temp.data;
            else if (temp.data>key) temp=temp.left;
            else {
                if(temp.data>possibleFloor && temp.data<key) {
                    possibleFloor = temp.data;
                    temp=temp.right;
                }
            }
        }
        return possibleFloor;
    }

    public static int ceil(Node root, double key) {
        if(root==null) return -1;
        int possibleCeil = Integer.MAX_VALUE;
        Node temp = root;
        while(temp!=null) {
            if(temp.data == key) return temp.data;
            else if (temp.data < key) temp=temp.right;
            else {
                if(temp.data < possibleCeil && temp.data > key) {
                    possibleCeil = temp.data;
                    temp=temp.left;
                }
            }
        }
        return possibleCeil;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(6);
        root.right.right = new Node(7);

        BinaryTreePrinter.printNode(root);
        // System.out.println(bst.searchIterative(root, 7));
        System.out.println(floor(root,3.1));
    }

}
