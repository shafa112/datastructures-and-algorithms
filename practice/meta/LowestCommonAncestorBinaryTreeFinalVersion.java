package meta;

public class LowestCommonAncestorBinaryTreeFinalVersion {

    public Node lowestCommonAncestor(Node pp, Node qq) {
        Node p = pp;
        Node q = qq;

        if (search(p, q)) return p;
        else if (search(q, p)) return q;

        Node parentP = p.parent;
        while (parentP != null) {
            if (parentP.left == p) {
                if (search(parentP.right, qq)) return parentP;
            } else if (parentP.right == p) {
                if (search(parentP.left, qq)) return parentP;
            }
            p = parentP;
            parentP = parentP.parent;
        }

        Node parentQ = q.parent;
        while (parentQ != null) {
            if (parentQ.left == q) {
                if (search(parentQ.right, pp)) return parentQ;
            } else if (parentQ.right == q) {
                if (search(parentQ.left, pp)) return parentQ;
            }
            q = parentQ;
            parentQ = parentQ.parent;
        }
        return null;
    }

    public boolean search(Node root, Node key) {
        if (root != null) {
            if (root == key) return true;
            else {
                return search(root.left, key) || search(root.right, key);
            }
        }
        return false;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    ;
}
