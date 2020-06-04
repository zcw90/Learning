package zcw.com.compile.inter;

import zcw.com.compile.lexer.Word;
import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Temp extends Expr {
    static int count = 0;
    int number = 0;

    public Temp(Type p) {
        super(Word.temp, p);
        number = ++count;
    }

    @Override
    public String toString() {
        return "t" + number;
    }
}
