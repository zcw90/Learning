package zcw.com.lib_leet_code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * Created by 朱城委 on 2021/6/29.<br><br>
 */
public class Topic39_2 {

    private static int counter = 0;

    public static void main(String[] args) {
        Topic39_2 topic39 = new Topic39_2();

        int[] nums = {1, 2, 7, 17, 15, 3};
        int target = 10;
        System.out.println(topic39.combinationSum(nums, target));

        nums = new int[] {10, 1, 2, 7, 6, 1, 5};
        target = 8;
        System.out.println(topic39.combinationSum(nums, target));

        System.out.println(counter);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        sum(candidates, 0, target, new ArrayDeque(), result);
        return result;
    }

    private void sum(int[] candidates, int startIndex, int target, Deque<Integer> stack, List<List<Integer>> result) {
        counter++;
        if(startIndex >= candidates.length) {
            return ;
        }

        if(target < 0) {
            return ;
        }

        if(target == 0) {
            List<Integer> subResult = new ArrayList<>(stack);
            result.add(subResult);
            return ;
        }

        if(candidates[startIndex] <= target) {
            stack.push(candidates[startIndex]);
            sum(candidates, startIndex, target - candidates[startIndex], stack, result);
            stack.pop();
        }

        sum(candidates, startIndex + 1, target, stack, result);
    }
}
