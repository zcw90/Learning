package zcw.com.lib_leet_code;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by 朱城委 on 2019/6/17.<br><br>
 */
public class Topic503 {

    public static void main(String[] args) {
        Topic503 instance = new Topic503();

        int[] array1 = new int[] {2, 1, 5};
        int[] array2 = new int[] {2, 7, 4, 3, 5};
        int[] array3 = new int[] {1, 7, 5, 1, 9, 2, 5, 1};
        int[] array4 = new int[] {9, 7, 6, 7, 6, 9};
        int[] array5 = new int[] {4, 3, 2, 5, 1, 8, 10};
        int[] array6 = new int[] {5, 4, 3, 2, 1};

        Util.printArray(instance.nextGreaterElements(array1));
        Util.printArray(instance.nextGreaterElements(array2));
        Util.printArray(instance.nextGreaterElements(array3));
        Util.printArray(instance.nextGreaterElements(array4));
        Util.printArray(instance.nextGreaterElements(array5));
        Util.printArray(instance.nextGreaterElements(array6));
    }

    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < length * 2; i++) {
            while (!stack.empty() && nums[stack.peek()] < nums[i % length]) {
                result[stack.pop()] = nums[i % length];
            }

            stack.push(i % length);
        }

        return result;
    }
}
