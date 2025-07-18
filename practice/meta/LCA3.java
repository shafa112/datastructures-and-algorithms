package meta;



import java.util.HashSet;
import java.util.Set;

public class LCA3 {

    // TC: O(n), SC: O(1)
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pcopy = p;
        Node qcopy = q;
        while(pcopy!=qcopy) {
            if(pcopy.parent!=null) pcopy = pcopy.parent;
            else pcopy = q;
            if(qcopy.parent!=null) qcopy = qcopy.parent;
            else qcopy = p;
        }
        return pcopy;
    }

    // TC: O(n) and SC: O(n)
    public Node lowestCommonAncestor2(Node p, Node q) {
        Set<Node> s = new HashSet<>();
        while(p!=null) {
            s.add(p);
            p = p.parent;
        }

        while(q!=null) {
            if(s.contains(q)) return q;
            q = q.parent;
        }
        return null;
    }

    static class Node{
        int va;
        Node left;
        Node right;
        Node parent;
    }
}
