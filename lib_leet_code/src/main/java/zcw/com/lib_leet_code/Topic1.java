package zcw.com.lib_leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 朱城委 on 2019/4/26.<br><br>
 */
public class Topic1 {
    private static int[] array = {2, 7, 11, 15};
    private static int target = 9;

    public static void main(String[] args) {
        int[] result = twoSum(array, target);
        for(int value : result) {
            System.out.print(value + "\t");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Argument is error.");
        }

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for(int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            Integer index = map.get(value);
            if(index != null) {
                result[0] = index;
                result[1] = i;
                break;
            }

            map.put(nums[i], i);
        }

        return result;
    }
}
