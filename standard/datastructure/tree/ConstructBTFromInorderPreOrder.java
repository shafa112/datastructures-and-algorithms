package datastructure.tree;

public class ConstructBTFromInorderPreOrder {

    public Node buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public Node buildTreeHelper(int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if (preorderStart < 0 || preorderEnd >= preorder.length || inorderStart < 0 || inorderEnd >= inorder.length)
            return null;
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) return null;

        Node root = new Node(preorder[preorderStart]);
        int rootIndexInorder = getIndex(inorder, root.data, inorderStart, inorderEnd);
        /*
        * With indexes of inorder of next sub-problem and hence its length, we can find length of preorder of next sub-problem as well.
        *
        * pre: vLR; in: LvR
        * v is root
        * left tree preorder will be (preStart+1,preStart+length(L))
        * and right tree preorder will be(preStart+length(L)+1,preEnd)
        * */
        int len = rootIndexInorder - inorderStart;
        root.left = buildTreeHelper(preorder, inorder, preorderStart + 1, preorderStart + len, inorderStart, rootIndexInorder - 1);
        root.right = buildTreeHelper(preorder, inorder, preorderStart + len + 1, preorderEnd, rootIndexInorder + 1, inorderEnd);
        return root;
    }

    private int getIndex(int[] inorder, int key, int start, int end) {
        for (int i = start; i <= end; ++i) {
            if (inorder[i] == key) return i;
        }
        return -1;
    }
}
