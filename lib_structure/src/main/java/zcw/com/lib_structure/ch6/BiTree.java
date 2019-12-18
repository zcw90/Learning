package zcw.com.lib_structure.ch6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import zcw.com.lib_structure.BiTNode;

/**
 * Created by 朱城委 on 2019/6/28.<br><br>
 * 二叉树
 */
public class BiTree {
    private static int index;

    /**
     * 按前序遍历创建二叉树，比如:"AB#D##C##"。
     * @param data 如果节点的孩子为null，则用'#'代替。
     * @return 返回根节点
     */
    public static BiTNode preCreateBiTree(String data) {
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
    private static BiTNode preCreateBitTree(String data) {
        if(data == null || data.length() == 0 || index < 0 || index >= data.length()) {
            return null;
        }

        if(data.charAt(index) == '#') {
            index++;
            return null;
        }

        BiTNode node = new BiTNode();
        node.data = data.charAt(index++);

        node.left = preCreateBitTree(data);
        node.right = preCreateBitTree(data);

        return node;
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preTraverse(BiTNode root) {
        if(root == null) {
            return ;
        }

        visitNode(root);
        preTraverse(root.left);
        preTraverse(root.right);
    }

    /**
     * 前序遍历（非递归）
     * @param root
     */
    public static void preTraverseNoRecurse(BiTNode root) {
        if(root == null) {
            return ;
        }

        Stack<BiTNode> stack = new Stack<>();
        stack.push(root);
        BiTNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            visitNode(node);

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inTraverse(BiTNode root) {
        if(root == null) {
            return ;
        }

        inTraverse(root.left);
        visitNode(root);
        inTraverse(root.right);
    }

    /**
     * 中序序遍历（非递归）
     * @param root
     */
    public static void inTraverseNoRecurse(BiTNode root) {
        if(root == null) {
            return ;
        }

        Stack<BiTNode> stack = new Stack<>();
        BiTNode node = root;
        while (!stack.isEmpty() || node != null) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                visitNode(node);
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postTraverse(BiTNode root) {
        if(root == null) {
            return ;
        }

        postTraverse(root.left);
        postTraverse(root.right);
        visitNode(root);
    }

    /**
     * 后序序序遍历（非递归）
     * @param root
     */
    public static void postTraverseNoRecurse(BiTNode root) {
        if(root == null) {
            return ;
        }

        Stack<BiTNode> stack1 = new Stack<>();
        Stack<BiTNode> stack2 = new Stack<>();
        stack1.push(root);
        BiTNode node;
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);

            if(node.left != null) {
                stack1.push(node.left);
            }

            if(node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            visitNode(stack2.pop());
        }
    }

    /**
     * 层次遍历
     * @param root 根节点
     */
    public static void levelTraverse(BiTNode root) {
        if(root == null) {
            return ;
        }

        Queue<BiTNode> queue = new LinkedList<>();
        queue.offer(root);

        levelTraverse(queue, root);
    }

    /**
     * 层次遍历
     * @param queue 队列
     * @param root 根节点
     */
    private static void levelTraverse(Queue<BiTNode> queue, BiTNode root) {
        if(root == null || queue == null) {
            return ;
        }

        BiTNode node;
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
     * 访问节点
     * @param node
     */
    private static void visitNode(BiTNode node) {
        System.out.print(node.data + "\t");
    }
}
