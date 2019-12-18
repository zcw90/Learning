package zcw.com.basic.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 朱城委 on 2019/4/28.<br><br>
 */
public class Util {

    /**
     * 创建二叉查找树
     * @param array
     * @return
     */
    public static Node createBinarySearchTree(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Argument is null.");
        }

        Node rootNode = new Node(array[0]);
        for(int i = 1; i < array.length; i++) {
            linkBinarySearchNode(rootNode, array[i]);
        }

        return rootNode;
    }

    /**
     * 连接二叉查找树节点
     * @param rootNode
     * @param value
     */
    private static void linkBinarySearchNode(Node rootNode, int value) {
        if(rootNode == null) {
            return ;
        }

        // 比根节点小，放在根节点左边
        if(value < rootNode.getValue()) {
            if(rootNode.getNodeLeft() == null) {
                rootNode.setNodeLeft(new Node(value));
                return ;
            }
            linkBinarySearchNode(rootNode.getNodeLeft(), value);
        }

        // 比根节点大，放在根节点右边
        if(value >= rootNode.getValue()) {
            if(rootNode.getNodeRight() == null) {
                rootNode.setNodeRight(new Node(value));
                return ;
            }
            linkBinarySearchNode(rootNode.getNodeRight(), value);
        }
    }

    /**
     * 计算二叉树的高度
     * @param rootNode 根节点
     * @return
     */
    public static int getBinaryTreeHeight(Node rootNode) {
        if(rootNode == null) {
            return 0;
        }

        int heightLeft = getBinaryTreeHeight(rootNode.getNodeLeft()) + 1;
        int heightRight = getBinaryTreeHeight(rootNode.getNodeRight()) + 1;

        return Math.max(heightLeft, heightRight);
    }

    /**
     * 获取二叉查找树的最大值
     * @param rootNode 根节点
     * @return
     */
    public static int getBinarySearchTreeMaxValue(Node rootNode) {
        if(rootNode == null) {
            return Integer.MIN_VALUE;
        }

        if(rootNode.getNodeRight() == null) {
            return rootNode.getValue();
        }

        return getBinarySearchTreeMaxValue(rootNode.getNodeRight());
    }

    /**
     * 获取二叉树的最大值
     * @param rootNode 根节点
     * @return
     */
    public static int getBinaryTreeMaxValue(Node rootNode) {
        if(rootNode == null) {
            return Integer.MIN_VALUE;
        }

        if(rootNode.getNodeLeft() == null && rootNode.getNodeRight() == null) {
            return rootNode.getValue();
        }

        int valueLeft = getBinaryTreeMaxValue(rootNode.getNodeLeft());
        int valueRight = getBinaryTreeMaxValue(rootNode.getNodeRight());
        int childMaxValue = Math.max(valueLeft, valueRight);
        return Math.max(rootNode.getValue(), childMaxValue);
    }

    /**
     * 先序遍历
     * @param node
     */
    public static void preTraversal(Node node) {
        if(node == null) {
            return ;
        }

        System.out.print(node.getValue() + "\t");
        preTraversal(node.getNodeLeft());
        preTraversal(node.getNodeRight());
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inTraversal(Node node) {
        if(node == null) {
            return ;
        }

        inTraversal(node.getNodeLeft());
        System.out.print(node.getValue() + "\t");
        inTraversal(node.getNodeRight());
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postTraversal(Node node) {
        if(node == null) {
            return ;
        }

        postTraversal(node.getNodeLeft());
        postTraversal(node.getNodeRight());
        System.out.print(node.getValue() + "\t");
    }

    /**
     * 层次遍历
     * @param node 根节点
     */
    public static void levelTraversal(Node node) {
        if(node == null) {
            return ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        levelTraversal(queue);
    }

    /**
     * 利用队列，对二叉树进行层次遍历
     * @param queue 队列
     */
    private static void levelTraversal(Queue<Node> queue) {
        if(queue == null) {
            return ;
        }

        Node temp = queue.poll();
        while (temp != null) {
            System.out.print(temp.getValue() + "\t");

            // 如果有左节点，则放入队列中
            if(temp.getNodeLeft() != null) {
                queue.offer(temp.getNodeLeft());
            }

            // 如果有右节点，则放入队列中
            if(temp.getNodeRight() != null) {
                queue.offer(temp.getNodeRight());
            }

            temp = queue.poll();
        }
    }
}
