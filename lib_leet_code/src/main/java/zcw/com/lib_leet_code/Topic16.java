package zcw.com.lib_leet_code;

import java.util.Arrays;

/**
 * Created by 朱城委 on 2019/7/9.<br><br>
 */
public class Topic16 {

    public static void main(String[] args) {
        Topic16 instance = new Topic16();

        int[] array1 = {-1, 0, 1, 2, -1, -4};
        int[] array2 = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        int[] array3 = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        int[] array4 = {0, 0, 0, 0};
        int[] array5 = {0, 0, 0};
        int[] array6 = {-1, 2, 1, -4};
        int[] array7 = {0, 1, 2};
        int[] array8 = {-1, 0, 1, 1, 55};

        System.out.println(instance.threeSumClosest(array1, 1));
        System.out.println(instance.threeSumClosest(array2, 1));
        System.out.println(instance.threeSumClosest(array3, 1));
        System.out.println(instance.threeSumClosest(array4, 1));
        System.out.println(instance.threeSumClosest(array5, 1));
        System.out.println(instance.threeSumClosest(array6, 1));
        System.out.println(instance.threeSumClosest(array7, 0));
        System.out.println(instance.threeSumClosest(array8, 3));
    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Argument error.");
        }

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        int low, high, sum;
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                low = i + 1;
                high = nums.length - 1;

                while (low < high) {
                    sum = nums[i] + nums[low] + nums[high];
                    if(target == sum) {
                        return target;
                    }

                    if(Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }

                    if(sum < target) {
                        low++;

                        while(low < high && nums[low] == nums[low - 1]) {
                            low++;
                        }
                    }
                    else if(sum > target) {
                        high--;

                        while(low < high && nums[high] == nums[high + 1]) {
                            high--;
                        }
                    }
                }
            }
        }

        return result;
    }
}
