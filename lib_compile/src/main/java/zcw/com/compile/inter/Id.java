package zcw.com.compile.inter;

import zcw.com.compile.lexer.Word;
import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Id extends Expr {
    public int offset;
    public Id(Word id, Type p, int b) {
        super(id, p);
        offset = b;
    }
}
