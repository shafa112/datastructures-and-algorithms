package datastructure.tree;

/**
 * Using idea of Inorder traversal of bst gives sorted order
 * Think in sorted array two index are swapped.
 */
public class TwoNodesSwappedBST {

    Node prev=null,first=null,second=null;
    public void correctBST(Node root) {
        if(root==null)
            return ;
        inorder(root);
        int temp=first.data;
        first.data=second.data;
        second.data=temp;
    }

    void inorder(Node root){
        if(root==null)
            return ;
        inorder(root.left);
        if(prev!=null && root.data<prev.data){
            if(first==null)
                first=prev;
            second=root;
        }
        prev=root;
        inorder(root.right);
    }
}
