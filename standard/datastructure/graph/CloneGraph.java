package datastructure.graph;

import java.util.*;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        Map<Node, Node> cloneNodeMap = new HashMap<>();
        return dfs(node, cloneNodeMap);
    }

    private static Node dfs(Node node, Map<Node, Node> cloneNodeMap) {
        if(node==null) return null;
        if (cloneNodeMap.containsKey(node)) return cloneNodeMap.get(node);
        Node newNode = new Node();
        newNode.val = node.val;
        //newNode.neighbors = new ArrayList<>(); //newNode.neighbors already got initialized in constructor of Node class
        cloneNodeMap.put(node, newNode);
        for (Node child : node.neighbors) newNode.neighbors.add(dfs(child, cloneNodeMap));
        return newNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
