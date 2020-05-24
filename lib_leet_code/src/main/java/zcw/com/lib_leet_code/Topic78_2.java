package zcw.com.lib_leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱城委 on 2020-5-17.<br><br>
 */
public class Topic78_2 {
    public static void main(String[] args) {
        Topic78_2 topic78 = new Topic78_2();

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
        subsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            subsets(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
