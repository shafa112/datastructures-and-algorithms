package datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        BinaryTree b = new BinaryTree();
        b.root = new Node(3);
        b.root.left = new Node(1);
        b.root.right = new Node(4);
        b.root.right.left = new Node(2);
        BinaryTreePrinter.printNode(b.root);
        System.out.println("hey");
        //recoverTree(b.root);
        AllNodesAtKthDistance allNodesAtKthDistance = new AllNodesAtKthDistance();
        System.out.println(allNodesAtKthDistance.distanceK(b.root,b.root.right,1));

    }

    private static void testLevelOrderNewLine(BinaryTree b) {
        b.levelOrderNewLine(b.root);
    }

    public static void recoverTree(Node root) {
        System.out.println("In recover");
        if(root==null) return;
        Boolean[] first = new Boolean[]{false};
        Node[] nodesToSwap = new Node[2];
        util(root,nodesToSwap,first);
        System.out.println(nodesToSwap[0]+" "+nodesToSwap[1]);

    }

    private static void util(Node root, Node[] nodesToSwap,Boolean[] first) {
        System.out.println("In util");
        if(root==null) return;
        util(root.left,nodesToSwap,first);
        if(root.left != null) {
            if(root.data < root.left.data) {
                System.out.println("violation");
                if(!first[0]){
                    System.out.println("first: "+root.left.data);
                    nodesToSwap[0] = root.left;
                    first[0]=true;
                }
                System.out.println("sec: "+root.data);
                nodesToSwap[1] = root;
            }
        }
        util(root.right,nodesToSwap,first);
    }

}
