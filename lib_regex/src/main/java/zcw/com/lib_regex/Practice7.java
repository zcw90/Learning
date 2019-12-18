package zcw.com.lib_regex;

/**
 * Created by 朱城委 on 2019/3/19.<br><br>
 */
public class Practice7 {

    public static void main(String[] args) {
        String regex = "[A-Z].*\\.";
        System.out.println(Splitting.knights.matches(regex));

        String string = Splitting.knights + ".";
        System.out.println(string.matches(regex));

        System.out.println(System.currentTimeMillis());
    }
}
