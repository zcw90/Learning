package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2021/7/1.<br><br>
 *
 * 回文数
 */
public class Topic9 {
    public static void main(String[] args) {
        Topic9 topic9 = new Topic9();

        int[] array = {
                121,
                -121,
        };

        for(int value : array) {
            System.out.println(topic9.isPalindrome(value));
        }
    }

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int reverse = 0;
        int origin = x;
        while(x != 0) {
            reverse *= 10;
            reverse += x % 10;
            x = x / 10;
        }

        return origin == reverse;
    }
}
