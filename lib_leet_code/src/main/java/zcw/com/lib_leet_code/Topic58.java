package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2021/7/6.<br><br>
 *
 * 最后一个单词的长度
 */
public class Topic58 {
    public static void main(String[] args) {
        Topic58 instance = new Topic58();

        System.out.println(instance.lengthOfLastWord("Hello World"));
        System.out.println(instance.lengthOfLastWord(" "));
    }

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        String str = s.trim();
        if(str.length() == 0) {
            return 0;
        }

        int counter = 0;
        for(int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if(ch == ' ') {
                return counter;
            }

            counter++;
        }

        return counter;
    }
}
