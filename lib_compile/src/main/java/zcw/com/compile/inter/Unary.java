package zcw.com.compile.inter;

import zcw.com.compile.lexer.Token;
import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Unary extends Op {
    public Expr expr;

    public Unary(Token tok, Expr x) {
        super(tok, null);
        expr = x;
        type = Type.max(Type.Int, expr.type);
        if(type == null) {
            error("type error");
        }
    }

    @Override
    public Expr gen() {
        return new Unary(op, expr.reduce());
    }

    @Override
    public String toString() {
        return op.toString() + " " + expr.toString();
    }
}
