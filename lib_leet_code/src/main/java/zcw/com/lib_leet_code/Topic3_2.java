package zcw.com.lib_leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 朱城委 on 2021/6/30.<br><br>
 */
public class Topic3_2 {

    public static void main(String[] args) {
        Topic3_2 topic3_2 = new Topic3_2();

        String[] array = {
                "abcabcbb",
                "bbbbb",
                "pwwkew",
                "r",
                "dvdf",
                "abba",
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~...."
        };

        for (String string : array) {
            System.out.println(topic3_2.lengthOfLongestSubstring2(string));
        }
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int startIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            String subStr = s.substring(startIndex, i);
            int charIndex = subStr.indexOf(s.charAt(i));
            if(charIndex != -1) {
                startIndex += charIndex + 1;
            }

            if(i - startIndex + 1 > maxLength) {
                maxLength = i - startIndex + 1;
            }
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(; end < s.length(); end++) {
            char ch = s.charAt(end);
            if(map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }

            map.put(ch, end);
            maxLength = Math.max(end - start + 1, maxLength);
        }

        return maxLength;
    }
}
