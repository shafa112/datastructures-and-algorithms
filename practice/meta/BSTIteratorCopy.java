package meta;
import java.util.Stack;

/*
* Approach 1 :
* Do inOrder and store in array
* Time: O(1) for next and hasNext, O(n) for constructor
* Space: O(n)
*
* Approach 2 (Implemented):
* Use stack to push left elements, then pop and if right element exists
* and then put its left element again.
* Time: Average O(1) for next and hasNext, because next can take O(n) to say push if ~n elements
* Space: O(h)
*
* */
public class BSTIteratorCopy {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIteratorCopy(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root) {
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
