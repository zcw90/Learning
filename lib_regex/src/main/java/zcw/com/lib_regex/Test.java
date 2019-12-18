package zcw.com.lib_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 朱城委 on 2019/3/19.<br><br>
 */
public class Test {
    public static void main(String[] args) {
        String[] array = new String[] {
                "123456",
                "1#gr56",
                "123456789",
                "fdiedielret",
                "sdfs34534fs",
                "34DS_34534fs",
                "EWfs345*gfd$%#34fs",
                "EWfs345*gfd$%# 34fs",
                "`~!@#$%^&*()-_=+\\|]}[{'\";:<,.>/?a4"
        };

        String[] regexArray = new String[] {
                "^.*(?=.{6,})(?=.*\\\\d)(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$",
                "^(?=.*\\\\d)(?=.*[a-zA-Z])(?=.*[\\\\S&&[^a-zA-Z0-9]])[\\\\S]{8,}$",
                "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9\\s])[\\S]{8,}$",
                "^(?=.{8,})(?=.*\\\\d)(?=.*[a-zA-Z])(?=.*[\\\\S&&[^a-zA-Z0-9]])$"
        };

        System.out.println("regex: " + regexArray[2]);
        for(int i = 0; i < array.length; i++) {
            System.out.println();
            System.out.println("String: " + array[i] + "    String-length(" + array[i].length() + ")");
            System.out.println("Match: " + array[i].matches(regexArray[2]));
        }

        String test = "regex represents regular expression";
        String regex = "re(?!g)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(test);
        while (matcher.find()) {
            System.out.println(matcher.group() + "(" + matcher.start() + ", " + (matcher.end() - 1) + ")");
        }
    }
}
