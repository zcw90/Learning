package zcw.com.lib_structure.ch6;

import java.util.LinkedList;
import java.util.Queue;

import zcw.com.lib_structure.BiThrNode;

/**
 * Created by 朱城委 on 2019/7/1.<br><br>
 * 线索二叉树
 */
public class BiThrTree {
    private static int index;

    /** 保存线索化过程中，上一次操作的节点 */
    private static BiThrNode preBiThrNode;

    /**
     * 按前序遍历创建二叉树，比如:"AB#D##C##"。
     * @param data 如果节点的孩子为null，则用'#'代替。
     * @return 返回根节点
     */
    public static BiThrNode preCreateBiTree(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }

        index = 0;
        return preCreateBitTree(data);
    }

    /**
     * 按前序遍历创建二叉树
     * @param data
     */
    private static BiThrNode preCreateBitTree(String data) {
        if(data == null || data.length() == 0 || index < 0 || index >= data.length()) {
            return null;
        }

        if(data.charAt(index) == '#') {
            index++;
            return null;
        }

        BiThrNode node = new BiThrNode();
        node.data = data.charAt(index++);

        node.left = preCreateBitTree(data);
        node.right = preCreateBitTree(data);

        return node;
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preTraverse(BiThrNode root) {
        if(root == null) {
            return ;
        }

        System.out.print(root.data + "\t");
        preTraverse(root.left);
        preTraverse(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inTraverse(BiThrNode root) {
        if(root == null) {
            return ;
        }

        inTraverse(root.left);
        System.out.print(root.data + "\t");
        inTraverse(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postTraverse(BiThrNode root) {
        if(root == null) {
            return ;
        }

        postTraverse(root.left);
        postTraverse(root.right);
        System.out.print(root.data + "\t");
    }

    /**
     * 层次遍历
     * @param root 根节点
     */
    public static void levelTraverse(BiThrNode root) {
        if(root == null) {
            return ;
        }

        Queue<BiThrNode> queue = new LinkedList<>();
        queue.offer(root);

        levelTraverse(queue, root);
    }

    /**
     * 层次遍历
     * @param queue 队列
     * @param root 根节点
     */
    private static void levelTraverse(Queue<BiThrNode> queue, BiThrNode root) {
        if(root == null || queue == null) {
            return ;
        }

        BiThrNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.data + "\t");

            if(node.left != null) {
                queue.offer(node.left);
            }

            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 遍历先序二叉线索链表
     * @param head 头节点，有以下特点：<br>
     *     1、左孩子是二叉树的根节点；<br>
     *     2、右孩子是遍历最后一个节点；<br>
     *     3、遍历第一个节点的左孩子为头节点；<br>
     *     4、遍历最后一个节点的右孩子为头节点。
     */
    public static void preTraverseThreading(BiThrNode head) {
        if(head == null) {
            return ;
        }

        BiThrNode node = head.left;
        while (node != head) {
            System.out.print(node.data + "\t");

            while (node.lTag == BiThrNode.PointerTag.Link) {
                node = node.left;
                System.out.print(node.data + "\t");
            }

            node = node.right;
        }
    }

    /**
     * 先序遍历进行线索化
     * @param root 根节点
     * @return 返回头节点，有以下特点：<br>
     *     1、左孩子是二叉树的根节点；<br>
     *     2、右孩子是遍历最后一个节点；<br>
     *     3、遍历第一个节点的左孩子为头节点；<br>
     *     4、遍历最后一个节点的右孩子为头节点。
     */
    public static BiThrNode preThreading(BiThrNode root) {
        if(root == null) {
            return null;
        }

        BiThrNode lastNode = lastNodePre(root);

        preBiThrNode = null;
        preThreadingReal(root);

        // 设置头节点
        BiThrNode head = new BiThrNode();
        head.lTag = BiThrNode.PointerTag.Link;
        head.rTag = BiThrNode.PointerTag.Thread;
        head.left = root;

        // 设置遍历最后一个节点的右孩子为头节点
        lastNode.right = head;

        // 设置头节点的右孩子为遍历的最后一个节点
        head.right = lastNode;
        return head;
    }

    /**
     * 先序遍历进行线索化
     * @param root
     */
    private static void preThreadingReal(BiThrNode root) {
        if(root == null) {
            return ;
        }

        // 如果左孩子为空，设置前驱
        if(root.left == null) {
            root.lTag = BiThrNode.PointerTag.Thread;
            root.left = preBiThrNode;
        }

        // 如果前驱节点的右孩子为空，设置前驱节点的后继
        if(preBiThrNode != null && preBiThrNode.right == null) {
            preBiThrNode.rTag = BiThrNode.PointerTag.Thread;
            preBiThrNode.right = root;
        }

        // 设置当前节点为下一次操作的前驱节点
        preBiThrNode = root;

        if(root.lTag == BiThrNode.PointerTag.Link) {
            preThreadingReal(root.left);
        }
        if(root.rTag == BiThrNode.PointerTag.Link) {
            preThreadingReal(root.right);
        }
    }

    /**
     * 遍历中序二叉线索链表
     * @param head 头节点，有以下特点：<br>
     *     1、左孩子是二叉树的根节点；<br>
     *     2、右孩子是遍历最后一个节点；<br>
     *     3、遍历第一个节点的左孩子为头节点；<br>
     *     4、遍历最后一个节点的右孩子为头节点。
     */
    public static void inTraverseThreading(BiThrNode head) {
        if(head == null) {
            return ;
        }

        BiThrNode node = head.left;
        while (node != head) {
            while (node.lTag == BiThrNode.PointerTag.Link) {
                node = node.left;
            }

            System.out.print(node.data + "\t");
            while (node.rTag == BiThrNode.PointerTag.Thread && node.right != head) {
                node = node.right;
                System.out.print(node.data + "\t");
            }

            node = node.right;
        }
    }

    /**
     * 中序遍历进行线索化
     * @param root 根节点
     * @return 返回头节点，有以下特点：<br>
     *     1、左孩子是二叉树的根节点；<br>
     *     2、右孩子是遍历最后一个节点；<br>
     *     3、遍历第一个节点的左孩子为头节点；<br>
     *     4、遍历最后一个节点的右孩子为头节点。
     */
    public static BiThrNode inThreading(BiThrNode root) {
        if(root == null) {
            return null;
        }

        preBiThrNode = null;
        inThreadingReal(root);

        // 设置头节点
        BiThrNode head = new BiThrNode();
        head.lTag = BiThrNode.PointerTag.Link;
        head.rTag = BiThrNode.PointerTag.Thread;
        head.left = root;

        // 设置遍历第一个节点的左孩子为头节点
        BiThrNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        temp.left = head;

        // 设置遍历最后一个节点的右孩子为头节点
        temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = head;

        // 设置头节点的右孩子为遍历的最后一个节点
        head.right = temp;
        return head;
    }

    /**
     * 中序遍历进行线索化
     * @param root
     */
    private static void inThreadingReal(BiThrNode root) {
        if(root == null) {
            return ;
        }

        inThreadingReal(root.left);

        // 如果左孩子为空，设置前驱
        if(root.left == null) {
            root.lTag = BiThrNode.PointerTag.Thread;
            root.left = preBiThrNode;
        }

        // 如果前驱节点的右孩子为空，设置前驱节点的后继
        if(preBiThrNode != null && preBiThrNode.right == null) {
            preBiThrNode.rTag = BiThrNode.PointerTag.Thread;
            preBiThrNode.right = root;
        }

        // 设置当前节点为下一次操作的前驱节点
        preBiThrNode = root;
        inThreadingReal(root.right);
    }

    /**
     * 遍历后序二叉线索链表
     * @param head 头节点，有以下特点：<br>
     *     1、左孩子是二叉树的根节点；<br>
     *     2、右孩子是遍历最后一个节点；<br>
     *     3、遍历第一个节点的左孩子为头节点；<br>
     *     4、遍历最后一个节点的右孩子为头节点。
     */
    public static void postTraverseThreading(BiThrNode head) {
        if(head == null) {
            return ;
        }

        BiThrNode node = head.left;
        do {
            System.out.print(node.data + "\t");


        }
        while (node != head.right);
        while (node != head) {
            System.out.print(node.data + "\t");

            while (node.lTag == BiThrNode.PointerTag.Link) {
                node = node.left;
                System.out.print(node.data + "\t");
            }

            node = node.right;
        }
    }

    /**
     * 后序遍历进行线索化
     * @param root 根节点
     * @return 返回头节点，有以下特点：<br>
     *     1、左孩子是二叉树的根节点；<br>
     *     2、右孩子是遍历最后一个节点；<br>
     *     3、遍历第一个节点的左孩子为头节点；<br>
     *     4、遍历最后一个节点的右孩子为头节点。
     */
    public static BiThrNode postThreading(BiThrNode root) {
        if(root == null) {
            return null;
        }

        BiThrNode firstNode = firstNodePost(root);

        preBiThrNode = null;
        postThreadingReal(root);

        // 设置头节点
        BiThrNode head = new BiThrNode();
        head.lTag = BiThrNode.PointerTag.Thread;
        head.rTag = BiThrNode.PointerTag.Link;

        // 设置头节点的左孩子为遍历的第一个节点
        head.left = firstNode;
        firstNode.left = head;

        // 设置头节点的右孩子为遍历的最后一个节点
        head.right = root;
        return head;
    }

    /**
     * 后序遍历进行线索化
     * @param root
     */
    private static void postThreadingReal(BiThrNode root) {
        if(root == null) {
            return ;
        }

        postThreadingReal(root.left);
        postThreadingReal(root.right);

        // 如果左孩子为空，设置前驱
        if(root.left == null) {
            root.lTag = BiThrNode.PointerTag.Thread;
            root.left = preBiThrNode;
        }

        // 如果前驱节点的右孩子为空，设置前驱节点的后继
        if(preBiThrNode != null && preBiThrNode.right == null) {
            preBiThrNode.rTag = BiThrNode.PointerTag.Thread;
            preBiThrNode.right = root;
        }

        // 设置当前节点为下一次操作的前驱节点
        preBiThrNode = root;
    }

    /**
     * 获取先序遍历最后一个节点
     * @param root 根节点
     * @return 返回先序遍历最后一个节点
     */
    private static BiThrNode lastNodePre(BiThrNode root) {
        if(root.right != null) {
            return lastNodePre(root.right);
        }
        else if(root.left != null) {
            return lastNodePre(root.left);
        }
        else {
            return root;
        }
    }

    /**
     * 获取后序遍历第一个节点
     * @param root 根节点
     * @return 返回后序遍历第一个节点
     */
    private static BiThrNode firstNodePost(BiThrNode root) {
        if(root.left != null) {
            return firstNodePost(root.left);
        }
        else if(root.right != null) {
            return firstNodePost(root.right);
        }
        else {
            return root;
        }
    }
}
