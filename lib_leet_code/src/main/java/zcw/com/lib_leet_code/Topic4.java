package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/4/24.<br><br>
 */
public class Topic4 {
    public static void main(String[] arg) {
//        int[] array1 = {1, 3};
//        int[] array2 = {2};
        int[] array1 = {1, 2};
        int[] array2 = {3, 4};

        System.out.println(findMedianSortedArrays(array1, array2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) {
            throw new IllegalArgumentException("All argument null");
        }

        if(nums1 == null) {
            return getMedian(nums2);
        }

        if(nums2 == null) {
            return getMedian(nums1);
        }

        int[] temp = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < temp.length; i++) {
            if(index1 >= nums1.length) {
                temp[i] = nums2[index2];
                index2++;
                continue;
            }
            else if(index2 >= nums2.length) {
                temp[i] = nums1[index1];
                index1++;
                continue;
            }

            if(nums1[index1] <= nums2[index2]) {
                temp[i] = nums1[index1];
                index1++;
            }
            else {
                temp[i] = nums2[index2];
                index2++;
            }
        }

        return getMedian(temp);
    }

    public static double getMedian(int[] array) {
        if(array == null) {
            throw new IllegalArgumentException("Argument is null.");
        }

        if(array.length % 2 == 0) {
            return (array[array.length / 2] + array[array.length / 2 - 1]) / 2.0;
        }
        else {
            return array[array.length / 2];
        }
    }
}
