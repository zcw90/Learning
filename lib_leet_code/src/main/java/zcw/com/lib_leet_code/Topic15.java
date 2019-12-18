package zcw.com.lib_leet_code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 朱城委 on 2019/7/9.<br><br>
 */
public class Topic15 {

    public static void main(String[] args) {
        Topic15 instance = new Topic15();

        int[] array1 = {-1, 0, 1, 2, -1, -4};
        int[] array2 = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        int[] array3 = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        int[] array4 = {0, 0, 0, 0};

        System.out.println(instance.threeSum(array1));
        System.out.println(instance.threeSum(array2));
        System.out.println(instance.threeSum(array3));
        System.out.println(instance.threeSum(array4));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);

                        if(!isRepetition(result, item)) {
                            result.add(item);
                            item = new ArrayList<>();
                        }

                        item.clear();
                    }
                }
            }
        }

        return result;
    }

    private boolean isRepetition(List<List<Integer>> list, List<Integer> item) {
        for(List<Integer> temp : list) {
            temp.sort(comparator);
            item.sort(comparator);

            if(temp.size() != item.size()) {
                return false;
            }

            int i;
            for(i = 0; i < temp.size(); i++) {
                if(temp.get(i) != item.get(i)) {
                    break;
                }
            }
            if(i == temp.size()) {
                return true;
            }
        }
        return false;
    }

    private static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };
}
