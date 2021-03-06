package zcw.com.lib_leet_code;

import java.util.Stack;

/**
 * Created by 朱城委 on 2019/6/17.<br><br>
 */
public class Topic503_3 {

    public static void main(String[] args) {
        Topic503_3 instance = new Topic503_3();

        int[] array1 = new int[] {2, 1, 5};
        int[] array2 = new int[] {2, 7, 4, 3, 5};
        int[] array3 = new int[] {1, 7, 5, 1, 9, 2, 5, 1};
        int[] array4 = new int[] {9, 7, 6, 7, 6, 9};
        int[] array5 = new int[] {4, 3, 2, 5, 1, 8, 10};
        int[] array6 = new int[] {5, 4, 3, 2, 1};
        int[] array7 = new int[] {1, 2, 3, 4, 3};
        int[] array8 = new int[] {1, 2, 1};

        Util.printArray(instance.nextGreaterElements(array1));
        Util.printArray(instance.nextGreaterElements(array2));
        Util.printArray(instance.nextGreaterElements(array3));
        Util.printArray(instance.nextGreaterElements(array4));
        Util.printArray(instance.nextGreaterElements(array5));
        Util.printArray(instance.nextGreaterElements(array6));
        Util.printArray(instance.nextGreaterElements(array7));
        Util.printArray(instance.nextGreaterElements(array8));
    }

    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            result[i] = -1;

            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }

            stack.push(i);
        }

        int index = 0;
        while (!stack.empty() && index <= nums.length - stack.size()) {
            if(nums[stack.peek()] < nums[index]) {
                result[stack.pop()] = nums[index];
            }
            else {
                index++;
            }
        }

        return result;
    }
}
