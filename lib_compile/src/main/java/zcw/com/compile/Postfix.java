package zcw.com.compile;

import java.io.IOException;

/**
 * Created by 朱城委 on 2020/5/20.<br><br>
 */
public class Postfix {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.expr();
        System.out.write('\n');
    }
}
