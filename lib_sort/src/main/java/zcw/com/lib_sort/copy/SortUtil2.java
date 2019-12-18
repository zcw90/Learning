package zcw.com.lib_sort.copy;

import zcw.com.lib_sort.util.Util;

/**
 * Created by 朱城委 on 2019/1/21.<br><br>
 */
public class SortUtil2 {

    /**
     * 冒泡排序
     * @param array 要排序的数组
     * @return 返回排序好的数组
     */
    public static int[] sortBubble(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    Util.swap(array, j, j + 1);
                }
            }
        }

        return array;
    }

    /**
     * 改进后的冒泡排序
     * @param array 要排序的数组
     * @return 返回排序好的数组
     */
    public static int[] sortBubble2(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        // 判断是否可以结束循环
        boolean flag = true;

        for(int i = 0; i < array.length - 1 && flag; i++) {
            flag = false;

            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    Util.swap(array, j, j + 1);

                    // 如果发生交换，则需要继续循环
                    flag = true;
                }
            }
        }

        return array;
    }

    /**
     * 选择排序
     * @param array 要排序的数组
     * @return 返回排序好的数组
     */
    public static int[] sortSelect(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        int min;
        for(int i = 0; i < array.length - 1; i++) {
            min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }

            if(min != i) {
                Util.swap(array, i, min);
            }
        }

        return array;
    }

    /**
     * 插入排序
     * @param array 要排序的数组
     * @return 排序后的数组
     */
    public static int[] sortInsert(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        int j;
        int valueTemp;
        for(int i = 0; i < array.length - 1; i++) {
            valueTemp = array[i + 1];

            j = i;
            while(j >= 0 && array[j] > valueTemp) {
                array[j + 1] = array[j];
                j--;
            }

            if(j != i) {
                array[j + 1] = valueTemp;
            }
        }

        return array;
    }

    /**
     * 希尔排序
     * @param array 要排序的数组
     * @return 排序后的数组
     */
    public static int[] sortShell(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        int step = array.length / 2;
        int j;
        int valueTemp;
        while (step > 0) {
            for(int i = 0; i < array.length - step; i++) {
                valueTemp = array[i + step];

                j = i;
                while(j >= 0 && array[j] > valueTemp) {
                    array[j + step] = array[j];
                    j -= step;
                }

                if(j != i) {
                    array[j + step] = valueTemp;
                }
            }

            step /= 2;
        }

        return array;
    }

    /**
     * 堆排序（大顶堆）
     * @param array 要排序的数组
     * @return 排序后的数组
     */
    public static int[] sortHeap(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        // 创建大顶堆
        for(int i = array.length / 2 - 1; i >=0; i--) {
            heapAdjust(array, i, array.length - 1);
        }

        for(int i = 0; i < array.length; i++) {
            Util.swap(array, 0, array.length - i - 1);
            heapAdjust(array, 0, array.length - i - 2);
        }

        return array;
    }

    /**
     * 调整堆为大顶堆
     * @param array 要调整的堆
     * @param start 要调整的起始下标
     * @param end 要调整的结束下标
     */
    private static void heapAdjust(int[] array, int start, int end) {
        if(array == null || start < 0 || start >= array.length
                || end < 0 || end >= array.length) {
            return ;
        }

        int valueTemp = array[start];
        for(int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            if(i < end && array[i] < array[i + 1]) {
                i++;
            }

            if(array[i] < valueTemp) {
                break;
            }

            array[start] = array[i];
            start = i;
        }

        array[start] = valueTemp;
    }

    /**
     * 归并排序
     * @param array 要排序的数组
     * @return 排序后的数组
     */
    public static int[] sortMerge(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        int[] arrayTemp = new int[array.length];
        sortMerge(array, arrayTemp, 0, array.length - 1);
        return array;
    }

    /**
     * 归并排序
     * @param array 要排序的数组
     * @param arrayTemp 辅组空间
     * @param start 排序的起始下标
     * @param end 排序的结束下标
     */
    private static void sortMerge(int[] array, int[] arrayTemp, int start, int end) {
        if(array == null || arrayTemp == null || start < 0 || start >= array.length
                ||  end < 0 || end >= array.length || start > end) {
            return ;
        }

        if(start == end) {
            arrayTemp[start] = array[start];
        }
        else {
            int middle = (start + end) / 2;
            sortMerge(array, arrayTemp, start, middle);
            sortMerge(array, arrayTemp, middle + 1, end);
            merge(array, arrayTemp, start, end);
        }
    }

    /**
     * 按序合并2个数组
     * @param array 要排序的数组
     * @param arrayTemp 辅助空间
     * @param start 要合并的起始下标
     * @param end 要合并的结束下标
     */
    private static void merge(int[] array, int[] arrayTemp, int start, int end) {
        if(start >= end) {
            return ;
        }

        // 合并数组的分界下标
        int middle = (start + end) / 2;
        int index = 0;
        int i = start, j = middle + 1;

        // 按序依次放入辅组空间中
        while(i <= middle && j <= end) {
            if(array[i] < array[j]) {
                arrayTemp[index++] = array[i++];
            }
            else {
                arrayTemp[index++] = array[j++];
            }
        }

        // 把剩余的元素放入辅组空间
        while(i <= middle) {
            arrayTemp[index++] = array[i++];
        }

        // 把剩余的元素放入辅组空间
        while (j <= end) {
            arrayTemp[index++] = array[j++];
        }

        // 最后把完整排序的元素重新放回原数组中
        for(i = 0; i <= end - start; i++) {
            array[start + i] = arrayTemp[i];
        }
    }

    /**
     * 快速排序
     * @param array 要排序的数组
     * @return 排序后的数组
     */
    public static int[] sortQuick(int[] array) {
        if(array == null) {
            return new int[] {};
        }

        sortQuick(array, 0, array.length - 1);
        return array;
    }

    /**
     * 递归进行快速排序
     * @param array 要排序的数组
     * @param start 排序的起始下标
     * @param end 排序的结束下标
     */
    private static void sortQuick(int[] array, int start, int end) {
        if(array == null || start < 0 || start >= array.length ||
                end < 0 || end >= array.length || start > end) {
            return ;
        }

        int keyIndex = partition(array, start, end);
        sortQuick(array, start, keyIndex - 1);
        sortQuick(array, keyIndex + 1, end);
    }

    /**
     * 对数组进行分区
     * @param array 要分区的数组
     * @param start 分区的起始下标
     * @param end 分区的结束下标
     * @return 返回分区后关键字下标
     */
    private static int partition(int[] array, int start, int end) {
        if(array == null || start < 0 || start >= array.length ||
                end < 0 || end >= array.length) {
            throw new IllegalArgumentException("Argument Illegal.");
        }

        int key = array[start];
        while (start < end) {
            while (start < end && array[end] >= key) {
                end--;
            }
            array[start] = array[end];

            while (start < end && array[start] <= key) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = key;

        return start;
    }
}
