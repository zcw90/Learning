package zcw.com.lib_leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 朱城委 on 2019/7/9.<br><br>
 */
public class Topic15_2 {

    public static void main(String[] args) {
        Topic15_2 instance = new Topic15_2();

        int[] array1 = {-1, 0, 1, 2, -1, -4};
        int[] array2 = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        int[] array3 = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        int[] array4 = {0, 0, 0, 0};
        int[] array5 = {0, 0, 0};

        System.out.println(instance.threeSum(array1));
        System.out.println(instance.threeSum(array2));
        System.out.println(instance.threeSum(array3));
        System.out.println(instance.threeSum(array4));
        System.out.println(instance.threeSum(array5));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        if(nums[0] > 0) {
            return result;
        }

        int low, high, sum;
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                low = i + 1;
                high = nums.length - 1;
                sum = 0 - nums[i];

                while (low < high) {
                    if(nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }

                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }

                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] < sum) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return new ArrayList<List<Integer>>();

        Arrays.sort(nums);  //sort the array first
        List<List<Integer>> res = new ArrayList<>();
        int max = Math.max(nums[len - 1], Math.abs(nums[0])); //to allocate enough space to avoid check in if statement

        byte[] hash = new byte[(max<<1) + 1];
        for (int v : nums) { //hash and count appearing times of every num
            hash[v + max]++;
        }

        int lastNeg = Arrays.binarySearch(nums, 0); //search the position of 0; it also means the position of the last negative number in array
        int firstPos = lastNeg; //the position of the first positive number in array
        if(lastNeg < 0){    //0 not found
            firstPos = ~lastNeg;
            lastNeg = -lastNeg - 2;//see the Java api
        }
        else{               //found
            while(lastNeg >=0 && nums[lastNeg] == 0) //skip all 0
                --lastNeg;
            while(firstPos < len && nums[firstPos] == 0)
                ++firstPos;
            int zeroCount = firstPos - lastNeg - 1;
            if (zeroCount >= 3) { // (0 appears 3 times at least)
                res.add(Arrays.asList(0, 0, 0));
            }
            if (zeroCount > 0 ) { // (0 appears 1 times at least)
                for (int i = firstPos; i < len; ++i) { //traverse all the positive numbers to see whether there is a negative number whose absolute value equals to the positive number
                    if(i > firstPos && nums[i] == nums[i - 1]) //skip the same elements
                        continue;
                    if ( hash[-nums[i] + max] > 0) {
                        res.add(Arrays.asList(0, nums[i], -nums[i]));
                    }
                }
            }
        }

        // one positive number and two negetive numbers
        for (int i = firstPos; i < len; ++i) { //traverse all the positive numbers to find whether there are two negative numbers to make the 3 numbers added up to 0
            if(i > firstPos && nums[i] == nums[i - 1]) //skip the same elements
                continue;
            int half;   //we can traverse only half of the positive numbers
            if(nums[i] % 2 != 0)
                half = -((nums[i]>>1) + 1);
            else{
                half = -(nums[i]>>1);
                if(hash[half + max] > 1)
                    res.add(Arrays.asList(nums[i], half, half));
            }
            for(int j = lastNeg; j >=0 && nums[j] > half; --j){
                if(j < lastNeg && nums[j] == nums[j + 1])
                    continue;
                if(hash[(-nums[i] - nums[j]) + max] > 0)
                    res.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
            }
        }

        // one negative number and two positive numbers
        for (int i = lastNeg; i >= 0; --i) { //traverse all the negative numbers to find whether there are two positive numbers to make the 3 numbers added up to 0
            if(i < lastNeg && nums[i] == nums[i + 1])//skip the same elements
                continue;
            int half; //we can traverse only half of the negative numbers
            if(nums[i] % 2 != 0)
                half = -(nums[i] / 2 - 1);
            else{
                half = -(nums[i]>>1);
                if(hash[half + max] > 1)
                    res.add(Arrays.asList(nums[i], half, half));
            }
            for(int j = firstPos; j < len && nums[j] < half; ++j){
                if(j > firstPos && nums[j] == nums[j - 1])
                    continue;
                if(hash[(-nums[i] - nums[j]) + max] > 0)
                    res.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
            }
        }
        return res;
    }
}
