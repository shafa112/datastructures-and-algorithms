package datastructure.tree;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class AllNodesAtKthDistance {

    public List<Integer> distanceK(Node root, Node target, int k) {
        List<Integer> ans = new ArrayList<>();
        distanceK(root, target, k, ans);
        return ans;
    }

    public int distanceK(Node root, Node target, int k, List<Integer> answer) {
        if (root == null) return -1;
        if (root == target) {
            distanceKFromRoot(target, k, answer);
            return k-1;
        }
        int left = distanceK(root.left, target, k, answer);
        if(left >= 0) {
            if(left == 0) answer.add(root.data);
            else distanceKFromRoot(root.right, left - 1, answer);
            return left - 1;
        }
        int right = distanceK(root.right, target, k, answer);
        if(right >= 0) {
            if(right == 0) answer.add(root.data);
            else distanceKFromRoot(root.left, right-1, answer);
            return right - 1;
        }
        return -1;
    }

    public void distanceKFromRoot(Node root, int k, List<Integer> answer) {
        if (root == null || k < 0) return;
        if (k == 0) answer.add(root.data);
        distanceKFromRoot(root.left, k - 1, answer);
        distanceKFromRoot(root.right, k - 1, answer);
    }
}
