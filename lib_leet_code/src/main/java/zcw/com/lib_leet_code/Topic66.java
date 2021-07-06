package zcw.com.lib_leet_code;


import java.util.Arrays;

/**
 * Created by 朱城委 on 2021/7/6.<br><br>
 *
 * 加一
 */
public class Topic66 {
    public static void main(String[] args) {
        Topic66 instance = new Topic66();

        int[] array = {1,2,3};
        Util.printArray(instance.plusOne(array));

        array = new int[] {9,8,7,6,5,4,3,2,1,0};
        Util.printArray(instance.plusOne(array));

        array = new int[] {9};
        Util.printArray(instance.plusOne(array));
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int carry = 1;

        int[] result = new int[length + 1];
        for(int i = length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            result[i + 1] = sum == 10 ? 0 : sum;

            if(sum == 10) {
                carry = 1;
            }
            else {
                carry = 0;
            }
        }

        if(carry == 1) {
            result[0] = 1;
        }
        else {
            result = Arrays.copyOfRange(result, 1, result.length);
        }

        return result;
    }
}
