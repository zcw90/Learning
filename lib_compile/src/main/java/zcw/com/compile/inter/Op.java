package zcw.com.compile.inter;

import zcw.com.compile.lexer.Token;
import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Op extends Expr {
    public Op(Token tok, Type p) {
        super(tok, p);
    }

    @Override
    public Expr reduce() {
        Expr x = gen();
        Temp t = new Temp(type);
        emit(t.toString() + " = " + x.toString());
        return t;
    }
}
