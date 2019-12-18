package zcw.com.lib_regex;

/**
 * Created by 朱城委 on 2019/3/19.<br><br>
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
        System.out.println("+911".matches("[-+]?\\d+"));
    }
}
