package datastructure.tree;

public class Node {
    public Node left;
    public int data;
    public Node right;
    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "[" + data + "]";
    }
}
