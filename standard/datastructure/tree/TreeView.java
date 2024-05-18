package datastructure.tree;

import javax.swing.*;
import java.util.*;

public class TreeView {

    static class HorizontalDistance {
        Node node;
        int hd;

        public HorizontalDistance(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    //print right view: with level order recursive, print last elements of list on each level
    //print left view implemented below
    public static List<Integer> printLeftView(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        if(root == null) return l;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            l.add(q.peek().data);
            System.out.println(q.peek().data);
            for(int i =0;i<size;++i) {
                Node node = q.remove();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        return l;
    }

    public static List<Integer> rightView(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        if(root == null) return l;
        q.add(root);
        int size = 0;
        while(!q.isEmpty()) {
            size = q.size();
            System.out.println(q.peek().data);
            l.add(q.peek().data);
            for (int i = 0; i < size; ++i) {
                Node node = q.remove();
                if (node.right != null) q.add(node.right);
                if (node.left != null) q.add(node.left);
            }
        }
        return l;
    }

    public static List<Integer> bottomView(Node root) {
        List<Integer> l = new ArrayList<>();
        if(root==null) return l;
        Map<Integer,Integer> m = new TreeMap<>(); // to put hori dist in sorted order
        Queue<HorizontalDistance> q = new LinkedList<>();
        q.add(new HorizontalDistance(root,0));
        while(!q.isEmpty()) {
            HorizontalDistance h = q.remove();
            Node node = h.node;
            int hd = h.hd;
            if(m.containsKey(hd)) {
                m.replace(hd,m.get(hd),node.data);
            } else m.put(hd,node.data);
            if(node.left!=null) q.add(new HorizontalDistance(node.left,hd-1));
            if(node.right!=null) q.add(new HorizontalDistance(node.right,hd+1));
        }

        for(Map.Entry<Integer,Integer> e : m.entrySet()){
            System.out.print(e.getValue()+" ");
            l.add(e.getValue());
        }
        return l;
    }

    public static void topView(Node root) {
        if(root==null) return;
        Map<Integer,Integer> m = new TreeMap<>(); // to put horizontal dist in sorted order
        Queue<HorizontalDistance> q = new LinkedList<>();
        q.add(new HorizontalDistance(root,0));
        while(!q.isEmpty()) {
            HorizontalDistance h = q.remove();
            Node node = h.node;
            int hd = h.hd;
            if(m.containsKey(hd)) m.put(hd,node.data);
            if(node.left!=null) q.add(new HorizontalDistance(node.left,hd-1));
            if(node.right!=null) q.add(new HorizontalDistance(node.right,hd+1));
        }
        for(Map.Entry<Integer,Integer> e : m.entrySet()){
            System.out.print(e.getValue()+" ");
        }

    }


    public void topView2(Node root) {

        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {

                --size;
            }
        }

    }

    public static List<List<Integer>> verticalView(Node root) {
        if (root == null) return null;
        List<List<Integer>> l = new ArrayList<>();
        Map<Integer, List<Integer>> mainMap = new TreeMap<>();
        Queue<HorizontalDistance> q = new LinkedList<>();
        q.add(new HorizontalDistance(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();
            while (size-- > 0) {
                HorizontalDistance horizontalDistance = q.remove();
                Node node = horizontalDistance.node;
                int hd = horizontalDistance.hd;
                if (!levelMap.containsKey(hd)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(node.data);
                    levelMap.put(hd, list);
                } else {
                    List<Integer> list = levelMap.get(hd);
                    list.add(node.data);
                }
                if (node.left != null) q.add(new HorizontalDistance(node.left, hd - 1));
                if (node.right != null) q.add(new HorizontalDistance(node.right, hd + 1));
            }
            mergeMainAndLevelMap(mainMap, levelMap);
        }

        for (Map.Entry<Integer, List<Integer>> entry : mainMap.entrySet()) {
            l.add(entry.getValue());
        }
        return l;
    }

    private static void mergeMainAndLevelMap(Map<Integer, List<Integer>> mainMap,
                                             Map<Integer, List<Integer>> levelMap) {
        for (Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()) {
            entry.getValue().sort(null);
            if (!mainMap.containsKey(entry.getKey())) {
                List<Integer> list = new ArrayList<>();
                list.addAll(entry.getValue());
                mainMap.put(entry.getKey(), list);
            } else {
                List<Integer> mainList = mainMap.get(entry.getKey());
                mainList.addAll(entry.getValue());
            }
        }
    }

    public static List<Integer> boundaryOfBinaryTree(Node root) {
        List<Integer> finalList = new ArrayList<>();
        finalList.addAll(printLeftView(root));
        finalList.addAll(bottomView(root));
        finalList.addAll(rightView(root));
        Set<Integer> s = new HashSet<>(finalList);
        System.out.println(s.toArray());
        return finalList;
    }



    public static void topView1(Node root) {
        if(root==null) return;
        Deque<HorizontalDistance> dq = new ArrayDeque<>();
        dq.add(new HorizontalDistance(root,0));
        Map<Integer,Integer> map = new TreeMap<>();
        while(!dq.isEmpty()) {
            HorizontalDistance hd = dq.remove();
            Node node = hd.node;
            int dist = hd.hd;
            if(!map.containsKey(hd)) map.put(dist, node.data);
            if (node.left != null) dq.add(new HorizontalDistance(node.left, dist-1));
            if (node.right != null) dq.add(new HorizontalDistance(node.right, dist-1));
        }

        for(Map.Entry<Integer,Integer> m : map.entrySet()) {
            System.out.print(m.getKey()+" "+m.getValue());
        }
    }

    public static void boundaryOfBinaryTree2(Node root) {
        List<Integer> l = new ArrayList<>();
        if(root==null) return;
        if(root.left==null && root.right==null) {
            l.add(root.data);
            return;
        }
        l.add(root.data);
        if(root.left!=null)leftBoundary(root.left,l);
        leafNodes(root,l);
        if(root.right!=null)rightBoundary(root.right,l);
        System.out.println("Boundary: "+l);
    }

    private static void rightBoundary(Node root, List<Integer> l) {
        if(root==null || (root.left==null && root.right==null)) return;
        if(root.right!=null){
            rightBoundary(root.right,l);
            l.add(root.data);
        }
        else {
            if (root.left != null) {
                rightBoundary(root.left,l);
                l.add(root.data);
            }
        }
    }

    private static void leafNodes(Node root, List<Integer> list) {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            list.add(root.data);
        };
        leafNodes(root.left,list);
        leafNodes(root.right,list);
    }

    private static void leftBoundary(Node root, List<Integer> list) {
        if(root!=null && (root.left!=null || root.right!=null)) list.add(root.data);
        if(root.left!=null) leftBoundary(root.left,list);
        else {
            if(root.right!=null) leftBoundary(root.right,list);
        }
    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.root = new Node(1);
        b.root.left = new Node(2);
        b.root.left.left = new Node(4);
        b.root.left.right = new Node(6);

        b.root.right = new Node(3);
        b.root.right.left = new Node(6);
        b.root.right.left.left = new Node(9);
        b.root.right.left.right = new Node(10);
        BinaryTreePrinter.printNode(b.root);
        System.out.println("hey");
        boundaryOfBinaryTree2(b.root);
        //rightView(b.root);
        //System.out.println("Boundary ------ "+boundaryOfBinaryTree(b.root));
    }


}
