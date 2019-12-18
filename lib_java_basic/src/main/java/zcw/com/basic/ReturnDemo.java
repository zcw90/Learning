package zcw.com.basic;

/**
 * Created by 朱城委 on 2019/11/25.<br><br>
 */
public class ReturnDemo {
    public static void main(String[] args) {
        ReturnDemo demo = new ReturnDemo();

        System.out.println(add(5, 6));
        System.out.println(demo.mul(5, 6));
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }
}
