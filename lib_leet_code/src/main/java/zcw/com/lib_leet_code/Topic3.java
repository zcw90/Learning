package zcw.com.lib_leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 朱城委 on 2019/4/25.<br><br>
 */
public class Topic3 {

    public static void main(String[] args) {
        String[] array = {
                "abcabcbb",
                "bbbbb",
                "pwwkew",
                "r",
                "dvdf",
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~...."
        };

        for (String string : array) {
            System.out.println(lengthOfLongestSubstring7(string));
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String append = "";
        String result = append;

        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (append.contains(ch + "")) {
                if (append.length() > result.length()) {
                    result = append;
                }

                append = append.substring(append.indexOf(ch) + 1);
            }

            append += ch;
        }

        if (append.length() > result.length()) {
            result = append;
        }

        System.out.println("result : " + result);
        return result.length();
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        StringBuilder builder = new StringBuilder();
        String result = builder.toString();

        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (builder.toString().contains(ch + "")) {
                if (builder.toString().length() > result.length()) {
                    result = builder.toString();
                }

                builder = new StringBuilder(builder.substring(builder.indexOf(ch + "") + 1));
            }

            builder.append(ch);
        }

        if (builder.toString().length() > result.length()) {
            result = builder.toString();
        }

        return result.length();
    }

    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring4(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        char ch;
        for (int i = 0, j = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (map.containsKey(ch)) {
                j = Math.max(j, map.get(ch) + 1);
            }

            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - j + 1);
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring5(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int i = 0, j = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                j = Math.max(j, map.get(chars[i]) + 1);
            }

            map.put(chars[i], i);
            maxLength = Math.max(maxLength, i - j + 1);
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring6(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = 0, max = 0;
        while (j < arr.length) {
            for (int m = i; m < j; m++) {
                // case when repeating character is found
                if (arr[m] == arr[j]) {
                    i = m + 1;
                    break;
                }
            }
            j++;
            if (max < j - i) {
                max = j - i;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring7(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int maxLength = 0;

        for (int i = 0, j = 0; i < chars.length; i++) {
            for(int m = j; m < i; m++) {
                if(chars[m] == chars[i]) {
                    j = m + 1;
                    break;
                }
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }

        return maxLength;
    }
}
