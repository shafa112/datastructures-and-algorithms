package datastructure.tree;

public class BinarySearchTree {

    Node root;

    /*
    Rewrite and use the root variable above. Think external party is using this data structure
     */
    public Node insert(Node root, int key) {
        if(root==null) return new Node(key);
        Node current = root;
        Node prev = root;
        while(current!=null) {
            prev = current;
            if(current.data > key) current = current.left;
            else current = current.right;
        }
        if(prev.data > key) prev.left = new Node(key);
        else prev.right = new Node(key);
        return root;
    }

    public Node insertIntoBSTRecursive(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insertIntoBSTRecursive(root.left, data);
        if (data > root.data) root.right = insertIntoBSTRecursive(root.right, data);
        return root;
    }

    public boolean isBst(Node root) {
        return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isBst(Node root, long min, long max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return isBst(root.left, min, root.data) && isBst(root.right, root.data, max);
    }

    public Node search(Node root, int key) {
        if (root == null) return null;
        if (root.data == key) return root;
        else if (root.data < key) return search(root.right, key);
        else return search(root.left, key);
    }

    public Node searchIterative(Node root, int key) {
        Node current = root;
        while (current != null && current.data != key) {
            if (current.data > key) current = current.left;
            else current = current.right;
        }
        return current;
    }

    public Node findMinNode(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // key node to be deleted after search
    // Returns root of new tree
    // Logic:
    // - search key node.
    // - Find minimum node in the right subtree of key node and delete it
    // - The minimum node in previous step should replace the key node to be deleted
    public Node deleteNode(Node root, int key) {
        if (root == null) return null;
        Node current = root;
        Node prevNode = root;
        while (current != null && current.data != key) {
            prevNode = current;
            if (current.data > key) current = current.left;
            else current = current.right;
        }
        //node to be deleted not found
        if (current == null) return root;

        if (prevNode.right == current) {
            if (current.right == null) {
                prevNode.right = current.left;
            } else {
                Node minNodeInRight = deleteMinNode(current, current.right);
                minNodeInRight.left = current.left;
                minNodeInRight.right = current.right;
                prevNode.right = minNodeInRight;
            }
        } else if (prevNode.left == current) {
            if (current.right == null) {
                prevNode.left = current.left;
            } else {
                Node minNodeInRight = deleteMinNode(current, current.right);
                minNodeInRight.left = current.left;
                minNodeInRight.right = current.right;
                prevNode.left = minNodeInRight;
            }
        } else {
            // root of the tree is the element to be deleted
            if (current.right == null) {
                return current.left;
            } else {
                Node minNodeInRight = deleteMinNode(current, current.right);
                minNodeInRight.left = current.left;
                minNodeInRight.right = current.right;
                return minNodeInRight;
            }
        }
        current.left = current.right = null;
        return root;
    }


    // Deletes and returns the minimum node
    // Not handling when rootParent is null
    public Node deleteMinNode(Node rootParent, Node root) {
        if (root == null) return null;
        Node prev = root;
        Node current = root;
        while (current.left != null) {
            prev = current;
            current = current.left;
        }
        // root is not minimum
        if (prev != current) {
            prev.left = current.right;
        } else { // root is minimum
            if (rootParent.right == root) {
                rootParent.right = current.right;
            } else {
                rootParent.left = current.right;
            }
        }
        current.right = null;
        return current;
    }

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
    public Node lowestCommonAncestor(Node root, Node pp, Node qq) {
        if (root == null) return null;
        // Assigning lesser of two to p and greater to q
        Node p = pp.data <= qq.data ? pp : qq;
        Node q = qq.data >= pp.data ? qq : pp;

        // root is the LCA
        if (root == p || root == q) return root;
        else if (root.data > p.data && root.data < q.data) return root;

        // LCA exist in the left subtree
        else if (root.data > q.data) return lowestCommonAncestor(root.left, p, q);
        // LCA exist in the right subtree
        return lowestCommonAncestor(root.right, p, q);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = new Node(6);
        root.left = new Node(2);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        // BinaryTreePrinter.printNode(root);
        System.out.println(bst.lowestCommonAncestor(root, root.left, root.right));
    }

    public boolean isValidBST(Node root, int min, int max) {
        if(root==null) return true;
        if(root.data<=min || root.data>=max) return false;
        return isValidBST(root.left,min,root.data) && isValidBST(root.right,root.data,max);
    }

    public Node successor(Node root, Node key) {
        if(root == null) return null;
        if(root.data == key.data) return null;
        Node temp = root;
        Node parent = null;
        Node grandParent = null;
        while(temp!=null) {
            if(temp.data == key.data) {
                if(parent!=null && parent.left.data == temp.data) {
                    if(temp.right!=null) return getMinFromRight(temp.right);
                    else return parent;
                } else if (parent!=null && parent.right.data == temp.data) {
                    if(temp.right!=null) return getMinFromRight(temp.right);
                    else if(grandParent!=null) {
                        if(grandParent.left.data == parent.data) {
                            return grandParent;
                        } else if(grandParent.right.data == parent.data) {
                            return null;
                        }
                    }
                    else {
                        return null;
                    }
                }
            } else if(temp.data > key.data) {
                grandParent = parent;
                parent = temp;
                temp = temp.left;
            } else {
                grandParent = parent;
                parent = temp;
                temp = temp.right;
            }

        }
        return null;
    }
    
    public Node getMinFromRight(Node root) {
        return null;
    }

}
