package datastructure.tree;

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

    public static void bottomView(Node root) {
        if(root==null) return;
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
        }
    }

    public void topView(Node root) {
        if(root==null) return;
        Map<Integer,Integer> m = new TreeMap<>(); // to put hori dist in sorted order
        Queue<HorizontalDistance> q = new LinkedList<>();
        q.add(new HorizontalDistance(root,0));
        while(!q.isEmpty()) {
            HorizontalDistance h = q.remove();
            Node node = h.node;
            int hd = h.hd;
            if(!m.containsKey(hd)) m.put(hd,node.data);
            if(node.left!=null) q.add(new HorizontalDistance(node.left,hd-1));
            if(node.right!=null) q.add(new HorizontalDistance(node.right,hd+1));
        }
        for(Map.Entry<Integer,Integer> e : m.entrySet()){
            System.out.print(e.getValue()+" ");
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

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.root = new Node(1);
        b.root.left = new Node(2);
        b.root.left.left = new Node(4);
        b.root.left.right = new Node(6);

        b.root.right = new Node(3);
        b.root.right.left = new Node(5);
        b.root.right.right = new Node(7);
        BinaryTreePrinter.printNode(b.root);
        verticalView(b.root);
    }


}
