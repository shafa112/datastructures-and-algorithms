package datastructure.tree;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaxPathSum {

    /*
    * Uses similar logic to diameter of binary tree
    * */
    public int maxPathSumBetter(Node root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum2(root,max);
        return max[0];
    }

    public int maxPathSum2(Node root,int[] max) {
        if(root==null) return 0;
        int leftMax = Math.max(0,maxPathSum2(root.left,max));
        int rightMax = Math.max(0,maxPathSum2(root.right,max));
        max[0] = Math.max(max[0],root.data+leftMax+rightMax);
        //System.out.println(max[0]);
        return root.data+Math.max(leftMax,rightMax);
    }


    /*
    * Another approach
    * */
    static class MaxSumInfo {
        int sumWithNodeInPath;
        int sumWithNodeNotInPath;

        MaxSumInfo(int sumWithNodeInPath, int sumWithNodeNotInPath) {
            this.sumWithNodeInPath = sumWithNodeInPath;
            this.sumWithNodeNotInPath = sumWithNodeNotInPath;
        }
    }

    public int maxPathSum(Node root) {
        MaxSumInfo maxSumInfo =  getMaxPathSum(root);
        return max(maxSumInfo.sumWithNodeInPath, maxSumInfo.sumWithNodeNotInPath);
    }

    MaxSumInfo getMaxPathSum(Node root) {
        if(root == null) return null;
        MaxSumInfo left = getMaxPathSum(root.left);
        MaxSumInfo right = getMaxPathSum(root.right);
        int current = root.data;
        int sumWithRootInPath = getSumWithRootInPath(current, left, right);
        int sumWithRootNotInPath = getSumWithRootNotInPath(current, left, right);
        return new MaxSumInfo(sumWithRootInPath, sumWithRootNotInPath);
    }

    private int getSumWithRootNotInPath(int current, MaxSumInfo left, MaxSumInfo right) {
        if(left == null && right == null) return current;
        //right not null
        if(left == null) {
            return max(right.sumWithNodeInPath, right.sumWithNodeNotInPath);
        }
        // left not null
        if(right == null) {
            return max(left.sumWithNodeInPath, left.sumWithNodeNotInPath);
        }
        // both not null
        return max(left.sumWithNodeInPath,
                left.sumWithNodeNotInPath,
                right.sumWithNodeInPath,
                right.sumWithNodeNotInPath,
                left.sumWithNodeInPath + current + right.sumWithNodeInPath);
    }

    private int getSumWithRootInPath(int current, MaxSumInfo left, MaxSumInfo right) {
        if(left == null && right == null) return current;
        //right not null
        if(left == null) {
            return max(current, current + right.sumWithNodeInPath);
        }
        //left not null
        if(right == null) {
            return max(current, current + left.sumWithNodeInPath);
        }
        // both not null
        return max(current+left.sumWithNodeInPath, current+right.sumWithNodeInPath, current);
    }

    // Another solution. Here we maintain the max in the class variable
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum2(Node root) {
        return maxPathSum;
    }

    int getMaxIncludingRoot(Node root) {
        if(root == null) return 0;
        int left = getMaxIncludingRoot(root.left);
        int right = getMaxIncludingRoot(root.right);
        int maxIncludingRoot =  max(root.data, root.data+left, root.data+right);
        maxPathSum = max(maxPathSum, maxIncludingRoot, left+root.data+right);
        return maxIncludingRoot;
    }

    static int max(int... a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        return max;
    }

    public boolean hasPathSum(Node root, int target) {
        if(root == null) return false;
        if(root.left == null && root.right == null && target-root.data == 0) return true;
        return hasPathSum(root.left,target-root.data) || hasPathSum(root.right,target-root.data);
    }

}