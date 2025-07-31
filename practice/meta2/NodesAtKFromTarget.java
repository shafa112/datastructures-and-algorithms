package meta2;

import java.util.*;

public class NodesAtKFromTarget {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> l = new ArrayList<>();
        distanceK(root,target,k,l);
        return l;
    }

    private int distanceK(TreeNode root, TreeNode target, int k, List<Integer> l) {
        if(root == null) return -1;
        if(root !=null && root == target) {
            addNodesAtKFromRoot(root,k,l);
            return k-1;
        }

        int left = distanceK(root.left,target,k,l);
        if(left == 0) l.add(root.val);
        if(left > 0) addNodesAtKFromRoot(root.right,left - 1,l);
        if(left >= 0) return left - 1;

        int right = distanceK(root.right,target,k,l);
        if(right == 0) l.add(root.val);
        if(right > 0) addNodesAtKFromRoot(root.left,right - 1,l);
        if(right >= 0) return right - 1;

        return -1;
    }

    private void addNodesAtKFromRoot(TreeNode root, int k, List<Integer> l) {
        if(root == null || k < 0) return;
        addNodesAtKFromRoot(root.left,k-1,l);
        if(k==0) l.add(root.val);
        addNodesAtKFromRoot(root.right,k-1,l);
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
