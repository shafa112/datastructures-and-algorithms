package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer {
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        public Node(int _val) {
            val = _val;
        }
    }

    /*
        Approach 1
    */
    //time: O(n), space: O(n)
    public Node connect2(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node dummy = new Node(0);
            int size = q.size();
            while(size-->0) {
                Node node = q.remove();
                dummy.next = node;
                dummy = dummy.next;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        return root;
    }

    /*
        Approach 2
    */
    //time: O(n), space: O(1)
    public Node connect3(Node root) {
        if(root == null) return null;
        Node head = root;
        while(head!=null) {
            Node dummy = new Node(0);
            Node temp = dummy;
            while(head!=null) {
                if(head.left!=null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right!=null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }


    /*
        Approach 3
    */
    public Node connect(Node root) {
        Node prevRowStartNode = null;
        Node currentRowFirstNode = root;
        while (currentRowFirstNode != null) {
            connectCurrentRow(prevRowStartNode, currentRowFirstNode);
            prevRowStartNode = currentRowFirstNode;
            currentRowFirstNode = getNextRowStart(currentRowFirstNode);
        }
        return root;
    }

    private void connectCurrentRow(Node prevRowStartNode, Node current) {
        while(prevRowStartNode!=null) {
            if(prevRowStartNode.left!=null && prevRowStartNode.left!=current) {
                current.next = prevRowStartNode.left;
                current=current.next;
            }
            if(prevRowStartNode.right!=null && prevRowStartNode.right!=current) {
                current.next = prevRowStartNode.right;
                current = current.next;
            }
            prevRowStartNode = prevRowStartNode.next;
        }
    }

    private Node getNextRowStart(Node current) {
        Node temp = current;
        while (temp != null) {
            if (temp.left == null && temp.right == null) temp = temp.next;
            else return temp.left != null ? temp.left : temp.right;
        }
        return null;
    }
}
