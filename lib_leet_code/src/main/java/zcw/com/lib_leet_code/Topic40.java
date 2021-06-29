package zcw.com.lib_leet_code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 朱城委 on 2021/6/29.<br><br>
 */
public class Topic40 {

    public static void main(String[] args) {
        Topic40 topic40 = new Topic40();

        int[] nums = {1, 2, 7, 17, 15, 3};
        int target = 10;
        System.out.println(topic40.combinationSum2(nums, target));

        nums = new int[] {10, 1, 2, 7, 6, 1, 5};
        target = 8;
        System.out.println(topic40.combinationSum2(nums, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        sum(candidates, 0, target, new ArrayDeque(), result);
        return result;
    }

    private void sum(int[] candidates, int startIndex, int target, Deque<Integer> stack, List<List<Integer>> result) {
        if(target < 0) {
            return ;
        }

        if(target == 0) {
            if(stack.size() > 0) {
                List<Integer> subResult = new ArrayList<>(stack);
                result.add(subResult);
            }
            return ;
        }

        for(int i = startIndex; i < candidates.length; i++) {
            if(i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            stack.push(candidates[i]);
            sum(candidates, i + 1, target - candidates[i], stack, result);
            stack.pop();
        }
    }

    /**
     * 数组去重
     *
     * @param nums 要去重的数组
     * @return 返回去重后的数组
     */
    private int[] deDuplication(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[] {};
        }

        // 利用HashMap去重
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int index = 0;
        int[] result = new int[map.size()];
        for(int value : map.keySet()) {
            result[index] = value;
            index++;
        }

        return result;
    }

    /**
     * 判断某个数是否存在于数组中
     *
     * @param nums 数组
     * @param value 查找的数
     * @return 存在返回true；否在返回false。
     */
    private boolean contain(int[] nums, int value) {
        for(int val : nums) {
            if(val == value) {
                return true;
            }
        }

        return false;
    }
}
