package zcw.com.basic.asm;

/**
 * Created by 朱城委 on 2019/10/28.<br><br>
 */
public class ByteCodeDemo {
    private int a = 1;

    public int add() {
        int b = 2;
        int c = a + b;
        System.out.println(c);
        return c;
    }
}
