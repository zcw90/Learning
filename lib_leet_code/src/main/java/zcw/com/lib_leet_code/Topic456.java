package zcw.com.lib_leet_code;

import java.util.Stack;

/**
 * Created by 朱城委 on 2019/6/19.<br><br>
 */
public class Topic456 {

    public static void main(String[] args) {
        Topic456 t = new Topic456();

        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {3, 1, 4, 2};
        int[] array3 = {-1, 3, 2, 0};
        int[] array4 = {1, 0, 1, -4, -3};
        int[] array5 = {3, 5, 0, 3, 4};

        System.out.println(t.find132pattern(array1));
        System.out.println(t.find132pattern(array2));
        System.out.println(t.find132pattern(array3));
        System.out.println(t.find132pattern(array4));
        System.out.println(t.find132pattern(array5));

        System.out.println("-----");
        System.out.println(t.find132pattern2(array1));
        System.out.println(t.find132pattern2(array2));
        System.out.println(t.find132pattern2(array3));
        System.out.println(t.find132pattern2(array4));
        System.out.println(t.find132pattern2(array5));

        System.out.println("-----");
        System.out.println(t.find132pattern3(array1));
        System.out.println(t.find132pattern3(array2));
        System.out.println(t.find132pattern3(array3));
        System.out.println(t.find132pattern3(array4));
        System.out.println(t.find132pattern3(array5));

        System.out.println("-----");
        System.out.println(t.find132pattern4(array1));
        System.out.println(t.find132pattern4(array2));
        System.out.println(t.find132pattern4(array3));
        System.out.println(t.find132pattern4(array4));
        System.out.println(t.find132pattern4(array5));

        System.out.println("-----");
        System.out.println(t.find132pattern5(array1));
        System.out.println(t.find132pattern5(array2));
        System.out.println(t.find132pattern5(array3));
        System.out.println(t.find132pattern5(array4));
        System.out.println(t.find132pattern5(array5));

        System.out.println("-----");
        System.out.println(t.find132pattern6(array1));
        System.out.println(t.find132pattern6(array2));
        System.out.println(t.find132pattern6(array3));
        System.out.println(t.find132pattern6(array4));
        System.out.println(t.find132pattern6(array5));

        System.out.println("-----");
        System.out.println(t.find132pattern7(array1));
        System.out.println(t.find132pattern7(array2));
        System.out.println(t.find132pattern7(array3));
        System.out.println(t.find132pattern7(array4));
        System.out.println(t.find132pattern7(array5));
    }

    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    for(int k = j + 1; k < nums.length; k++) {
                        if(nums[k] < nums[j] && nums[k] > nums[i]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean find132pattern2(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        int[] value = new int[] {nums[0], nums[0], nums[0]};
        int[] index = new int[] {0, 0, 0};

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < value[0]) {
                value[0] = nums[i];
                index[0] = i;
            }

            if(nums[i] > value[2]) {
                value[2] = nums[i];
                index[2] = i;
            }

            if(nums[i] > value[0] && nums[i] < value[2]) {
                value[1] = nums[i];
                index[1] = i;
            }
        }

//        for(int i = 0; i < value.length; i++) {
//            System.out.println(value[i] + " - " + index[i]);
//        }
        if(index[1] > index[2] && index[2] > index[0]) {
            return true;
        }

        return false;
    }

    public boolean find132pattern3(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            if(min == nums[i])
                continue;

            for(int j = nums.length - 1; j > i; j--) {
                if(min < nums[j] && nums[j] < nums[i])
                    return true;
            }
        }

        return false;
    }

    public boolean find132pattern4(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i - 1], min[i - 1]);
        }

        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > min[i]) {
                while(!stack.isEmpty() && nums[i] > stack.peek()) {
                    max = stack.pop();
                }

                if(max > min[i]) {
                    return true;
                }
            }
            stack.push(nums[i]);
        }

        return false;
    }

    public boolean find132pattern5(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        int length = nums.length;
        int i = 0;
        int j;
        int k;
        while(i < length) {
            while(i < length - 1 && nums[i + 1] <= nums[i])
                i++;

            j = i + 1;
            while(j < length - 1 && nums[j + 1] >= nums[j])
                j++;

            k = j + 1;
            while (k < length) {
                if(nums[k] > nums[i] && nums[j] > nums[k]) {
                    return true;
                }
                k++;
            }

            i = j + 1;
        }

        return false;
    }

    public boolean find132pattern6(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < third) {
                return true;
            }

            while(!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }

    public boolean find132pattern7(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        int length = nums.length;
        int top = length;
        int third = Integer.MIN_VALUE;
        for(int i = length - 1; i >= 0; i--) {
            if(nums[i] < third) {
                return true;
            }

            while(top < length && nums[i] > nums[top]) {
                third = nums[top++];
            }

            nums[--top] = nums[i];
        }

        return false;
    }
}
