package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class AllNodesAtKthDistance {
    public List<Integer> distanceK(Node root, Node target, int k) {
        List<Integer> l = new ArrayList<>();
        distanceK(root, target, k, l);
        return l;
    }

    private int distanceK(Node root, Node target, int k, List<Integer> l) {
        if (root == null) return -1;
        if (root != null && root == target) {
            nodesAtDistKFromRoot(root, k, l);
            return k - 1;
        }
        int left = distanceK(root.left, target, k, l);
        if(left == 0) l.add(root.data);
        if(left > 0) nodesAtDistKFromRoot(root.right, left - 1, l);
        if(left >= 0) return left-1;

        int right = distanceK(root.right, target, k, l);
        if(right == 0) l.add(root.data);
        if(right > 0) nodesAtDistKFromRoot(root.left, right - 1, l);
        if(right >= 0) return right-1;
        return -1;
    }

    private void nodesAtDistKFromRoot(Node root, int k, List<Integer> l) {
        if (root == null || k < 0) return;
        nodesAtDistKFromRoot(root.left, k - 1, l);
        if (k == 0) l.add(root.data);
        nodesAtDistKFromRoot(root.right, k - 1, l);
    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.root = new Node(3);
        b.root.left = new Node(1);
        b.root.right = new Node(4);
        b.root.right.left = new Node(2);
        BinaryTreePrinter.printNode(b.root);
        System.out.println("hey");
        AllNodesAtKthDistance allNodesAtKthDistance = new AllNodesAtKthDistance();
        System.out.println(allNodesAtKthDistance.distanceK(b.root,b.root.right,1));
    }
}
