package zcw.com.lib_structure.ch6;

import zcw.com.lib_structure.BiTNode;
import zcw.com.lib_structure.BiThrNode;
import zcw.com.lib_structure.BiThrWithParentNode;

/**
 * Created by 朱城委 on 2019/6/28.<br><br>
 */
public class Test {
    private static String data1 = "AB#D##C##";
    private static String data2 = "AB#D##C#dsafsafddasfasd";
    private static String data3 = "ABDH##I##EJ###CF##G##";
    private static String data4 = "ABDH##I##EJ####";
    private static String data5 = "A##";
    private static String data6 = "A#CF##G##";
    private static String data7 = "";

    public static void main(String[] args) {
        createBiTree(data1);
        createBiTree(data2);

        createBiThrTree(data3);

        createBiThrWithParentTree(data3);
        createBiThrWithParentTree(data4);
        createBiThrWithParentTree(data5);
        createBiThrWithParentTree(data6);
        createBiThrWithParentTree(data7);
    }

    /**
     * 测试二叉树
     * @param data
     */
    private static void createBiTree(String data) {
        BiTNode root = BiTree.preCreateBiTree(data);

        System.out.print("先序遍历：" + "\t");
        BiTree.preTraverse(root);
        System.out.println();

        System.out.print("中序遍历：" + "\t");
        BiTree.inTraverse(root);
        System.out.println();

        System.out.print("后序遍历：" + "\t");
        BiTree.postTraverse(root);
        System.out.println();

        System.out.print("层次遍历：" + "\t");
        BiTree.levelTraverse(root);
        System.out.println();
        System.out.println("--------------------");

        System.out.print("先序遍历(非递归)：" + "\t");
        BiTree.preTraverseNoRecurse(root);
        System.out.println();

        System.out.print("中序遍历(非递归)：" + "\t");
        BiTree.inTraverseNoRecurse(root);
        System.out.println();

        System.out.print("后序遍历(非递归)：" + "\t");
        BiTree.postTraverseNoRecurse(root);
        System.out.println();
        System.out.println("====================");
    }

    /**
     * 测试线索二叉树
     * @param data
     */
    private static void createBiThrTree(String data) {
        BiThrNode root = BiThrTree.preCreateBiTree(data);

        System.out.print("先序遍历：" + "\t");
        BiThrTree.preTraverse(root);
        System.out.println();

        System.out.print("中序遍历：" + "\t");
        BiThrTree.inTraverse(root);
        System.out.println();

        System.out.print("后序遍历：" + "\t");
        BiThrTree.postTraverse(root);
        System.out.println();

        System.out.print("层次遍历：" + "\t");
        BiThrTree.levelTraverse(root);
        System.out.println();

        System.out.print("先序遍历线索化：" + "\t");
        BiThrNode head = BiThrTree.preThreading(root);            // 先序遍历线索化
        BiThrTree.preTraverseThreading(head);
        System.out.println();

        System.out.print("中序遍历线索化：" + "\t");
        root = BiThrTree.preCreateBiTree(data);
        head = BiThrTree.inThreading(root);   // 中序遍历线索化
        BiThrTree.inTraverseThreading(head);
        System.out.println();
        System.out.println("====================");
    }

    /**
     * 测试带双亲线索二叉树
     * @param data
     */
    private static void createBiThrWithParentTree(String data) {
        BiThrWithParentNode root = BiThrWithParentTree.preCreateBiTree(data);

        System.out.print("先序遍历（带双亲）：" + "\t");
        BiThrWithParentTree.preTraverse(root);
        System.out.println();

        System.out.print("中序遍历（带双亲）：" + "\t");
        BiThrWithParentTree.inTraverse(root);
        System.out.println();

        System.out.print("后序遍历（带双亲）：" + "\t");
        BiThrWithParentTree.postTraverse(root);
        System.out.println();

        System.out.print("层次遍历（带双亲）：" + "\t");
        BiThrWithParentTree.levelTraverse(root);
        System.out.println();

        System.out.print("先序遍历线索化（带双亲）：" + "\t");
        BiThrWithParentNode head = BiThrWithParentTree.preThreading(root);      // 先序遍历线索化
        BiThrWithParentTree.preTraverseThreading(head);
        System.out.println();

        System.out.print("中序遍历线索化（带双亲）：" + "\t");
        root = BiThrWithParentTree.preCreateBiTree(data);
        head = BiThrWithParentTree.inThreading(root);       // 中序遍历线索化
        BiThrWithParentTree.inTraverseThreading(head);
        System.out.println();

        System.out.print("后序遍历线索化（带双亲）：" + "\t");
        root = BiThrWithParentTree.preCreateBiTree(data);
        head = BiThrWithParentTree.postThreading(root);       // 中序遍历线索化
        BiThrWithParentTree.postTraverseThreading(head);
        System.out.println();
        System.out.println("====================");
    }
}
