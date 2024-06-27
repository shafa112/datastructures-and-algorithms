package datastructure.tree;

import datastructure.linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeBinaryTree {

    public String serialize(Node root) {
        //convert tree to preOrder list
        List<Integer> l = new ArrayList<>();
        preOrder(root, l);
        return l.toString();
    }

    private void preOrder(Node root, List<Integer> l) {
        if(root==null) return;
        l.add(root.data);
        preOrder(root.left,l);
        preOrder(root.right,l);
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        return null;
    }



    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.root = new Node(2);
        b.root.left = new Node(1);
        b.root.right = new Node(4);
        b.root.right.left = new Node(3);
        BinaryTreePrinter.printNode(b.root);
        System.out.println("hey");

        SerializeDeserializeBinaryTree serializeDeserializeBinaryTree = new SerializeDeserializeBinaryTree();
        //System.out.println(serializeDeserializeBinaryTree.serialize(b.root));

    }
}
