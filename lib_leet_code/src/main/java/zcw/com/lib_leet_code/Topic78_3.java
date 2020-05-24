package zcw.com.lib_leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱城委 on 2020-5-17.<br><br>
 */
public class Topic78_3 {
    public static void main(String[] args) {
        Topic78_3 topic78 = new Topic78_3();

        int[] array0 = new int[] {};
        System.out.print("Array0: ");
        System.out.println(topic78.subsets(array0));

        int[] array1 = new int[] {1};
        System.out.print("Array1: ");
        System.out.println(topic78.subsets(array1));

        int[] array2 = new int[] {1, 2};
        System.out.print("Array2: ");
        System.out.println(topic78.subsets(array2));

        int[] array3 = new int[] {1, 2, 3};
        System.out.print("Array3: ");
        System.out.println(topic78.subsets(array3));

        int[] array4 = new int[] {1, 2, 3, 4};
        System.out.print("Array4: ");
        System.out.println(topic78.subsets(array4));
    }

    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null) {
            throw new IllegalArgumentException("Argument can't be null.");
        }

        List<List<Integer>> result = new ArrayList<>();
        subsets(result, nums);
        return result;
    }

    private void subsets(List<List<Integer>> result, int[] nums) {
        int size = 1 << nums.length;

        for(int i = 0; i < size; i++) {
            List<Integer> tempList = new ArrayList<>();

            for(int j = 0; j < nums.length; j++) {
                if(((i >> j) & 1) == 1) {
                    tempList.add(nums[j]);
                }
            }

            result.add(tempList);
        }
    }
}
