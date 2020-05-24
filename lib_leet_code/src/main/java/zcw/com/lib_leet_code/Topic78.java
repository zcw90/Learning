package zcw.com.lib_leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱城委 on 2020-5-17.<br><br>
 */
public class Topic78 {
    public static void main(String[] args) {
        Topic78 topic78 = new Topic78();

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
        result.add(new ArrayList<>());
        for(int num : nums) {
            subsets(result, num);
        }

        return result;
    }

    private void subsets(List<List<Integer>> result, int num) {
        List<List<Integer>> resultTemp = new ArrayList<>();

        for(List<Integer> list : result) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(num);
            resultTemp.add(temp);
        }

        result.addAll(resultTemp);
    }
}
