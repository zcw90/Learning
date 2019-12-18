package zcw.com.basic.tree;

/**
 * Created by 朱城委 on 2019/4/28.<br><br>
 */
public class Test {
    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(9);
        Node node3 = new Node(20);
        Node node4 = new Node(15);
        Node node5 = new Node(35);

        node1.setNodeLeft(node2);
        node1.setNodeRight(node3);

        node3.setNodeLeft(node4);
        node3.setNodeRight(node5);

        System.out.print("前序遍历：");
        Util.preTraversal(node1);
        System.out.println("-----");

        System.out.print("中序遍历：");
        Util.inTraversal(node1);
        System.out.println("-----");

        System.out.print("后序遍历：");
        Util.postTraversal(node1);
        System.out.println("-----");

        System.out.print("层次遍历：");
        Util.levelTraversal(node1);
        System.out.println("-----");
        System.out.println("BinaryTree height: " + Util.getBinaryTreeHeight(node1));
        System.out.println("BinaryTree max value: " + Util.getBinaryTreeMaxValue(node1));
        System.out.println();

        // 二叉查找树
        int[] array = {3, 2 , 1, 4, 5};
        Node rootNode = Util.createBinarySearchTree(array);

        System.out.print("前序遍历：");
        Util.preTraversal(rootNode);
        System.out.println("-----");

        System.out.print("中序遍历：");
        Util.inTraversal(rootNode);
        System.out.println("-----");

        System.out.print("后序遍历：");
        Util.postTraversal(rootNode);
        System.out.println("-----");

        System.out.print("层次遍历：");
        Util.levelTraversal(rootNode);
        System.out.println("-----");
        System.out.println("BinarySearchTree height: " + Util.getBinaryTreeHeight(rootNode));
        System.out.println("BinarySearchTree max value: " + Util.getBinarySearchTreeMaxValue(rootNode));
    }
}
