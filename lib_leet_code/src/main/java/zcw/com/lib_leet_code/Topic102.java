package zcw.com.lib_leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱城委 on 2019/7/5.<br><br>
 */
public class Topic102 {
    public static void main(String[] args) {
        Topic102 instance = new Topic102();

        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        List<List<Integer>> result = instance.levelOrder(node3);
        System.out.println(result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        return result;
    }

    private void levelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null || level < 0) {
            return ;
        }

        if(level >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        levelOrder(root.left, level + 1, result);
        levelOrder(root.right, level + 1, result);
    }
}
