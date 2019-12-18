package zcw.com.lib_sort.copy;

import zcw.com.lib_sort.util.Util;

/**
 * Created by 朱城委 on 2019/5/14.<br><br>
 */
public class Bubble {
    /**
     * 冒泡排序
     * @param array 要排序的数组
     * @return 返回排序好的数组
     */
    public static int[] sortBubble(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        int countCompare = 0;
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                countCompare++;
                if(array[j] > array[j + 1]) {
                    Util.swap(array, j, j + 1);
                }
            }
        }

        System.out.println("比较次数：" + countCompare);
        return array;
    }

    /**
     * 冒泡排序
     * @param array 要排序的数组
     * @return 返回排序好的数组
     */
    public static int[] sortBubble2(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        // 是否还需要比较
        boolean flag = true;

        int countCompare = 0;
        for(int i = 0; i < array.length - 1 && flag; i++) {

            // 如果没有发生交换，则可以结束循环
            flag = false;

            for(int j = 0; j < array.length - i - 1; j++) {

                countCompare++;
                if(array[j] > array[j + 1]) {
                    Util.swap(array, j, j + 1);
                    flag = true;    // 如果发生交换，则需要继续循环
                }
            }
        }

        System.out.println("比较次数：" + countCompare);
        return array;
    }

    public static void main(String[] args) {
        int[] array1 = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        int[] array2 = {2, 1, 3, 4, 5, 6, 7, 8, 9};

//        System.out.println("====================");
//        System.out.print("(冒泡排序)数组之和：" + Util.sum(array1) + "   ");
//        Util.printArray(array1);
//
//        System.out.print("(冒泡排序)数组之和：" + Util.sum(array1) + "   ");
//        Util.printArray(sortBubble(array1));

        System.out.println("====================");
        System.out.print("(冒泡排序)数组之和：" + Util.sum(array2) + "   ");
        Util.printArray(array2);

        System.out.print("(冒泡排序)数组之和：" + Util.sum(array2) + "   ");
        Util.printArray(sortBubble2(array2));
    }
}
