package zcw.com.lib_leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 朱城委 on 2019/5/6.<br><br>
 */
public class Topic113 {

    public static void main(String[] args) {
        TreeNode root = createTree();
        List<List<Integer>> list = pathSum(root, 22);

        System.out.println(list);
        System.out.println(pathSum(null, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> listResult = new ArrayList<>();

        if(root == null) {
            return listResult;
        }

        List<Integer> list = new ArrayList<>();
        int currentSum = 0;

        pathSum(root, currentSum, sum, listResult, list);
        return listResult;
    }

    private static void pathSum(TreeNode node, int currentSum, int sum, List<List<Integer>> listResult, List<Integer> list) {
        if(node == null) {
            return ;
        }

        if(listResult == null || list == null) {
            return ;
        }

        list.add(node.val);
        List<Integer> list1 = list;
        List<Integer> list2 = list;

        // 如果是叶子节点，则判断路径节点之和是否等于sum
        if(node.left == null && node.right == null) {
            if(currentSum + node.val == sum) {
                listResult.add(list);
            }
        }

        // 如果左右节点都不为null，则需要新建list
        if(node.left != null && node.right != null) {
            list1 = new ArrayList<>(list);
            list2 = new ArrayList<>(list);
        }

        pathSum(node.left, currentSum + node.val, sum, listResult, list1);
        pathSum(node.right, currentSum + node.val, sum, listResult, list2);
    }

    /**
     * 创建测试二叉树
     * @return
     */
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(5);

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        return root;
    }
}
