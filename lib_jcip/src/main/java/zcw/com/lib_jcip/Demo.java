package zcw.com.lib_jcip;

import java.lang.reflect.Field;
import java.util.Arrays;

import sun.misc.Unsafe;

/**
 * Created by 朱城委 on 2019/11/25.<br><br>
 */
public class Demo {
    private static long byteArrayBaseOffset;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);

        Unsafe UNSAFE = (Unsafe) theUnsafe.get(null);
        System.out.println(UNSAFE);

        byte[] array = new byte[10];
        System.out.println(Arrays.toString(array));
        byteArrayBaseOffset = UNSAFE.arrayBaseOffset(byte[].class);
        System.out.println(byteArrayBaseOffset);

        UNSAFE.putByte(array, byteArrayBaseOffset, (byte)1);
        UNSAFE.putByte(array, byteArrayBaseOffset + 5, (byte)5);
        System.out.println(Arrays.toString(array));
    }
}
