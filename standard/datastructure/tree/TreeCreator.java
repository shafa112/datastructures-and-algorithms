package datastructure.tree;

import java.util.Stack;

public class TreeCreator {

    static Node sortedArrayToBST(int a[], int start, int end) {
        if(start==end) return new Node(a[start]);
        Node root = null;
        if (start<end) {
            int mid = (start+end)/2;
             root = new Node(a[mid]);
             root.left = sortedArrayToBST(a,start,mid-1);
             root.right = sortedArrayToBST(a,mid+1,end);
        }
        return root;
    }

    public void createBinaryTree(int[] a) {

        Node root = new Node(a[0]);
        for (int i = 1; i < a.length; i++) {

        }
    }


}
