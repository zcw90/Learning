package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2021/7/1.<br><br>
 *
 * 接雨水
 */
public class Topic42 {
    public static void main(String[] args) {
        Topic42 instance = new Topic42();

        int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(instance.trap(array));

        array = new int[] {4,2,0,3,2,5};
        System.out.println(instance.trap(array));
    }

    public int trap(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }

        int water = 0;
        int start = 0;
        int end = height.length - 1;
        int standard = 0;
        while (start <= end) {
            if(height[start] <= height[end]) {
                if(height[start] <= standard) {
                    water += standard - height[start];
                    start++;
                }
                else {
                    standard = height[start];
                }
            }
            else {
                if(height[end] <= standard) {
                    water += standard - height[end];
                    end--;
                }
                else {
                    standard = height[end];
                }
            }
        }

        return water;
    }
}
