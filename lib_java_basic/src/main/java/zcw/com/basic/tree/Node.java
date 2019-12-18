package zcw.com.basic.tree;

/**
 * Created by 朱城委 on 2019/4/28.<br><br>
 */
public class Node {
    private Node nodeLeft;
    private Node nodeRight;

    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node getNodeLeft() {
        return nodeLeft;
    }

    public void setNodeLeft(Node nodeLeft) {
        this.nodeLeft = nodeLeft;
    }

    public Node getNodeRight() {
        return nodeRight;
    }

    public void setNodeRight(Node nodeRight) {
        this.nodeRight = nodeRight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
