package meta;

import datastructure.tree.Node;

public class RangeSumBST {

    /**
     *
     * In worst case all nodes will be visited to TC: O(n) //case when all nodes fall within range
     * If tree is skewed then SC: O(n) otherwise O(log n)
     */
    public int rangeSumBST(Node root, int low, int high) {
        if(root == null) return 0;
        if(root.data > high) return rangeSumBST(root.left,low,high);
        if(root.data < low) return rangeSumBST(root.right,low,high);
        return root.data + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
    }
}
