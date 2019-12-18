package zcw.com.lib_leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱城委 on 2019/7/5.<br><br>
 */
public class Topic94 {

    public static void main(String[] args) {
        Topic94 instance = new Topic94();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root == null || result == null) {
            return ;
        }

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
