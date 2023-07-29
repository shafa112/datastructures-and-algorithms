package datastructure.tree;

public class Test {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);

        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.right = new Node(6);

        BinaryTree bt2 = new BinaryTree();
        bt2.root = new Node(1);
        bt2.root.left = new Node(2);
        bt2.root.right = new Node(3);

        bt2.root.left.left = new Node(4);
        bt2.root.left.right = new Node(5);
        bt2.root.right.right = new Node(6);

        //bt.preOrder(bt.root);
        // bt.preOrderIterative(bt.root);
        //bt.postOrder(bt.root);
        System.out.println();
        //bt.inOrder(bt.root);
        //bt.postOrderIterative(bt.root);
        //bt.inOrderIterative(bt.root);
        // bt.levelOrder(bt.root);
        System.out.println();
        Node nroot = bt.copy(bt.root);
        // bt.levelOrderNewLine(nroot);
        System.out.println("--------------------------");
        bt.levelOrderNewLine(bt.root);
        /*int height = bt.getHeight(bt.root);
        System.out.println("Height of tree: "+height);
        ArrayList<Node> aList[] = new ArrayList[height+1];
        bt.levelOrderRecursive(bt.root,aList,0);
        bt.printList(aList);
        System.out.println("found: "+bt.search(bt.root,-1));
        bt.printLeftView(bt.root);
        //bt.printRight(bt.root);
        System.out.println(bt.isBst(bt.root,Long.MIN_VALUE,Long.MAX_VALUE));
        System.out.println();
        System.out.println("**********************************");
        System.out.println(bt.diameter(bt.root));

        System.out.println("***************000000000000000000000*******************");
        bt.printKDistant(bt.root,2,0);
        System.out.println("***************000000000000000000000*******************");

        bt.getTargetLevel(bt.root,bt.root.right,0);
        System.out.println("level of "+bt.root.right.data+" :"+bt.getTargetLevel(bt.root,bt.root.right,0));
        */


        BinaryTree b = new BinaryTree();
        b.root = new Node(1);
        b.root.left = new Node(2);
        b.root.right = new Node(3);
        b.root.right.left = new Node(4);
        b.root.right.right = new Node(6);
        b.root.right.left.right = new Node(5);
        b.root.right.left.right.left = new Node(7);

    }

    private static void testLevelOrderNewLine(BinaryTree b) {
        b.levelOrderNewLine(b.root);
    }

}
