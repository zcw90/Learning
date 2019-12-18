package zcw.com.lib_sort.copy;

import zcw.com.lib_sort.util.Util;

public class Test {
    private static final int size = 20;
    private static final int maxValue = 1000;

    public static void main(String[] args) {
        int[] array = Util.createArray(size, maxValue);
        System.out.print("(插入排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(插入排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(SortUtil2.sortInsert(array));

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(希尔排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(希尔排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(SortUtil2.sortShell(array));

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(选择排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(选择排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(SortUtil2.sortSelect(array));

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(冒泡排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(冒泡排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(SortUtil2.sortBubble(array));

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(快速排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(快速排序)数组之和：" + Util.sum(array) + "   ");
        array = SortUtil2.sortQuick(array);
        Util.printArray(array);

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(堆排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(堆排序)数组之和：" + Util.sum(array) + "   ");
        SortUtil2.sortHeap(array);
        Util.printArray(array);

        System.out.println("====================");
        array = Util.createArray(size, maxValue);
        System.out.print("(归并排序)数组之和：" + Util.sum(array) + "   ");
        Util.printArray(array);

        System.out.print("(归并排序)数组之和：" + Util.sum(array) + "   ");
        SortUtil2.sortMerge(array);
        Util.printArray(array);
//
//        System.out.println("====================");
//        array = Util.createArray(size, maxValue);
//        System.out.print("(计数排序)数组之和：" + Util.sum(array) + "   ");
//        Util.printArray(array);
//
//        System.out.print("(计数排序)数组之和：" + Util.sum(array) + "   ");
//        SortUtil.sortCount(array, maxValue);
//        Util.printArray(array);
    }
}
