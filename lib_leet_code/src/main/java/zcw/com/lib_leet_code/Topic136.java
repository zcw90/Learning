package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/4/30.<br><br>
 */
public class Topic136 {

    public static void main(String[] args) {
        int[] array = {2, 2, 1};
        int[] array2 = {4, 1, 2, 1, 2};

        System.out.println(singleNumber(array));
        System.out.println(singleNumber(array2));

        int[] array3 = {1, 2, 2, 1, 3, 4, 5, 78, 78, 5, 23, 23, 3, 4, 54, 21};
        for (int value : singleNumberTwo(array3)) {
            System.out.println(value);
        }
    }

    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Argument error.");
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    /**
     * 找出数组中，2个只出现一次的数字。<br>
     * 思路参数：https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484505&idx=1&sn=4c1c056dd4852c3b4b1ead51c90a9b2d&chksm=fa0e6bd8cd79e2ce8188dcdd8843a5d071248906bfb8971c62d513dbd69b816acc191a78e4b2&scene=21#wechat_redirect
     *
     * @param nums
     * @return
     */
    public static int[] singleNumberTwo(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Argument error.");
        }

        // 得到2个数字的异或值
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        // 从低位开始，找到第一个不为1的位
        int value = 1;
        while ((result & value) != value) {
            value <<= 2;
        }

        // 此位为1、此位不为1的元素，分别处理
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & value) == value) {
                result1 ^= nums[i];
            } else {
                result2 ^= nums[i];
            }
        }

        return new int[]{result1, result2};
    }
}
