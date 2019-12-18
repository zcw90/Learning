package zcw.com.lib_sort.util;

import java.util.Random;

/**
 * Created by 朱城委 on 2018/10/16.<br><br>
 * 工具类
 */
public class Util {

    /** 随机数产生器 */
    private static Random random = new Random();

    /**
     * 产生[0, maxValue]的随机整数。
     * @param maxValue
     * @return
     */
    public static int random(int maxValue) {
        return random.nextInt(maxValue);
    }

    /**
     * 生成数组
     * @param size 数组大小
     * @param maxValue 数组元素最大值
     * @return
     */
    public static int[] createArray(int size, int maxValue) {
        if(size < 0 || maxValue < 0) {
            return new int[]{};
        }

        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = random(maxValue);
        }

        return array;
    }

    /**
     * 打印数组
     * @param array
     */
    public static void printArray(int[] array) {
        if (array == null)  return ;

        for(int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * 求数组元素之和
     * @param array
     * @return
     */
    public static long sum(int[] array) {
        if(array == null) return -1;

        long result = 0;

        for(int value : array) {
            result += value;
        }

        return result;
    }

    /**
     * 交换数组中2个元素的值
     * @param array
     * @param index1
     * @param index2
     */
    public static void swap(int[] array, int index1, int index2) {
        if(array == null || index1 < 0 || index2 < 0)   return ;

        if(index1 >= array.length || index2 >= array.length)    return ;

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
