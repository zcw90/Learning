package zcw.com.lib_leet_code.test;

/**
 * Created by 朱城委 on 2019/6/19.<br><br>
 */
public class PatternMatch {
    public static void main(String[] args) {
        String s = "goodgoogle";
        String t = "google";
        System.out.println(isMatch(s, t));
        System.out.println("kmp: " + kmp(s,t));

        s = "fwerofmsfadsf";
        t = "fmsfa";
        System.out.println(isMatch(s, t));
        System.out.println("kmp: " + kmp(s,t));

        s = "fwerofmsfadsf";
        t = "erte";
        System.out.println(isMatch(s, t));
        System.out.println("kmp: " + kmp(s,t));

        s = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
        t = "000000000000000000000000000000000000000000000000000000000001";
        System.out.println(isMatch(s, t));
        System.out.println("kmp: " + kmp(s,t));
    }

    public static int isMatch(String string, String pattern) {
        if(string == null || pattern == null) {
            return -1;
        }

        int i = 0;
        int j = 0;

        while (i < string.length() && j < pattern.length()) {
            if(string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            else {
                i = i - j + 1;
                j = 0;
            }
        }

        if(j == pattern.length()) {
            return i - j;
        }

        return -1;
    }

    public static int kmp(String string, String pattern) {
        if(string == null || pattern == null) {
            return -1;
        }

        int i = 0;
        int j = 0;
        int[] next = getNext(pattern);
        while (i < string.length() && j < pattern.length()) {
            if(j == -1 || string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            else {
                j = next[j];
            }
        }

        if(j == pattern.length()) {
            return i - j;
        }

        return -1;
    }

    /**
     * 获取KMP算法next数组
     * @param pattern 模式串
     * @return 如果{@code pattern}为null，或者长度为0，返回长度为零的数组。
     */
    private static int[] getNext(String pattern) {
        if(pattern == null || pattern.length() == 0) {
            return new int[] {};
        }

        int[] next = new int[pattern.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pattern.length() - 1) {
            if(k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                k++;
                j++;

                if(pattern.charAt(k) != pattern.charAt(j)) {
                    next[j] = k;
                }
                else {
                    next[j] = next[k];
                }
            }
            else {
                k = next[k];
            }
        }

        return next;
    }
}
