package zcw.com.lib_structure.ch6;

import java.util.LinkedList;
import java.util.Queue;

import static zcw.com.lib_structure.BiThrWithParentNode.PointerTag.*;

import zcw.com.lib_structure.BiThrWithParentNode;

/**
 * Created by 朱城委 on 2019/7/1.<br><br>
 * 带双亲线索二叉树
 */
public class BiThrWithParentTree {
    private static int index;

    /** 保存线索化过程中，上一次操作的节点 */
    private static BiThrWithParentNode preBiThrNode;

    /**
     * 按前序遍历创建二叉树，比如:"AB#D##C##"。
     * @param data 如果节点的孩子为null，则用'#'代替。
     * @return 返回根节点
     */
    public static BiThrWithParentNode preCreateBiTree(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }

        index = 0;
        return preCreateBitTree(data, null);
    }

    /**
     * 按前序遍历创建二叉树
     * @param data
     */
    private static BiThrWithParentNode preCreateBitTree(String data, BiThrWithParentNode parent) {
        if(data == null || data.length() == 0 || index < 0 || index >= data.length()) {
            return null;
        }

        if(data.charAt(index) == '#') {
            index++;
            return null;
        }

        BiThrWithParentNode node = new BiThrWithParentNode();
        node.data = data.charAt(index++);
        node.parent = parent;

        node.left = preCreateBitTree(data, node);
        node.right = preCreateBitTree(data, node);

        return node;
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preTraverse(BiThrWithParentNode root) {
        if(root == null) {
            return ;
        }

        visitNode(root);
        preTraverse(root.left);
        preTraverse(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inTraverse(BiThrWithParentNode root) {
        if(root == null) {
            return ;
        }

        inTraverse(root.left);
        visitNode(root);
        inTraverse(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postTraverse(BiThrWithParentNode root) {
        if(root == null) {
            return ;
        }

        postTraverse(root.left);
        postTraverse(root.right);
        visitNode(root);
    }

    /**
     * 层次遍历
     * @param root 根节点
     */
    public static void levelTraverse(BiThrWithParentNode root) {
        if(root == null) {
            return ;
        }

        Queue<BiThrWithParentNode> queue = new LinkedList<>();
        queue.offer(root);

        levelTraverse(queue, root);
    }

    /**
     * 层次遍历
     * @param queue 队列
     * @param root 根节点
     */
    private static void levelTraverse(Queue<BiThrWithParentNode> queue, BiThrWithParentNode root) {
        if(root == null || queue == null) {
            return ;
        }

        BiThrWithParentNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            visitNode(node);

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
    public static void preTraverseThreading(BiThrWithParentNode head) {
        if(head == null) {
            return ;
        }

        BiThrWithParentNode node = head.left;
        while (node != head) {
            visitNode(node);

            while (node.lTag == Link) {
                node = node.left;
                visitNode(node);
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
    public static BiThrWithParentNode preThreading(BiThrWithParentNode root) {
        if(root == null) {
            return null;
        }

        BiThrWithParentNode lastNode = lastNodePre(root);

        preBiThrNode = null;
        preThreadingReal(root);

        // 设置头节点
        BiThrWithParentNode head = new BiThrWithParentNode();
        head.lTag = Link;
        head.rTag = Thread;
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
    private static void preThreadingReal(BiThrWithParentNode root) {
        if(root == null) {
            return ;
        }

        // 如果左孩子为空，设置前驱
        if(root.left == null) {
            root.lTag = Thread;
            root.left = preBiThrNode;
        }

        // 如果前驱节点的右孩子为空，设置前驱节点的后继
        if(preBiThrNode != null && preBiThrNode.right == null) {
            preBiThrNode.rTag = Thread;
            preBiThrNode.right = root;
        }

        // 设置当前节点为下一次操作的前驱节点
        preBiThrNode = root;

        if(root.lTag == Link) {
            preThreadingReal(root.left);
        }
        if(root.rTag == Link) {
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
    public static void inTraverseThreading(BiThrWithParentNode head) {
        if(head == null) {
            return ;
        }

        BiThrWithParentNode node = head.left;
        while (node != head) {
            while (node.lTag == Link) {
                node = node.left;
            }

            visitNode(node);
            while (node.rTag == Thread && node.right != head) {
                node = node.right;
                visitNode(node);
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
    public static BiThrWithParentNode inThreading(BiThrWithParentNode root) {
        if(root == null) {
            return null;
        }

        preBiThrNode = null;
        inThreadingReal(root);

        // 设置头节点
        BiThrWithParentNode head = new BiThrWithParentNode();
        head.lTag = Link;
        head.rTag = Thread;
        head.left = root;

        // 设置遍历第一个节点的左孩子为头节点
        BiThrWithParentNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        temp.left = head;
        temp.lTag = Thread;

        // 设置遍历最后一个节点的右孩子为头节点
        temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = head;
        temp.rTag = Thread;

        // 设置头节点的右孩子为遍历的最后一个节点
        head.right = temp;
        return head;
    }

    /**
     * 中序遍历进行线索化
     * @param root
     */
    private static void inThreadingReal(BiThrWithParentNode root) {
        if(root == null) {
            return ;
        }

        inThreadingReal(root.left);

        // 如果左孩子为空，设置前驱
        if(root.left == null) {
            root.lTag = Thread;
            root.left = preBiThrNode;
        }

        // 如果前驱节点的右孩子为空，设置前驱节点的后继
        if(preBiThrNode != null && preBiThrNode.right == null) {
            preBiThrNode.rTag = Thread;
            preBiThrNode.right = root;
        }

        // 设置当前节点为下一次操作的前驱节点
        preBiThrNode = root;
        inThreadingReal(root.right);
    }

    /**
     * 遍历后序二叉线索链表
     * @param root 根节点
     */
    public static void postTraverseThreading(BiThrWithParentNode root) {
        if(root == null) {
            return ;
        }

        BiThrWithParentNode node = firstNodePost(root);
        do {
            visitNode(node);

            while (node.right != null && node.rTag == Thread) {
                node = node.right;
                visitNode(node);
            }

            if(node.right != null && node.rTag == Link) {
                if(node == node.parent.right) {
                    node = node.parent;

                    if(node == root) {
                        visitNode(node);
                    }
                }
                else {
                    if(node.parent.right == null) {
                        node = node.parent;
                        visitNode(node);
                    }
                    else {
                        node = firstNodePost(node.parent.right);
                    }
                }
            }
        }while (node != root);
    }

    /**
     * 后序遍历进行线索化
     * @param root 根节点
     * @return 返回根节点
     */
    public static BiThrWithParentNode postThreading(BiThrWithParentNode root) {
        if(root == null) {
            return null;
        }

        preBiThrNode = null;
        postThreadingReal(root);
        return root;
    }

    /**
     * 后序遍历进行线索化
     * @param root
     */
    private static void postThreadingReal(BiThrWithParentNode root) {
        if(root == null) {
            return ;
        }

        postThreadingReal(root.left);
        postThreadingReal(root.right);

        // 如果左孩子为空，设置前驱
        if(root.left == null) {
            root.lTag = Thread;
            root.left = preBiThrNode;
        }

        // 如果前驱节点的右孩子为空，设置前驱节点的后继
        if(preBiThrNode != null && preBiThrNode.right == null) {
            preBiThrNode.rTag = Thread;
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
    private static BiThrWithParentNode lastNodePre(BiThrWithParentNode root) {
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
    private static BiThrWithParentNode firstNodePost(BiThrWithParentNode root) {
        if(root.left != null && root.lTag == Link) {
            return firstNodePost(root.left);
        }
        else if(root.right != null && root.rTag == Link) {
            return firstNodePost(root.right);
        }
        else {
            return root;
        }
    }

    /**
     * 访问节点
     * @param node
     */
    private static void visitNode(BiThrWithParentNode node) {
        if(node != null) {
            if(node.parent != null) {
                System.out.print(node.data + "(" + node.parent.data + ")\t");
            }
            else {
                System.out.print(node.data + "\t");
            }
        }
    }
}
