package zcw.com.lib_regex;

/**
 * Created by 朱城委 on 2019/3/19.<br><br>
 */
public class Practice9 {

    public static void main(String[] args) {
        System.out.println(Splitting.knights);

        System.out.println(Splitting.knights.replaceAll("a|e|i|o|u", "_"));
    }
}
