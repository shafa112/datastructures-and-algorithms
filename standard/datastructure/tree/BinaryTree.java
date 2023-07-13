package datastructure.tree;

import java.util.*;

public class BinaryTree {

    public Node root;

    public void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderIterative(Node root) {
        Stack<Node> s = new Stack<>();
        if(root!=null) s.push(root);
        while(!s.isEmpty()) {
            Node node = s.pop();
            System.out.print(node.data+" ");
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left);
        }
    }

    public void postOrder(Node root) {
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public void postOrderIterative(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        if(root==null) return;
        s1.push(root);
        if(root.left!=null)s2.push(root.left);
        if(root.right!=null)s2.push(root.right);
        while (!s2.isEmpty()){
            Node node = s2.pop();
            s1.push(node);
            if(node.left!=null)s2.push(node.left);
            if(node.right!=null)s2.push(node.right);
        }
        while(!s1.isEmpty()) {
            System.out.print(s1.pop().data+" ");
        }
    }

    public void inOrder(Node root) {
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void inOrderIterative(Node root) {
        Stack<Node> s = new Stack<>();
        Node node = root;
        while(node!=null || !s.isEmpty()) {
            while (node!=null) {
                s.push(node);
                node=node.left;
            }
            node = s.pop();
            System.out.print(node.data+" ");
            node = node.right;
        }
    }

    public void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return;
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            System.out.print(node.data+" ");
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
    }

    public void levelOrderNewLine(Node root) {

        Queue<Node> q = new LinkedList<>();
        if(root == null) return;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i =0;i<size;++i) {
                Node node = q.remove();
                System.out.print(node.data+" ");
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            System.out.println();
        }

    }

    public void levelOrderRecursive(Node root, ArrayList<Node> aList[], int level) {
        if(root==null) return;
        if(aList[level]==null){
            aList[level] = new ArrayList<>();
        }
        aList[level].add(root);
        levelOrderRecursive(root.left,aList,level+1);
        levelOrderRecursive(root.right,aList,level+1);
    }

    public void printList(ArrayList<Node> aList[]) {
        for (int i = 0; i < aList.length; i++) {
            for (int j = 0; j < aList[i].size(); j++) {
                System.out.print(aList[i].get(j).data+" ");
            }
            System.out.println();
        }
    }

    public boolean search(Node root, int val) {
        if(root == null) return false;
        if(root.data == val) return true;
        return search(root.left,val) || search(root.right,val);

    }

    public int getHeight(Node root) {
        if(root==null) return -1;
        if(root.left==null && root.right==null) return 0;
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }

    //print right view: with level order recursive, print last elements of list on each level
    //print left view implemented below
    public void printLeftView(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            System.out.println(q.peek().data);
            for(int i =0;i<size;++i) {
                Node node = q.remove();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
    }

    public boolean isSameTree(Node root1, Node root2) {
        if(root1==null && root2==null) return true;
        if(root1!=null && root2==null) return false;
        if(root1==null && root2!=null) return false;
        return root1.data!=root2.data&& isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
    }

    public static boolean printAncestors(Node root, int key) {
        if(root==null) return false;
        if(root.data == key) return true;
        if(printAncestors(root.left,key) || printAncestors(root.right,key)) {
            System.out.println(root.data);
            return true;
        }
        return false;
    }

    public Node insertIntoBST(Node root, int key) {
        if(root==null) return new Node(key);
        Node prev = root;
        Node next = root;
        while(next!=null) {
            while(next!=null && key<next.data) {
                prev = next;
                next = next.left;
            }
            while(next!=null && key>next.data) {
                prev = next;
                next = next.right;
            }
        }
        Node n = new Node(key);
        if(next==null) {
            if(prev!=null && key<prev.data) prev.left = n;
            if(prev!=null && key>prev.data) prev.right = n;
        }
        if(next!=null && key<next.data) next.left = n;
        if(next!=null && key>next.data) next.right = n;

        return root;

    }

    public Node insertIntoBSTRecursive(Node root, int data) {
        if(root == null) return new Node(data);
        if(data<root.data) root.left = insertIntoBSTRecursive(root.left,data);
        if(data>root.data) root.right = insertIntoBSTRecursive(root.right,data);
        return root;
    }

    public boolean isBst(Node root, long min, long max) {
        if(root==null) return true;
        if(root.data<=min || root.data>=max) return false;
        return isBst(root.left,min,root.data) && isBst(root.right,root.data,max);
    }

    public int diameter(Node root) {
        int[] dia = new int[1];
        util(root,dia);
        return dia[0];
    }

    public int util(Node root, int[] dia) {
        if(root == null) return 0;
        int lh = util(root.left,dia);
        int rh = util(root.right,dia);
        if(lh+rh>dia[0]) dia[0] = lh+rh;
        return 1+Math.max(lh,rh);
    }

    //binary tree to dll inorder
    Node bToDLL(Node root)
    {
        Stack<Node> s = new Stack<>();
        Node head = null;
        Node temp = null;
        Node node = root;
        while(node!=null || !s.isEmpty()) {
            while (node!=null) {
                s.push(node);
                node=node.left;
            }
            node = s.pop();
            if(head==null) {
                head = new Node(node.data);
                temp = head;
            }
            else {
                Node tNode = new Node(node.data);
                tNode.left = temp;
                temp.right = tNode;
                temp = temp.right;
            }
            node = node.right;
        }
        return head;
    }

    //binary tree to single ll preorder
    public void flatten(Node root) {
        Node head = null;
        Node temp = null;
        Stack<Node> s = new Stack<>();
        if(root != null) s.push(root);
        while(!s.isEmpty()) {
            Node node = s.pop();
            //System.out.print(node.data+" ");

            if(head==null) {
                head = node;
                temp = head;
            }
            else {
                Node tNode = node;
                //tNode.left = temp;
                temp.right = tNode;
                temp = temp.right;
            }

            if(node.right!=null) {
                s.push(node.right);
                node.right = null;
            }
            if(node.left!=null) {
                s.push(node.left);}
            node.left = null;
        }
        root = head;
    }


    //---------------------------------------------------------
    Node lca2(Node root, int n1,int n2)
    {
        // Your code here
        ArrayList<Node> l1 = new ArrayList<>();
        ArrayList<Node> l2 = new ArrayList<>();

        printAncestors2(root,n1,l1);
        printAncestors2(root,n2,l2);

        return find(l1,l2);


    }

    public Node find(ArrayList<Node> l1,ArrayList<Node> l2) {
        int size1 = l1.size();
        int size2 = l2.size();

        for(int i =0; i<size1;++i)
        {
            for(int j=0; j<size2;++j) {
                if(l1.get(i).data==l2.get(j).data) return l2.get(j);
            }
        }
        return null;
    }

    public boolean printAncestors2(Node root, int key, ArrayList<Node> l) {
        if(root==null) return false;
        if(root.data == key) return true;
        if(printAncestors2(root.left,key,l) || printAncestors2(root.right,key,l)) {
            l.add(root);
            return true;
        }
        return false;
    }

    //better soln than lca2
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null) return null;
        if(root==p || root ==q) return root;
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right = lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }

    public void printKDistant(Node root, int k, int d) {
        if(root == null) return;
        if(k == d) System.out.println(root.data);
        printKDistant(root.left,k,d+1);
        printKDistant(root.right,k,d+1);
    }

    //test
    public int getTargetLevel(Node root, Node target, int level) {
        if(root == null) return 0;
        if(root == target) return level;
        return Math.max(getTargetLevel(root.left,target,level+1),getTargetLevel(root.right,target,level+1));

    }


}
