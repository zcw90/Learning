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
public class Topic40_2 {

    private static int counter = 0;

    public static void main(String[] args) {
        Topic40_2 topic40 = new Topic40_2();

        int[] nums = {1, 2, 7, 17, 15, 3};
        int target = 10;
        System.out.println(topic40.combinationSum2(nums, target));

        nums = new int[] {10, 1, 2, 7, 6, 1, 5};
        target = 8;
        System.out.println(topic40.combinationSum2(nums, target));

        System.out.println(counter);
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

        for(int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            counter++;

            if(i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            stack.push(candidates[i]);
            sum(candidates, i + 1, target - candidates[i], stack, result);
            stack.pop();
        }
    }
}
