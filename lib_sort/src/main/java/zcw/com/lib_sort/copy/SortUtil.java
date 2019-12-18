package zcw.com.lib_sort.copy;

/**
 * Created by 朱城委 on 2019/1/21.<br><br>
 */
public class SortUtil {

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
                    swap(array, j, j + 1);
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

        int indexMax;
        for(int i = 0; i < array.length - 1; i++) {
            indexMax = i;

            for(int j = i; j < array.length; j++) {
                if(array[j] < array[indexMax]) {
                    indexMax = j;
                }
            }

            if(indexMax != i) {
                swap(array, indexMax, i);
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
        int temp;
        for(int i = 0; i < array.length - 1; i++) {
            temp = array[i + 1];
            j = i;

            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
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

    private static void sortQuick(int[] array, int start, int end) {
        if(start >= end || array == null || start < 0 || end > array.length) {
            return ;
        }

        int value = array[start];
        int i = start;
        int j = end;
        while (i != j) {
            while(i < j && array[j] >= value) {
                j--;
            }

            while(i < j && array[i] <= value) {
                i++;
            }

            swap(array, i, j);
        }
        swap(array, start, i);

        sortQuick(array, start, i - 1);
        sortQuick(array, i + 1, end);
    }

    /**
     * 交换数组中2个元素的值
     * @param array
     * @param index1
     * @param index2
     */
    private static void swap(int[] array, int index1, int index2) {
        if(array == null || index1 < 0 || index2 < 0)   return ;

        if(index1 >= array.length || index2 >= array.length)    return ;

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
