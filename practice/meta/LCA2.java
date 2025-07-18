package meta;

public class LCA2 {

    boolean foundp = false;
    boolean foundq = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lca2(root,p,q);
        if(foundp && foundq) return lca;
        return null;
    }

    private TreeNode lca2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode left = null;
        TreeNode right = null;
        if(root.left!=null) {
            left = lca2(root.left,p,q);
        }
        if(root.right!=null) {
            right = lca2(root.right,p,q);
        }

        if(root.val == p.val) {
            foundp = true;
            return root;
        }
        if(root.val == q.val) {
            foundq = true;
            return root;
        }
        if(left == null) return right;
        if(right == null) return left;
        return root;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
