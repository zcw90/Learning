package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/4/30.<br><br>
 */
public class Topic137 {

    public static void main(String[] args) {
        int[] array = {2, 2, 3, 2};
        int[] array2 = {0, 1, 0, 1, 0, 1, 99};

        System.out.println(singleNumber(array));
        System.out.println(singleNumber(array2));

        int a = 22;
        int b = a ^ a;
        int c = b & b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Argument error.");
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result &= nums[i];
            result = nums[i] - result;
        }

        return result;
    }
}
