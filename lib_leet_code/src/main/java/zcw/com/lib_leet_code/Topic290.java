package zcw.com.lib_leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 朱城委 on 2019/6/25.<br><br>
 */
public class Topic290 {
    public static void main(String[] args) {
        Topic290 instance = new Topic290();

        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(instance.wordPattern(pattern, str));

        pattern = "abba";
        str = "dog cat cat fish";
        System.out.println(instance.wordPattern(pattern, str));

        pattern = "aaaa";
        str = "dog cat cat dog";
        System.out.println(instance.wordPattern(pattern, str));

        pattern = "abba";
        str = "dog dog dog dog";
        System.out.println(instance.wordPattern(pattern, str));

        pattern = "abba";
        str = "dog cat cat dog";
        System.out.println(instance.wordPattern2(pattern, str));

        pattern = "abba";
        str = "dog cat cat fish";
        System.out.println(instance.wordPattern2(pattern, str));

        pattern = "aaaa";
        str = "dog cat cat dog";
        System.out.println(instance.wordPattern2(pattern, str));

        pattern = "abba";
        str = "dog dog dog dog";
        System.out.println(instance.wordPattern2(pattern, str));
    }

    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null) {
            return false;
        }

        String[] array = str.split(" ");
        if(array.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i))) {
                if(map.containsValue(array[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), array[i]);
            }
            else {
                if(!map.get(pattern.charAt(i)).equals(array[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        if(pattern == null || str == null) {
            return false;
        }

        String[] array = str.split(" ");
        if(array.length != pattern.length()) {
            return false;
        }

        Map map = new HashMap<>();
        for(Integer i = 0; i < pattern.length(); i++) {
            if(map.put(pattern.charAt(i), i) != map.put(array[i], i)) {
                return false;
            }
        }

        return true;
    }
}
