package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/7/10.<br><br>
 */
public class Topic151 {
    public static void main(String[] args) {
        Topic151 instance = new Topic151();

        String string1 = "the sky is blue";
        String string2 = "  hello world!  ";
        String string3 = "a good   example";
        String string4 = "  ";

        System.out.println(instance.reverseWords(string1));
        System.out.println(instance.reverseWords(string2));
        System.out.println(instance.reverseWords(string3));
        System.out.println(instance.reverseWords(string4));

        System.out.println("====================");
        System.out.println(instance.reverseWords2(string1));
        System.out.println(instance.reverseWords2(string2));
        System.out.println(instance.reverseWords2(string3));
        System.out.println(instance.reverseWords2(string4));
    }

    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        String[] arrays = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = arrays.length - 1; i >= 0; i--) {
            if(arrays[i].length() != 0) {
                builder.append(arrays[i] + " ");
            }
        }

        if(builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    public String reverseWords2(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if(s.charAt(i) == ' ') {
                i--;
                continue;
            }

            int start = s.lastIndexOf(' ', i);
            builder.append(s.substring(start + 1, i + 1));
            builder.append(' ');
            i = start - 1;
        }

        if(builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }
}
