package zcw.com.compile.inter;

import zcw.com.compile.lexer.Token;
import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Arith extends Op {
    public Expr expr1;
    public Expr expr2;

    public Arith(Token tok, Expr x1, Expr x2) {
        super(tok, null);
        expr1 = x1;
        expr2 = x2;
        type = Type.max(expr1.type, expr2.type);

        if(type == null) {
            error("type error");
        }
    }

    @Override
    public Expr gen() {
        return new Arith(op, expr1.reduce(), expr2.reduce());
    }

    @Override
    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString();
    }
}
