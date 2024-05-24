package datastructure.tree;

public class HouseRobber3 {

    /*
    * pair : [withRoot,withoutRoot]
    * */

    public int rob(Node root) {
        int[] pair= robHelp(root);
        return Math.max(pair[0],pair[1]);

    }

    int[] robHelp(Node root) {
        if(root==null) return new int[]{0,0};
        int[] leftPair = robHelp(root.left);
        int[] rightPair = robHelp(root.right);
        int withRoot = root.data+leftPair[1]+rightPair[1];
        int withoutRoot  = Math.max(leftPair[0],leftPair[1]) + Math.max(rightPair[0],rightPair[1]);
        return new int[]{withRoot,withoutRoot};
    }

    /*
    * another way , cases passed 122/124 still its good way
    * */

    public int rob2(Node root) {
        return Math.max(solve(root,true),solve(root,false));
    }

    public int solve(Node root, Boolean inc) {
        if(root==null || (!inc && isLeaf(root))) return 0;
        if(inc && isLeaf(root)) return root.data;
        if(inc) {
            return root.data + solve(root.left,false) + solve(root.right,false);
        } else {
            int leftMax = Math.max(
                    solve(root.left,true),solve(root.left,false)
            );

            int rightMax = Math.max(
                    solve(root.right,true),solve(root.right,false)
            );
            return leftMax+rightMax;
        }
    }

    public boolean isLeaf(Node node) {
        return node.left==null && node.right==null;
    }
}
