package datastructure.tree;

import java.util.Stack;

public class KthSmallestBST {

    Node kthSmall = null;
    int count = 0;
    public int kthSmallest(Node root, int k) {
            Node ans = inOrder(root,0,k);
            if(ans!=null) return ans.data;
            return Integer.MIN_VALUE;
    }

    public void inOrderRec(Node root,int k) {
        if (root == null) return;
        inOrderRec(root.left,k);
        if(++count==k) {
            kthSmall=root;
            return;
        }
        //System.out.print(root.data + " ");
        inOrderRec(root.right,k);
    }

    public Node inOrder(Node root,int count,int k) {

        Stack<Node> s = new Stack<>();
        Node node = root;
        while (node != null || !s.isEmpty()) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            ++count;
            if(count==k) return node;
            System.out.print(node.data + " ");
            node = node.right;
        }
        return null;
    }

    /*
    * Approach 2
    * */
    int ans = 0;
    int p =0;
    public int kthSmallest2(Node root, int k) {
        p=k;
        inOrder(root);
        return ans;
    }

    private void inOrder(Node root) {
        if(root==null) return;
        inOrder(root.left);
        if(p==1) {
            ans = root.data;
        }
        p=p-1;
        inOrder(root.right);
    }

}
