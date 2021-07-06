package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2021/7/6.<br><br>
 *
 * 最大子数组和
 */
public class Topic53 {
    public static void main(String[] args) {
        Topic53 instance = new Topic53();

        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(instance.maxSubArray(array));

        array = new int[] {1};
        System.out.println(instance.maxSubArray(array));

        array = new int[] {5,4,-1,7,8};
        System.out.println(instance.maxSubArray(array));
    }

    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;

            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int value : nums) {
            if(sum < 0) {
                sum = 0;
            }

            sum += value;
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
