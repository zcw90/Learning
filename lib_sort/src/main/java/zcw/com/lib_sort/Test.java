package zcw.com.lib_sort;

import java.util.Arrays;

import zcw.com.lib_sort.util.Util;

public class Test {
    private static final int size = 20;
    private static final int maxValue = 1000;

    public static void main(String[] args) {
        int[] array = Util.createArray(size, maxValue);
        System.out.print("(插入排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(插入排序)数组之和：" + Util.sum(array) + "   ");
//        Util.printArray(SortUtil.sortInsert(array));
        Util.printArray(insertSortTemp(array));


        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(希尔排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(希尔排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(SortUtil.sortShell(array));

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(选择排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(选择排序)数组之和：" + Util.sum(array) + "   ");
//        Util.printArray(SortUtil.sortSelect(array));
        Util.printArray(selectSortTemp(array));

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(冒泡排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(冒泡排序)数组之和：" + Util.sum(array) + "   ");
//        Util.printArray(SortUtil.sortBubble(array));
        Util.printArray(bubbleSortTemp(array));

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(快速排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(快速排序)数组之和：" + Util.sum(array) + "   ");
        SortUtil.sortQuick(array, 0, array.length - 1);
        Util.printArray(array);

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(堆排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(堆排序)数组之和：" + Util.sum(array) + "   ");
        SortUtil.sortHeap(array);
        Util.printArray(array);

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(归并排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(归并排序)数组之和：" + Util.sum(array) + "   ");
        SortUtil.sortMerge(array);
        Util.printArray(array);

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(计数排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(计数排序)数组之和：" + Util.sum(array) + "   ");
        SortUtil.sortCount(array, maxValue);
        Util.printArray(array);

        testTime();
    }

    private static void testTime() {
        int[] array = Util.createArray(100000000, 1000000000);
//        int[] array1 = Arrays.copyOf(array, array.length);

        long start = System.currentTimeMillis();
        System.out.println("====================");
        SortUtil.sortQuick(array, 0, array.length - 1);
        System.out.println("Quick sort time:" + (System.currentTimeMillis() - start));

//        start = System.currentTimeMillis();
//        System.out.println("====================");
//        SortUtil.sortBubble(array1);
//        System.out.println("Bubble sort time:" + (System.currentTimeMillis() - start));
    }

    private static int[] selectSortTemp(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        int index;
        int temp;
        for(int i = 0; i < array.length - 1; i++) {
            index = i;

            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[index]) {
                    index = j;
                }
            }

            if(index != i) {
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }

        return array;
    }

    private static int[] insertSortTemp(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        int temp;
        int j;
        for(int i = 0; i < array.length - 1; i++) {
            j = i + 1;
            temp = array[j];

            while(j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = temp;
        }

        return array;
    }

    private static int[] bubbleSortTemp(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        int temp;
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}
