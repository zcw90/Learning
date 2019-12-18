package zcw.com.lib_sort;

/**
 * Created by 朱城委 on 2018/10/16.<br><br>
 * 排序工具类
 */
public class SortUtil {

    /**
     * 插入排序
     * @param array 要排序的数组
     * @return
     */
    public static int[] sortInsert(int[] array) {
        if(array == null) {
            return new int[]{};
        }

        int temp;
        int j;
        for(int i = 0; i < array.length - 1; i++) {
            temp = array[i + 1];

            j = i;
            while(j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }

        return array;
    }

    /**
     * 希尔排序
     * @param array
     * @return
     */
    public static int[] sortShell(int[] array) {
        if(array == null) {
            return new int[]{};
        }

        int gap = array.length / 2;
        int temp;
        int i, j;
        while(gap > 0) {

            for(i = 0; i < array.length - gap; i++) {
                temp = array[i + gap];

                j = i;
                while(j >= 0 && array[j] > temp) {
                    array[j + gap] = array[j];
                    j -= gap;
                }

                array[j + gap] = temp;
            }

            gap /= 2;
        }

        return array;
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] sortSelect(int[] array) {
        if(array == null) {
            return new int[]{};
        }

        int index;
        for(int i = 0; i < array.length - 1; i++) {
            index = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[index] > array[j]) {
                    index = j;
                }
            }

            if(index != i) {
                swap(array, i, index);
            }
        }
        return array;
    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] sortBubble(int[] array) {
        if(array == null) {
            return new int[]{};
        }

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

        return array;
    }

    /**
     * 快速排序
     * @param array
     * @return
     */
    public static void sortQuick(int[] array, int start, int end) {
        if(array == null || start < 0 || end >= array.length) {
            return ;
        }

        if(start >= end) return ;

        int i = start;
        int j = end;
        int temp = array[i];
        while(i != j) {
            while(i < j && array[j] >= temp)
                j--;
            array[i] = array[j];

            while(i < j && array[i] <= temp)
                i++;
            array[j] = array[i];
        }
        array[i] = temp;

        sortQuick(array, start, i - 1);
        sortQuick(array, j + 1, end);
    }

    /**
     * 堆排序
     * @param array
     */
    public static void sortHeap(int[] array) {
        if(array == null) {
            return;
        }

        buildMaxHeap(array);
        for(int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);

            adjustHeap(array, 0, i);
        }
    }

    /**
     * 归并排序
     * @param array
     */
    public static void sortMerge(int[] array) {
        if (array == null) {
            return ;
        }

        int length = array.length;
        int[] temp = new int[length];
        sortMerge(array, 0, length - 1, temp);
    }

    /**
     * 计数排序
     * @param array 要排序的数组
     * @param maxValue 数组中最大的值
     */
    public static void sortCount(int[] array, int maxValue) {
        if(array == null) {
            return ;
        }

        int[] temp = new int[maxValue + 1];
        for(int i = 0; i < array.length; i++) {
            temp[array[i]]++;
        }

        int index = 0;
        for(int i = 0; i < temp.length; i++) {
            for(int j = 0; j < temp[i]; j++) {
                array[index] = i;
                index++;
            }
        }
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

    /**
     * 创建大顶堆
     * @param array
     */
    private static void buildMaxHeap(int[] array) {
        for(int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
    }

    /**
     * 调整堆
     * @param array
     * @param index
     * @param length 需要调整堆的长度
     */
    private static void adjustHeap(int[] array, int index, int length) {
        if(index >= length) {
            return ;
        }

        // 比较左右节点，拿到最大的元素
        int max = index;
        int child_left = 2 * index + 1;
        int child_right = 2 * (index + 1);
        if(child_left < length && array[max] < array[child_left]) {
            max = child_left;
        }
        if(child_right < length && array[max] < array[child_right]) {
            max = child_right;
        }

        // 如果最大元素为子节点，则交换
        if(max != index) {
            swap(array, max, index);

            // 递归调整堆
            adjustHeap(array, max, length);
        }
    }

    /**
     * 将数组array依大小复制到temp中，然后再复制回array中。
     * @param array
     * @param start
     * @param end
     * @param temp
     */
    private synchronized static void mergeArray(int[] array, int start, int end, int[] temp) {
        if(start >= end) {
            return ;
        }

        int i = start;
        int middle = (start + end) / 2;
        int j = middle + 1;
        int indexTemp = 0;

        while(i <= middle && j <= end) {
            if(array[i] <= array[j]) {
                temp[indexTemp++] = array[i++];
            }
            else {
                temp[indexTemp++] = array[j++];
            }
        }

        while(i <= middle) {
            temp[indexTemp++] = array[i++];
        }

        while(j <= end) {
            temp[indexTemp++] = array[j++];
        }

        for(i = 0; i < indexTemp; i++) {
            array[start + i] = temp[i];
        }
    }

    /**
     * 归并排序
     * @param array
     * @param start
     * @param end
     * @param temp
     */
    private static void sortMerge(int[] array, int start, int end, int[] temp) {
        if(start < end) {
            int middle = (start + end) / 2;
            sortMerge(array, start, middle, temp);
            sortMerge(array, middle + 1, end, temp);
            mergeArray(array, start, end, temp);
        }
    }
}
