package zcw.com.lib_regex;

/**
 * Created by 朱城委 on 2019/3/19.<br><br>
 */
public class Rudolph {
    public static void main(String[] args) {
        for(String pattern : new String[] {"Rudolph", "[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*"}) {
            System.out.println("Rudolph".matches(pattern));
        }
    }
}
