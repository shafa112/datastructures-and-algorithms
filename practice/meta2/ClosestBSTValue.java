package meta2;

import datastructure.tree.Node;

public class ClosestBSTValue {
    public int closestValue(Node root, double target) {
        Node closest = null;
        double minDiff = Double.MAX_VALUE;
        Node temp = root;
        while(temp != null) {
            double diff = Math.abs(temp.data - target);
            if(diff < minDiff) {
                minDiff = diff;
                closest = temp;
            }
            if(diff == minDiff) {
                if(temp.data < closest.data) closest = temp;
            }
            if(target > temp.data) temp = temp.right;
            else temp = temp.left;
        }
        return closest.data;
    }
}
