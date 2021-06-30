package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2021/7/1.<br><br>
 *
 * 整数反转
 */
public class Topic7 {
    public static void main(String[] args) {
        Topic7 topic7 = new Topic7();

        int[] array = {
                123,
                -123,
                120,
                1534236469
        };

        for(int value : array) {
            System.out.println(topic7.reverse(value));
        }
    }

    public int reverse(int x) {
        int result = 0;

        while(x != 0) {
            if(result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }

            result *= 10;
            result += x % 10;
            x = x / 10;
        }

        return result;
    }
}
